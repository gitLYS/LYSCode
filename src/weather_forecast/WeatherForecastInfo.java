package weather_forecast;

public class WeatherForecastInfo {
	private String citycode;   	//���б���
	private String cityname;   	//��������
	private String publishTime;	//��������
	private String currentTemp;	//ʵʱ���£��棩
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