#!/bin/bash

echo "Building a Maven package..."
mvn clean package

echo "Building a Docker image..."
docker build -t shiftmanagerserver:1.0 -f Dockerfile .

# Find and delete all previous images of shiftmanagerserver except the new one
old_images=$(docker images -q shiftmanagerserver | grep -v $(docker images -q shiftmanagerserver:1.0))

if [ -n "$old_images" ]; then
    echo "Deleting old Docker images..."
    docker rmi -f $old_images
else
    echo "No old images found."
fi

echo "Docker build complete!"
