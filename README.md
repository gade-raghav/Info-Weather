# Info-Weather

Info-Weather is a java application which uses Spring-boot framework to get weather information.

## Requirements

* [java](https://java.com/en/download/help/download_options.xml) (tested on openjdk 11.0.6)
* spring-boot framework


# Usage

Clone the repository

Set up an environment variable **WEB_APPID** and map it to APPID which you can get after signing up on [openweathermap](https://home.openweathermap.org/users/sign_up).
Use this [link](https://www.serverlab.ca/tutorials/linux/administration-linux/how-to-set-environment-variables-in-linux/) in case there's an issue in setting up an environment variable.


run the following command on Linux CLI
```bash 
./mvnw spring-boot:run
```

### Proceed only if there are no errors after running the previous command.


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
 
 You can also run this using docker. 
 
 Pull the docker image using the following command on Linux CLI
 ```bash
 docker pull raghavgade/weather-api:9fa91a
 ```
 Run the image that you've pulled using the following command
 ```bash
 docker run --env WEB-APPID={your-api} -p 8080:8080 raghavgade/weather-api:9fa91a
 ```
 After completing the above steps ,following options can be used to get weather information:
 
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
