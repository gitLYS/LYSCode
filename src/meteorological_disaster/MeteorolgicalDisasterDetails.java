package meteorological_disaster;

public class MeteorolgicalDisasterDetails {
	/* "centerWindSpeed":"18",     // ̨�����ķ���(m/s)
     "time":"2012-12-25_08:00",  // ʱ��
     "centerWindPower":"",       // ̨�����ķ���
     "centerPressure":"1000",    // ̨��������ѹ(hPa)
     "cir7radii":"150",          // 7�������뾶(km)
     "type":"2",                 // ����
     "cir10radii":"",            // 10�������뾶(km)
     "y":"10.3",                 // ̨�����ľ���
     "x":"128.6"                 // ̨������γ��
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
