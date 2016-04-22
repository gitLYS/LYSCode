package meteorological_disaster;

public class MeteorolgicalDisasterDetails {
	/* "centerWindSpeed":"18",     // 台风中心风速(m/s)
     "time":"2012-12-25_08:00",  // 时间
     "centerWindPower":"",       // 台风中心风力
     "centerPressure":"1000",    // 台风中心气压(hPa)
     "cir7radii":"150",          // 7级风力半径(km)
     "type":"2",                 // 类型
     "cir10radii":"",            // 10级风力半径(km)
     "y":"10.3",                 // 台风中心经度
     "x":"128.6"                 // 台风中心纬度
*/
	private String centerWindSpeed;
	private String  time;
	private String centerWindPowe;
	private String centerPressure;
	private String cir7radii;
	private String type;
	private String cir10radii;
	private String y;
	private String x;
	public String getCenterWindSpeed() {
		return centerWindSpeed;
	}
	public String getTime() {
		return time;
	}
	public String getCenterWindPowe() {
		return centerWindPowe;
	}
	public String getCenterPressure() {
		return centerPressure;
	}
	public String getCir7radii() {
		return cir7radii;
	}
	public String getType() {
		return type;
	}
	public String getCir10radii() {
		return cir10radii;
	}
	public String getY() {
		return y;
	}
	public String getX() {
		return x;
	}
	
}
