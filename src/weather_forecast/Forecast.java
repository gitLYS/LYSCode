package weather_forecast;

public class Forecast {
	private String hightemp;	//最高温度
	private String fengxiang;	//风向
	private String lowtemp;		//最低温度
	private String fengli;		//风力
	private String date;		//预报日期
	private String type;		//天气状况
	private String week;		//星期几
	
	
	public String getHightemp() {
		return hightemp;
	}
	
	public String getFengxiang() {
		return fengxiang;
	}
	
	public String getLowtemp() {
		return lowtemp;
	}
	
	public String getFengli() {
		return fengli;
	}
	
	public String getDate() {
		return date;
	}
	
	public String getType() {
		return type;
	}
	
	public String getWeek() {
		return week;
	}
	public void setWeek(String week) {
		this.week = week;
	}
	
	
	
}
