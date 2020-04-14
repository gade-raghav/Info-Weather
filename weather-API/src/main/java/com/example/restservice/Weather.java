package com.example.restservice;

public class Weather{
	private final long id;
	private final String content;
	private final String weatherstuff;
	
	public Weather(long id, String content, String weatherstuff){
		this.id = id;
		this.content = content;
		this.weatherstuff = weatherstuff;

	}

	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

	public String getWeatherstuff() {
		return weatherstuff;
	}
}
		
