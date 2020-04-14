package com.example.restservice;
import java.io.*;
import java.util.*;
import java.net.*;


import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController{

        public int code;
        public String content;
        public String inline;
        public static final String templateC = "Weather Information\nLocation: %s  \n";
        public static final String templateF= "Weather Information \n \n";



        @GetMapping("/weather/current")
        public Weather current(@RequestParam(value="location" )String location) {


                try {

                String url = "http://api.openweathermap.org/data/2.5/weather?q="+location+"&appid=48e5230c17044561ca546f13e603e88c";
                URL obj = new URL(url);

                HttpURLConnection con = (HttpURLConnection) obj.openConnection();

                int responseCode = con.getResponseCode();
                BufferedReader in = new BufferedReader(
                                new InputStreamReader(con.getInputStream()));
                String inputLine;
                java.lang.StringBuffer response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                }

                in.close();
                content = response.toString();
                

        } catch (Exception e) {
                System.out.println("Error: "+e);
        }
        
	
	
        return new Weather(String.format(content));

        }

        @GetMapping("/weather/forecast")
        public Weather forecast(@RequestParam(value="lat")String lat,
                               @RequestParam(value="lon")String lon) {



                 try {

                String url = "http://api.openweathermap.org/data/2.5/onecall?lat="+lat+"&lon="+lon+"&appid=48e5230c17044561ca546f13e603e88c";
                URL obj = new URL(url);

                HttpURLConnection con = (HttpURLConnection) obj.openConnection();

                int responseCode = con.getResponseCode();
                BufferedReader in = new BufferedReader(
                                new InputStreamReader(con.getInputStream()));
                String inputLine;
                java.lang.StringBuffer response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                }
                in.close();
                content = response.toString();

        } catch (Exception e) {
                System.out.println("Error: "+e);
        }

        return new Weather(String.format(content));

        //return String.format("Weather Information: "+content+"\n");

        }
/*@RestController
public class MyErrorController implements ErrorController  {

    @GetMapping("/error")
    public String handleError() {
        //do something like logging
        return String.format("error"+code+content);
    }

    @Override
    public String getErrorPath() {
        return String.format("/error");
    }
}
*/

}
