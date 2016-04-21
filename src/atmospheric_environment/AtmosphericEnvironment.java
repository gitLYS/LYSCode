package atmospheric_environment;
/*{
    "info":
    [{
        "so2_24h":"14",              // ��������ָ��24Сʱ��ֵ
        "no2_24h":"27",              // ��������ָ��24Сʱ��ֵ
        "so2":"32",                  // ��������ָ��ʵʱֵ
        "co_24h":"0.592",            // һ����ָ̼��24Сʱ��ֵ
        "devid":"2237A",             // ���վ����
        "o3":"15",                   // ����ָ��ʵʱֵ
        "pmvalue_24h":"40",          // PM2.5ָ��24Сʱ��ֵ
        "citycode":"101060301",      // �������б��
        "pmvalue":"42",              // PM2.5ָ��ʵʱֵ
        "prkey":"������(PM10)",      // ��Ҫ��Ⱦ��
        "co":"0.79",                 // һ����ָ̼��ʵʱֵ
        "publishtime":"2015102210"   // ���ݷ���ʱ�䣬��ʽ��yyyyMMddHH
        "no2":"44",                  // ��������ָ��ʵʱֵ
        "pm10_24h":"52",             // PM10ָ��24Сʱ��ֵ
        "aqi":"63",                  // ��������ָ��ʵʱֵ
        "pm10":"75",                 // PM10ָ��ʵʱֵ
        "longitude":"129.502759",    // ���վ�㾭��
        "latitude":"42.903183",      // ���վ��γ��
        "o3_24h":"83",               // ����ָ��24Сʱ��ֵ
        "o3_8h_24h":"67",            // ����8Сʱָ��24Сʱ��ֵ
        "o3_8h":"9"                  // ����8Сʱָ��ʵʱֵ
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
        "prkey":"ϸ������(PM2.5)",
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
    "resultCode":"0",         // ����룬0Ϊ�ɹ���1Ϊʧ��
    "resultDesc":"Success"    // �������
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
