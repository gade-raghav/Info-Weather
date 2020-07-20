package com.example.restservice;

public class Weather{
	private String main;
	private String description;
	private float temp;
	private String country;
	private String city;


	public Weather( String main,String description,String country, String city,float temp){
		this.main=main;
		this.description=description;
		this.country=country;
		this.city=city;
		this.temp=temp;
	}


	public String getMain() {
				return main;
	}

	public String getDescription() {
				return description;
	}

	public String getCountry() {
                return country;
        }

        public  String getCity() {
                return city;
        }
	public float getTemp() {
		return temp;
	}
	 

}
		
