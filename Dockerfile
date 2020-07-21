FROM timbru31/java-node:latest
COPY ./info-weather/target/mavenreactjsspringboot-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080 
CMD ["java" ,"-jar","app.jar"]
