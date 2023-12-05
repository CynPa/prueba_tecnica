package com.pfc2.weather.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

//import org.springframework.web.client.RestTemplate;
import com.pfc2.weather.models.WeatherHistory;
import com.pfc2.weather.models.WeatherHistoryRequest;
import com.pfc2.weather.models.WeatherHistoryResponse;
import com.pfc2.weather.repositorio.WeatherRepositorio;

@Service
public class WeatherService implements IWeatherServices {

	@Autowired
	private RestTemplate clienteRest;

	@Autowired
	private WeatherRepositorio repositorio;
	
	
	@Value("${value.openweather.token}")String token;


	@Override
	public WeatherHistory getWeather(Double lat, Double lon) {

		return repositorio.getHistory(lat, lon);
	}

	@Override
	public WeatherHistoryResponse insertWeatherHistory(WeatherHistoryRequest request) {
		WeatherHistoryResponse weatherResponse=null;
		if(request.getLat()!=null&& request.getLon()!=null)
		{
			
			WeatherHistory whistory= repositorio.getHistory(request.getLat(), request.getLon());
			Date fecha=new Date();
			long diff=0;
			String obj=clienteRest.getForObject("https://api.openweathermap.org/data/2.5/weather?lat="+request.getLat()+"&lon="+request.getLon()+"&appid="+token,String.class);
			JSONObject myJson =new  JSONObject(obj);
			System.out.println(obj);
			
			String weather=myJson.getJSONArray("weather").getJSONObject(0).getString("main");
			Double tempMin=myJson.getJSONObject("main").getDouble("temp_min");
			Double tempMax=myJson.getJSONObject("main").getDouble("temp_max");
			Double humidity=myJson.getJSONObject("main").getDouble("humidity");
			if(whistory!=null)
			{
				long elapsedms = fecha.getTime()-whistory.getCreated().getTime() ;
	            diff = TimeUnit.MINUTES.convert(elapsedms, TimeUnit.MILLISECONDS);
                  System.out.println("diferencia de tiempo: "+diff);
                  if(diff>10)
                  {
                	  whistory.setCreated(new Date());
                  }
                  weatherResponse=WeatherHistoryResponse.builder()
							.humidity(humidity)
							.tempMax(tempMax)
							.tempMin(tempMin)
							.weather(weather)
							.build();
                  repositorio.save(whistory);
                  
			}
			else {
				WeatherHistory weatherInsert =WeatherHistory.builder()
						.lat(request.getLat())
						.lon(request.getLon())
						.tempMax(tempMax)
						.tempMin(tempMin)
						.humidity(humidity).created(new Date())
						.weather(weather).build();
				repositorio.save(weatherInsert);
				}
				

					
				
				weatherResponse=WeatherHistoryResponse.builder()
						.humidity(humidity)
						.tempMax(tempMax)
						.tempMin(tempMin)
						.weather(weather)
						.build();
				
			}
			
		return weatherResponse;
	}





}
