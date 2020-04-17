package com.example.restservice;
import java.io.*;
import java.util.*;
import java.net.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.json.JSONObject;
import org.json.JSONArray;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.bind.annotation.Autowired;
@SpringBootApplication
@RestController
public class WeatherController{

	public String content;
        public String inline;
        public static String key ;
        public static int responseCode;
	public static String blah;

               
	public static void main(String[] args) {
                  SpringApplication.run(WeatherController.class, args);
		  key=System.getenv("WEB_APPID");
		  if (key == null){
			  System.out.print("----------------------------------------------------------------------------------------------------------------------------------------------\nPlease set an environment variable as instructed in the README.md file\n----------------------------------------------------------------------------------------------------------------------------------------------\n");
			  System.exit(1);
			  
                  }
	}


	
        @GetMapping("/weather/current")
        public Weather current(@RequestParam(value="location" )String location) {

		
		
                try {

                String url = "http://api.openweathermap.org/data/2.5/weather?q="+location+"&appid="+key; 
                URL obj = new URL(url);

                HttpURLConnection con = (HttpURLConnection) obj.openConnection();

                responseCode = con.getResponseCode();
                BufferedReader in = new BufferedReader(
                                new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                }
		

                in.close();
                content = response.toString();
                

        } catch (Exception e) {
                System.out.print("\n----------------------------------------------------------------------------------------------------------------------------------------------Location does not exist\nPlease check and try again\n----------------------------------------------------------------------------------------------------------------------------------------------");
		return new Weather("Not Found","Not Found",0,0,0,0,0,0,0,0,0);
        }
       		JSONObject root = new JSONObject(content);
		//coordinates
		JSONObject co = root.getJSONObject("coord");
		//temperature-humidity-pressure
		JSONObject main = root.getJSONObject("main");
		//wind
		JSONObject wind = root.getJSONObject("wind");
		//system
		JSONObject sys = root.getJSONObject("sys");
		
		
		return new Weather(
				 sys.getString("country"),
                                root.getString("name"),
				co.getInt("lat"),
			       	co.getInt("lon"),
				main.getInt("temp"),
				main.getInt("pressure"),
				main.getInt("humidity"),
				wind.getInt("speed"),
				wind.getInt("deg"),
				sys.getLong("sunrise"),
				sys.getLong("sunset")
				);

	}
	
//THIS IS FOR FORECAST WEATHER WHICH REQUIRES A LITTILE EDIT	
 





 
        //return new Weather(String.format(content));


        @GetMapping("/weather/forecast")
        public String forecast(@RequestParam(value="lat")String lat,
                               @RequestParam(value="lon")String lon) {



                 try {

                String url = "http://api.openweathermap.org/data/2.5/onecall?lat="+lat+"&lon="+lon+"&appid="+key; 
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
                System.out.print("\n----------------------------------------------------------------------------------------------------------------------------------------------\nInput Error\nPlease check and try again\n----------------------------------------------------------------------------------------------------------------------------------------------");
                return "Input invalid/incorrect.";
        }

        JSONObject rootf = new JSONObject(content);
        JSONArray daily = rootf.getJSONArray("daily");
        for(int i = 0; i < daily.length(); i ++){
                JSONObject content = daily.getJSONObject(i);
		
		blah=blah+"\n"+i+" : "+content+"\n";

                }

	return String.format("\n"+(rootf.getString("timezone")+blah));






        }
}


@RestController
class MyErrorController implements ErrorController  {

    @GetMapping("/error")
    public String handleError() {
        //do something like logging
        return String.format("Something is really wrong because all the known error related issues have been resolved.In case you see this output please raise an issue in github with all the details.\n Thank you \n-RaghavGade");
    }

    @Override
    public String getErrorPath() {
        return String.format("/error");
    }
}




