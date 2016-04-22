package meteorological_disaster;

public class MeteorolgicalDisasterInfo {
	/*"typhoonNo":"25",               // 台风编号
    "name_cn":"悟空",               // 台风中文名称
    "name_en":"WUKONG",             // 台风英文名称
    "year":"2012",                  // 年份
    "datasource":"中国天气网",       // 台风数据来源
    "details":                      // 台风详细路径列表
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
