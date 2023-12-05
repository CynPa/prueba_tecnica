package com.pfc2.weather.models;

import java.io.Serializable;
import java.util.Date;
import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

//import jakarta.persistence.Entity;
//import jakarta.persistence.Table;
@Entity
//@Entity
@Table(name="weather_history")
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class WeatherHistory implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Double lat;
	private Double lon;
	private String weather;
	private Double tempMin;
	private Double tempMax;
	private Double humidity;
	private Date created;




		
		
		
		
		
		
}
