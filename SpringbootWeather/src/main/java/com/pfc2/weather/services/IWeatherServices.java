package com.pfc2.weather.services;

import java.util.List;

import com.pfc2.weather.models.WeatherHistory;
import com.pfc2.weather.models.WeatherHistoryRequest;
import com.pfc2.weather.models.WeatherHistoryResponse;

public interface IWeatherServices {
	
	public WeatherHistory getWeather(Double lon,Double lat);
	
	public WeatherHistoryResponse insertWeatherHistory(WeatherHistoryRequest request);

}
