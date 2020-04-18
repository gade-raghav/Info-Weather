FROM openjdk:8u252-jre-slim-buster
MAINTAINER gaderaghav5@gmail.com 
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
