package pollution_discharge;

public class PollutionDiachargeInfo {
	 /*[{
	        "unit":"万吨",                   // 排放量指标单位
	        "category":"空气污染物排放",      // 指标种类
	        "source":"公众环境研究中心",      // 数据源
	        "province":"江苏",               // 省份
	        "value":"107.4",                 // 排放量指标数值
	        "year":"2009",                   // 年份
	        "type":"废气中污染物排放总量",    // 子指标
	        "pollutant":"二氧化硫"           // 具体污染指标
*/
	 private String unit;
	 private String category;
	 private String source;
	 private String province;
	 private String value;
	 private String year;
	 private String type;
	 private String pollutant;
	public String getUnit() {
		return unit;
	}
	public String getCategory() {
		return category;
	}
	public String getSource() {
		return source;
	}
	public String getProvince() {
		return province;
	}
	public String getValue() {
		return value;
	}
	public String getYear() {
		return year;
	}
	public String getType() {
		return type;
	}
	public String getPollutant() {
		return pollutant;
	}
	 
	 
}
