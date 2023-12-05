package com.pfc2.weather.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WeatherHistoryResponse {
	private String weather;
	private Double tempMin;
	private Double tempMax;
	private Double humidity;
}
