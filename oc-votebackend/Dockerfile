# Start with a base image containing wildfly image
FROM openjdk:8-jdk-alpine

# Add Maintainer Info
LABEL maintainer="linic@tw.ibm.com"

# The path to deployment jar file 
ARG SERVICE_JAR_FILE_NAME=service.jar

# The path to application's jar file 
ARG SRC_JAR_FILE=target/service-1.0.jar

# The application name
ARG APP_NAME="APP_NAME(NOT PROVIDED)"

# The application version
ARG APP_VERSION="APP_VERSION(NOT PROVIDED)"

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8080 available to the world outside this container
EXPOSE 8080
EXPOSE 8762

#Path to deployment root 
ENV DEPLOYMENT_ROOT /opt
RUN mkdir -p ${DEPLOYMENT_ROOT}

RUN echo "${DEPLOYMENT_ROOT}/${SERVICE_JAR_FILE_NAME}"

# Add the application's jar to the container deployment path
ADD ${SRC_JAR_FILE} "${DEPLOYMENT_ROOT}/${SERVICE_JAR_FILE_NAME}"

ENV DEPLOYMENT_JAR_FILE_NAME ${SERVICE_JAR_FILE_NAME}

ENV APP_NAME ${APP_NAME}
ENV APP_VERSION ${APP_VERSION}

# Run the jar file 
ENTRYPOINT "java" "-Djava.security.egd=file:/dev/./urandom" "-jar" "${DEPLOYMENT_ROOT}/${DEPLOYMENT_JAR_FILE_NAME}" "${APP_NAME}" "${APP_VERSION}"
