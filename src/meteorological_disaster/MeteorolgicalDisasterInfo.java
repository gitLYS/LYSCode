package meteorological_disaster;

public class MeteorolgicalDisasterInfo {
	/*"typhoonNo":"25",               // ̨����
    "name_cn":"���",               // ̨����������
    "name_en":"WUKONG",             // ̨��Ӣ������
    "year":"2012",                  // ���
    "datasource":"�й�������",       // ̨��������Դ
    "details":                      // ̨����ϸ·���б�
*/
	private String typhoonNo;
	private String name_cn;
	private String name_en;
	private String year;
	private String datasource;
	private MeteorolgicalDisasterDetails[] details;
	public String getTyphoonNo() {
		return typhoonNo;
	}
	public String getName_cn() {
		return name_cn;
	}
	public String getName_en() {
		return name_en;
	}
	public String getYear() {
		return year;
	}
	public String getDatasource() {
		return datasource;
	}
	public MeteorolgicalDisasterDetails[] getDetails() {
		return details;
	}
	
	

}
