FROM openjdk:11-jre-slim

COPY /target/processing-microservice-1.0.0.jar /usr/local/lib/processing-microservice.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","/usr/local/lib/processing-microservice.jar"]