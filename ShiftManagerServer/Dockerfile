# Use a base image with Java runtime
FROM eclipse-temurin:21-jre as builder

  # Set the argument for the JAR file
ARG JAR_FILE=target/ShiftManagerServer-1.0-SNAPSHOT.jar
ARG USERNAME=shiftmanager

  # Create a non-root user and group for security
RUN groupadd -g 1100 ${USERNAME} && \
    useradd -u 1100 -g ${USERNAME} -d /home/${USERNAME} -m -s /sbin/nologin -c "Shift Manager user" ${USERNAME}

  # Set working directory for the application
WORKDIR /home/${USERNAME}

  # Copy the application JAR to the working directory and set permissions
COPY ${JAR_FILE} app.jar
RUN chmod 744 app.jar && chown ${USERNAME}:${USERNAME} app.jar

  # Switch to the non-root user
USER ${USERNAME}

  # Expose the application port
EXPOSE 8080

  # Start the application
ENTRYPOINT ["java", "-jar", "/home/shiftmanager/app.jar"]