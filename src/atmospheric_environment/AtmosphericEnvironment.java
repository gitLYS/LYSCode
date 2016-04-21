package atmospheric_environment;
/*{
    "info":
    [{
        "so2_24h":"14",              // 二氧化硫指标24小时均值
        "no2_24h":"27",              // 二氧化氮指标24小时均值
        "so2":"32",                  // 二氧化硫指标实时值
        "co_24h":"0.592",            // 一氧化碳指标24小时均值
        "devid":"2237A",             // 监测站点编号
        "o3":"15",                   // 臭氧指标实时值
        "pmvalue_24h":"40",          // PM2.5指标24小时均值
        "citycode":"101060301",      // 所属城市编号
        "pmvalue":"42",              // PM2.5指标实时值
        "prkey":"颗粒物(PM10)",      // 首要污染物
        "co":"0.79",                 // 一氧化碳指标实时值
        "publishtime":"2015102210"   // 数据发布时间，格式：yyyyMMddHH
        "no2":"44",                  // 二氧化氮指标实时值
        "pm10_24h":"52",             // PM10指标24小时均值
        "aqi":"63",                  // 空气质量指数实时值
        "pm10":"75",                 // PM10指标实时值
        "longitude":"129.502759",    // 监测站点经度
        "latitude":"42.903183",      // 监测站点纬度
        "o3_24h":"83",               // 臭氧指标24小时均值
        "o3_8h_24h":"67",            // 臭氧8小时指标24小时均值
        "o3_8h":"9"                  // 臭氧8小时指标实时值
    },{
        "so2_24h":"13",
        "no2_24h":"46",
        "so2":"17",
        "co_24h":"0.818",
        "devid":"2238A",
        "o3":"8",
        "pmvalue_24h":"57",
        "citycode":"101060301",
        "pmvalue":"119",
        "prkey":"细颗粒物(PM2.5)",
        "co":"1.77",
        "publishtime":"2015102210"
        "no2":"66",
        "pm10_24h":"77",
        "aqi":"156",
        "pm10":"148",
        "longitude":"129.519398",
        "latitude":"42.919804",
        "o3_24h":"81",
        "o3_8h_24h":"61",
        "o3_8h":"6"
    }],
    "resultCode":"0",         // 结果码，0为成功，1为失败
    "resultDesc":"Success"    // 结果描述
}*/
public class AtmosphericEnvironment {
	private String resultCode;
	private String resultDesc;
	private AtmosphericEnvironmentInfo[] info;
	
	public String getResultCode() {
		return resultCode;
	}
	public String getResultDesc() {
		return resultDesc;
	}
	public AtmosphericEnvironmentInfo[] getInfo() {
		return info;
	}
	
}
