package com.example.restservice;
import java.io.*;
import java.util.*;
import java.net.*;


import org.json.JSONObject;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.bind.annotation.Autowired;
@RestController
public class WeatherController{


/*	@Autowired
	private RestTemplate restTemplate;
*/
	
        public int code;
        public String content;
        public String inline;
	public String key = System.getenv("WEB_APPID");
	
        @GetMapping("/weather/current")
        public Weather current(@RequestParam(value="location" )String location) {

		
		
		
		/*String url = "http://api.openweathermap.org/data/2.5/weather?q="+location+"&appid=48e5230c17044561ca546f13e603e88c";
		Object[] objects = restTemplate.getForObject(url,Object[].class);
		
		return Array.asList(objects);
	}
}
*/
                try {

                String url = "http://api.openweathermap.org/data/2.5/weather?q="+location+"&appid="+key; 
                URL obj = new URL(url);

                HttpURLConnection con = (HttpURLConnection) obj.openConnection();

                int responseCode = con.getResponseCode();
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
                System.out.println("Error: "+e);
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
		
		
		return new Weather(co.getInt("lat"),
			       	co.getInt("lon"),
				main.getInt("temp"),
				main.getInt("pressure"),
				main.getInt("humidity"),
				wind.getInt("speed"),
				wind.getInt("deg"),
				sys.getString("country"),
				root.getString("name"),
				sys.getLong("sunrise"),
				sys.getLong("sunset")
				);

	}
}
	
//THIS IS FOR FORECAST WEATHER WHICH REQUIRES A LITTILE EDIT	
 





 
        //return new Weather(String.format(content));


        /*@GetMapping("/weather/forecast")
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

        }*/
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

}

*/


