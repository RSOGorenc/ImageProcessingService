#
# Build stage
#
FROM maven:3.6.0-jdk-11-slim AS build

COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#

FROM openjdk:11-jre-slim

COPY --from=build /home/app/target/processing-microservice-1.0.0.jar /usr/local/lib/processing-microservice.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","/usr/local/lib/processing-microservice.jar"]