FROM maven:3.6.0-jdk-11-slim AS build
RUN mvn  -B -f pom.xml clean install lint:check