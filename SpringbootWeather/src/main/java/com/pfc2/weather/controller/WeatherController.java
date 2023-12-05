package com.pfc2.weather.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParser;
import com.pfc2.weather.models.WeatherError;
import com.pfc2.weather.models.WeatherHistory;
import com.pfc2.weather.models.WeatherHistoryRequest;
import com.pfc2.weather.models.WeatherHistoryResponse;
import com.pfc2.weather.services.WeatherService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class WeatherController {

	@Autowired
	private WeatherService servicio;

    private static final Logger logger = LoggerFactory.getLogger(WeatherController.class);

	
	@PostMapping("/api/v1/weather")
	public ResponseEntity<Object> test(@RequestBody WeatherHistoryRequest request) {

		String[] errorArray = new String[1];
		try {
			logger.info("=============inicio /api/v1/weather ================== ");
			logger.info("=============Envio a servicio: lat:"+request.getLat()+" lon:"+request.getLon()+"================== ");
			WeatherHistoryResponse history = servicio.insertWeatherHistory(request);
			if (history != null) {
				return ResponseEntity.status(HttpStatus.CREATED).body(history);
			} else {
				logger.error("=============Bad Request lat:"+request.getLat()+" lon:"+request.getLon()+"================== ");
				errorArray[0] = "Bad Request";
				WeatherError error = WeatherError.builder().code("400").errors(errorArray).build();
				return ResponseEntity.badRequest().body(error);
			}
		} catch (Exception e) {
			logger.error("=============Internal Server Error :"+request.getLat()+" lon:"+request.getLon()+"================== ");
			logger.error(e.toString());


			errorArray[0] = "InternalServerError";
			WeatherError error = WeatherError.builder().code("503").errors(errorArray).build();
			return ResponseEntity.internalServerError().body(error);
		}

	}

	@GetMapping("/api/v1/weather/history/{latitud}/{longitud}")
	public ResponseEntity<Object> getWeather(
			@PathVariable Double latitud,
			@PathVariable Double longitud) {
		logger.info("=============inicio /api/v1/weather/history latitud:"+latitud+" longitud:"+longitud+" ================== ");

		WeatherHistory history=servicio.getWeather(latitud, longitud);
		String[] errorArray = new String[1];
		if(history!=null)
		{
			return ResponseEntity.ok(history); 
		}
		else
		{
			logger.error("=============Not Found /api/v1/weather/history latitud:"+latitud+" longitud:"+longitud+" ================== ");

			errorArray[0] = "NotFound";
			WeatherError error = WeatherError.builder().code("404").errors(errorArray).build();
			return  ResponseEntity.notFound().build().ok(error);
		}
	}
	@GetMapping("/sys/status")
	public String getStatus()
	{
		return  ResponseEntity.ok().build().getStatusCode().toString();
	}
}
