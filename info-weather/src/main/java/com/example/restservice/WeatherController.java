

package com.example.restservice;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class WeatherController{

	public String content;
        public String inline;
        public static String key ;
        public static int responseCode;
        public static int i;

               
	public static void main(String[] args) {
                  SpringApplication.run(WeatherController.class, args);
		  key=System.getenv("WEB_APPID");        
		  if (key == null){
			  System.out.print("\nPlease set an environment variable as instructed in the README.md file\n");
			  System.exit(1);
			  
                  }
	}

 
 
        //Current Weather//
	
        @GetMapping("/weather/current")
	@CrossOrigin(origins="http://localhost:3000")
        public Weather current(@RequestParam(value="location" )String location) {

		
		
                try {
			
			String inputLine;	
                	String url = "http://api.openweathermap.org/data/2.5/weather?q="+location+"&appid="+key; 
                	URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			responseCode = con.getResponseCode();
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
					}

			in.close();
			content = response.toString();
             
		}
		
		catch (Exception e) {
			System.out.print("ERROR : "+e);
			return new Weather("Not Found","Not Found","Not Found","Not Found",0);
        	}
       		
		JSONObject root = new JSONObject(content);
		JSONObject main = root.getJSONObject("main");
		//system
                JSONObject sys = root.getJSONObject("sys");
                //weather
                JSONArray wea = root.getJSONArray("weather");
                JSONObject weas = wea.getJSONObject(0);
		
		return new Weather(
                                weas.getString("main"),
                                weas.getString("description"),
				sys.getString("country"),
                                root.getString("name"),
				main.getInt("temp")
                                );
               
	}

	 
        
        //FORECAST WEATHER//	
 
        @GetMapping("/weather/forecast")
	@CrossOrigin(origins="http://localhost:3000")
        public Weatherforecast forecast(@RequestParam(value="lat")String lat,
                               @RequestParam(value="lon")String lon) {



                 try {
			 
			String inputLine;
			String url = "http://api.openweathermap.org/data/2.5/onecall?lat="+lat+"&lon="+lon+"&exclude=current,hourly,minutely&appid="+key; 
			URL obj = new URL(url);

			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			
			java.lang.StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			 
			in.close();
			content = response.toString();
       		 } 
		catch (Exception e) {
			System.out.print("ERROR : "+e);
			return new Weatherforecast("Not Found","Not Found","Not Found",0,"Not Found","Not Found",0,"Not Found","Not Found",0,"Not Found","Not Found",0,"Not Found","Not Found",0,"Not Found","Not Found",0,"Not Found","Not Found",0);
                
      		}

       		JSONObject rootf = new JSONObject(content);
        	JSONArray daily = rootf.getJSONArray("daily");
                JSONObject content = daily.getJSONObject(0);
                JSONArray weather = content.getJSONArray("weather");
                JSONObject weather0 = weather.getJSONObject(0);
                JSONObject temp = content.getJSONObject("temp");

                JSONObject content1 = daily.getJSONObject(1);
                JSONArray weather1 = content1.getJSONArray("weather");
                JSONObject weather01 = weather1.getJSONObject(0);
                JSONObject temp1 = content1.getJSONObject("temp");

                JSONObject content2 = daily.getJSONObject(2);
                JSONArray weather2 = content2.getJSONArray("weather");
                JSONObject weather02 = weather2.getJSONObject(0);
                JSONObject temp2 = content2.getJSONObject("temp");

                JSONObject content3 = daily.getJSONObject(3);
                JSONArray weather3 = content3.getJSONArray("weather");
                JSONObject weather03 = weather3.getJSONObject(0);
                JSONObject temp3 = content3.getJSONObject("temp");

                JSONObject content4 = daily.getJSONObject(4);
                JSONArray weather4 = content4.getJSONArray("weather");
                JSONObject weather04 = weather4.getJSONObject(0);
                JSONObject temp4 = content4.getJSONObject("temp");

                JSONObject content5 = daily.getJSONObject(5);
                JSONArray weather5 = content5.getJSONArray("weather");
                JSONObject weather05 = weather5.getJSONObject(0);
                JSONObject temp5 = content5.getJSONObject("temp");

                JSONObject content6 = daily.getJSONObject(6);
                JSONArray weather6 = content6.getJSONArray("weather");
                JSONObject weather06 = weather6.getJSONObject(0);
                JSONObject temp6 = content6.getJSONObject("temp");


		
        return new Weatherforecast(
                                rootf.getString("timezone"),
                                weather0.getString("main"),
                                weather0.getString("description"),
                                temp.getInt("day"),

                                weather01.getString("main"),
                                weather01.getString("description"),
                                temp1.getInt("day"),

                                weather02.getString("main"),
                                weather02.getString("description"),
                                temp2.getInt("day"),

                                weather03.getString("main"),
                                weather03.getString("description"),
                                temp3.getInt("day"),

                                weather04.getString("main"),
                                weather04.getString("description"),
                                temp4.getInt("day"),

                                weather05.getString("main"),
                                weather05.getString("description"),
                                temp5.getInt("day"),

                                weather06.getString("main"),
                                weather06.getString("description"),
                                temp6.getInt("day")
                                
                             
	
	);
       
	}
}


        
        
//Error Handling
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
        
