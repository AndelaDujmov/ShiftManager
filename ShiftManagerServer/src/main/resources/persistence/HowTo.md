# Creating a docker network

- docker network create db_network

# Postgres SQL Docker setup

- cd to your postgres Dockefile
- build the image using docker build . -t postgres_db
- run Postgres container from image : docker run --name db --network db_network postgres_db