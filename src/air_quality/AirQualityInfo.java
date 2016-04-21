package air_quality;

public class AirQualityInfo {
	/*"citycode":"101010100",         // 城市编号
    "cityname":"北京",              // 城市名称
    "publishdate":"2016-03-31",     // 数据发布日期
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
