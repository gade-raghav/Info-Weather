FROM adoptopenjdk/openjdk11:ppc64le-debianslim-jre11u-nightly
MAINTAINER gaderaghav5@gmail.com 
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
