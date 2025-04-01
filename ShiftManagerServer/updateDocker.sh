#!/bin/bash

echo "Delete old images.."
docker image prune -f
docker container prune -f

echo "Building a Maven package..."
mvn clean package

echo "Building a Docker image..."
docker build -t shiftmanagerserver:1.0 -f Dockerfile .

echo "Docker build complete!"
