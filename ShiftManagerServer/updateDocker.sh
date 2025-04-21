#!/bin/bash

date_limit=$(date --date="1 month ago" +%s)

# List all images
docker images --format "{{.Repository}}:{{.Tag}} {{.CreatedAt}} {{.ID}}" | while read image
do
  # Extract image details
  repo_tag=$(echo $image | awk '{print $1}')
  created_at=$(echo $image | awk '{print $2 " " $3 " " $4}')
  image_id=$(echo $image | awk '{print $5}')

  # Convert the created date to Unix timestamp
  created_timestamp=$(date --date="$created_at" +%s)

  # Check if image is older than 1 month
  if [ $created_timestamp -lt $date_limit ]; then
    echo "Deleting image: $repo_tag"
    docker rmi $image_id
  else
    # Archive image (e.g., save as tar)
    echo "Archiving image: $repo_tag"
    docker save -o "/path/to/archive/$repo_tag.tar" $repo_tag
  fi
done

echo "Building a Maven package..."
mvn clean package

echo "Building a Docker image..."
docker build -t shiftmanagerserver:1.0 -f Dockerfile .

echo "Docker build complete!"

docker-compose up -d

echo "Waiting for the app to start..."
sleep 10  # Optional delay

docker-compose logs shift-image | tail -n 30


docker exec -it db psql -U postgres -d shiftmanagerdb
