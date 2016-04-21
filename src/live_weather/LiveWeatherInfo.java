package live_weather;

public class LiveWeatherInfo {
	 /*"citycode":"101010100",            // 城市编码
     "windspeed":"2.3m/s",              // 风速
     "phenomena":"晴",                  // 天气状况
     "airpressure":"1024",              // 大气压
     "humidity":"69",                   // 湿度(%)
     "updatetime":"2015-12-24 12:00",   // 更新时间
     "windpower":"微风",                // 风力
     "feelst":"-0.1",                   // 体感温度(℃)
     "winddirect":"东北风",             // 风向
     "weekofday":"4",                   // 星期几，0代表周日
     "rain":"0.0",                      // 降雨量(mm)
     "temperature":"2.4"                // 气温(℃)
*/
	
	private String citycode;
	private String windspeed;
	private String phenomena;
	private String airpressure;
	private String humidity;
	private String updatetime;
	private String windpower;
	private String feelst;
	private String winddirect;
	private String weekofday;
	private String rain;
	private String temperature;
	public String getCitycode() {
		return citycode;
	}
	public String getWindspeed() {
		return windspeed;
	}
	public String getPhenomena() {
		return phenomena;
	}
	public String getAirpressure() {
		return airpressure;
	}
	public String getHumidity() {
		return humidity;
	}
	public String getUpdatetime() {
		return updatetime;
	}
	public String getWindpower() {
		return windpower;
	}
	public String getFeelst() {
		return feelst;
	}
	public String getWinddirect() {
		return winddirect;
	}
	public String getWeekofday() {
		return weekofday;
	}
	public String getRain() {
		return rain;
	}
	public String getTemperature() {
		return temperature;
	}
	
	
}
