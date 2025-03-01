FROM postgres:14.3

#Copy the content of sql file to the special Docker directory for databases
COPY init.sql /docker-entrypoint-initdb.d/

ENV POSTGRES_DB shiftmanager
ENV POSTGRES_USER root
ENV POSTGRES_PASSWORD code