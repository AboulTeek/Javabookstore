FROM maven:3.6.0-jdk-11-slim AS build
COPY WebContent /usr/src/app/WebContent
COPY pom.xml /usr/src/app
RUN mvn  -B -f ./pom.xml clean install lint:check