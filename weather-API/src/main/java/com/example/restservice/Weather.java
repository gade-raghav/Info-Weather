package com.example.restservice;

public class Weather{
	private float lat;
	private float lon;
	private float temp;
	private float pressure;
	private float humidity;
	private float speed;
	private float deg;
	private String country;
	private String city;
	private long sunrise;
	private long sunset;


	public Weather( String country, String city,float lat,float lon, float temp, float pressure, float humidity, float speed, float deg, long sunrise, long sunset){
		this.country=country;
		this.city=city;
		this.lat=lat;
		this.lon=lon;
		this.temp=temp;
		this.pressure=pressure;
		this.humidity=humidity;
		this.speed=speed;
		this.deg=deg;
		this.sunrise=sunrise;
		this.sunset=sunset;
	}

	 public String getCountry() {
                return country;
        }

        public  String getCity() {
                return city;
        }


	public float getLat() {
		return lat;

	}
	public float getLon() {
		return lon;
	}
	
	public float getTemp() {
		return temp;
	}
	 
	public float getPressure() {
		return pressure;
	}

	public float getHumidity() {
		return humidity;
	}
	public float getSpeed() {
		return speed;
	}
	public float getDeg() {
		return deg; 
	}

        public long getSunrise() {
                return sunrise;
        }
        public long getSunset() {
                return sunset;
        }

}
		
