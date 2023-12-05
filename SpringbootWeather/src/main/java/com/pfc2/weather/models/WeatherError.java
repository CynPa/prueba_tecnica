package com.pfc2.weather.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class WeatherError {
	
	private String code;
	private String[] errors;
	

}
