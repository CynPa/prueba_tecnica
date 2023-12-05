package com.pfc2.weather.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pfc2.weather.models.WeatherHistory;

public interface WeatherRepositorio extends JpaRepository<WeatherHistory, Long>{

	
	@Query(value = "select * from weather_history where lat=:lat and lon =:lon",nativeQuery = true)
	public WeatherHistory getHistory(@Param("lat") Double  lat,@Param("lon") Double lon);
}
