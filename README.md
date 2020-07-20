# Info-Weather

Info-Weather is a java application which uses Spring-boot framework to get weather information.

## Requirements

* [java](https://java.com/en/download/help/download_options.xml) (tested on openjdk 11.0.6)
* spring-boot framework
* [node](https://nodejs.org/en/download/) (v12.16.1)
* [npm](https://www.npmjs.com/package/download) (6.14.4)
* [docker](https://docs.docker.com/get-docker/)(makes it easier)


# Usage

Clone the repo

Set up an environment variable **WEB_APPID** and map it to APPID which you can get after signing up on [openweathermap](https://home.openweathermap.org/users/sign_up).
Use this [link](https://www.serverlab.ca/tutorials/linux/administration-linux/how-to-set-environment-variables-in-linux/) in case there's an issue in setting up an environment variable.


run the following command on Linux CLI 
```bash 
cd info-weather
./mvnw spring-boot:run
```

alternatively you can build a jar package and run the jar file.
```bash
cd info-weather
./mvnw clean package     #to create jar package and remove the existing one
java -jar target/mavenreactjsspringboot-0.0.1-SNAPSHOT.jar
```

## Proceed only if there are no errors after running the previous command.

### GUI Interface

go to http://localhost:8080 and thats it !!

### Terminal

* #### Current Weather

You can make a curl request 
```bash
curl "http://localhost:8080/weather/current?location={city name}"
```
You can enter the following url with required parameters in browser.

```bash
http://localhost:8080/weather/current?location={city name}
```

* #### Forecast Weather

You can make a curl request 
```bash
curl "http://localhost:8080/weather/forecast?lat={latitude}&lon={longitude}"
```
You can enter the following url with required parameters in browser.

```bash
http://localhost:8080/weather/forecast?lat={latitude}&lon={longitude}
```

## Run using Docker
 
 You can also run this using **docker**.
 
 after cloning the repo , build the image and run it.
 
 ```bash
 docker build -t {your-ideal-image-name} . # to-build
```
 
 ```bash
 docker run --env WEB_APPID=$WEB_APPID -p 8080:8080 --name {use-creativity} -d {your-ideal-image-name}
 ```
   
 After completing the above steps ,following options can be used to get weather information:
  
### GUI Interface

go to http://localhost:8080 and thats it !!

### Terminal

* #### Current Weather

You can make a curl request 
```bash
curl "http://localhost:8080/weather/current?location={city name}"
```
You can enter the following url with required parameters in browser.

```bash
http://localhost:8080/weather/current?location={city name}
```

* #### Forecast Weather

You can make a curl request 
```bash
curl "http://localhost:8080/weather/forecast?lat={latitude}&lon={longitude}"
```
You can enter the following url with required parameters in browser.

```bash
http://localhost:8080/weather/forecast?lat={latitude}&lon={longitude}
```

 

## Acknowledgement

Thanks to [openweathermap api](https://openweathermap.org/api)

Thanks to timbru31 for [java-nodejs](https://hub.docker.com/r/timbru31/java-node/) docker image
