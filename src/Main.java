
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

import air_quality.GetAirQuality;
import atmospheric_environment.GetAtmosphericAnvironment;
import city_location.GetCityLocation;
import earth_quake.GetEarthquake;
import historical_weather.GetHistoricalWeather;
import live_weather.GetLiveWeather;
import meteorological_disaster.GetMeteorologicalDisaster;
import pollution_discharge.GetPollutionDischarge;
import water_environment.GetWaterEnvironment;
import weather_forecast.GetWeatherForcast;

public class Main {
	
	public static void main(String[] args) throws Exception {

		WeatherForecastThread weatherForecastThread=new WeatherForecastThread();
		HisoricalWeatherThread hisoricalWeatherThread=new HisoricalWeatherThread();
		LiveWeaterThread liveWeaterThread=new LiveWeaterThread();
		WaterEnvironmentThread waterEnvironmentThread=new WaterEnvironmentThread();
		AtmosphericEnvironmentThread atmosphericEnvironmentThread=new AtmosphericEnvironmentThread();
		AirQualityThread airQualityThread=new AirQualityThread();
		EarthQuakeThread earthQuakeThread=new EarthQuakeThread();
		CityLocationThread cityLocationThread=new CityLocationThread();
		MeteorologicalDisasterThread meteorologicalDisasterThread=new MeteorologicalDisasterThread();
		PollutionDischargeThread pollutionDischargeThread=new PollutionDischargeThread();
		
		weatherForecastThread.start();
		hisoricalWeatherThread.start();
		liveWeaterThread.start();
		waterEnvironmentThread.start();
		atmosphericEnvironmentThread.start();
		airQualityThread.start();
		earthQuakeThread.start();
		cityLocationThread.start();
		meteorologicalDisasterThread.start();
		pollutionDischargeThread.start();
	}

}


