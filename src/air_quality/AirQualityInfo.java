package air_quality;

public class AirQualityInfo {
	/*"citycode":"101010100",         // ���б��
    "cityname":"����",              // ��������
    "publishdate":"2016-03-31",     // ���ݷ�������
    "forecast":*/
	private String citycode;
	private String cityname;
	private String publishdate;
	private AirQualityForecast[] forecast;
	public String getCitycode() {
		return citycode;
	}
	public String getCityName() {
		return cityname;
	}
	public String getPublishdate() {
		return publishdate;
	}
	public AirQualityForecast[] getForecast() {
		return forecast;
	}

}
