package live_weather;

public class LiveWeatherInfo {
	 /*"citycode":"101010100",            // ���б���
     "windspeed":"2.3m/s",              // ����
     "phenomena":"��",                  // ����״��
     "airpressure":"1024",              // ����ѹ
     "humidity":"69",                   // ʪ��(%)
     "updatetime":"2015-12-24 12:00",   // ����ʱ��
     "windpower":"΢��",                // ����
     "feelst":"-0.1",                   // ����¶�(��)
     "winddirect":"������",             // ����
     "weekofday":"4",                   // ���ڼ���0��������
     "rain":"0.0",                      // ������(mm)
     "temperature":"2.4"                // ����(��)
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
