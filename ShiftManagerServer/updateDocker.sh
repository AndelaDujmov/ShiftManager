#!/bin/bash

echo "Building a maven package"
mvn clean package
echo "Building a Docker image"
docker build -t shiftmanagerserver:1.0 -f Dockerfile .