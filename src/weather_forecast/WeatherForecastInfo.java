package weather_forecast;

public class WeatherForecastInfo {
	private String citycode;   	//城市编码
	private String cityname;   	//城市名称
	private String publishTime;	//发布日期
	private String currentTemp;	//实时气温（℃）
	private Forecast[] forecast;
	
	
	
	public String getCitycode() {
		return citycode;
	}
	public String getCityname() {
		return cityname;
	}
	public String getPublishTime() {
		return publishTime;
	}
	public String getCurrentTemp() {
		return currentTemp;
	}
	public Forecast[] getForecast() {
		return forecast;
	}
	
	

	
	
	
	
}