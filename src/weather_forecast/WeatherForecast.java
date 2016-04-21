package weather_forecast;


public class WeatherForecast {
	private String resultCode;
	private String resultDesc;
	private WeatherForecastInfo info;
	
	public String getResultCode() {
		return resultCode;
	}
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	public String getResultDesc() {
		return resultDesc;
	}
	public void setResultDesc(String resultDesc) {
		this.resultDesc = resultDesc;
	}
	public WeatherForecastInfo getInfo() {
		return info;
	}
	public void setInfo(WeatherForecastInfo info) {
		this.info = info;
	}
	
	
	
}
