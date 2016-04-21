package water_environment;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.restlet.data.MediaType;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

import com.google.gson.Gson;

public class GetWaterEnvironment {

	public String getWaterQualityByPTRspJson(String baseUrl,String accessId,
            String startDate,String endDate,String pointlocation,File file) throws IOException{
	
		String url=baseUrl+"/getWaterQualityByPT";
		Map<String,Object>reqMap=new HashMap<String,Object>();
		
		reqMap.put("accessId", accessId);
		reqMap.put("startDate", startDate);
		reqMap.put("endDate", endDate);
		reqMap.put("pointlocation",pointlocation);
		Gson gson = new Gson();
		String reqJson = gson.toJson(reqMap);
		String response=null;  
		ClientResource clientResource = new ClientResource(url);
		try
		{
		Representation rep = new JsonRepresentation(new JSONObject(reqJson));
		rep.setMediaType(MediaType.APPLICATION_JSON);
		Representation reply = clientResource.post(rep);
		response= reply.getText();
		}
		catch(Exception e)
		{
		e.printStackTrace();
		}
		finally
		{
		clientResource.release();
		}
		FileWriter fileWriter=new FileWriter(file,true);
		WaterEnvironment waterEnvironment=gson.fromJson(response, WaterEnvironment.class);
		WaterEnvironmentInfo[] waterEnvironmentInfo=waterEnvironment.getInfo();
		/*"fractureSurface":"宁-蒙省界",        // 断面情况
        "DO":"9.02",                         // 溶解氧(mg/l)
        "NH3N":"0.90",                       // 氨氮含量(mg/l)
        "CODMn":"3.60",                      // 高锰酸钾化学需氧量(mg/l)
        "drainage":"黄河流域",                // 水系名称
        "pointLocation":"宁夏石嘴山麻黄沟",   // 点位名称
        "ph":"8.64",                         // PH值
        "riverName":"黄河",                  // 河流或湖泊名称
        "preWeekWaterQuality":"Ⅲ",          // 上周水质
        "thisWeekWaterQuality":"Ⅲ",         // 本周水质
        "polluteIndex":"无",                 // 主要污染指标
        "year":"2014",                       // 报告年份
        "week":"47"                          // 报告周数
*/		for(int i=0;i<=waterEnvironmentInfo.length-1;i++){
			fileWriter.write(waterEnvironmentInfo[i].getFractureSurface()+","+waterEnvironmentInfo[i].getDO()
					+","+waterEnvironmentInfo[i].getNH3N()+","+waterEnvironmentInfo[i].getCODMn()
					+","+waterEnvironmentInfo[i].getDrainage()+","+waterEnvironmentInfo[i].getPointLocation()
					+","+waterEnvironmentInfo[i].getPh()+","+waterEnvironmentInfo[i].getRiverName()
					+","+waterEnvironmentInfo[i].getPreWeekWaterQuality()+","+waterEnvironmentInfo[i].getThisWeekWaterQuality()
					+","+waterEnvironmentInfo[i].getPolluteIndex()+","+waterEnvironmentInfo[i].getYear()
					+","+waterEnvironmentInfo[i].getWeek()+"\n");
		}
	fileWriter.close();
		return response;
		}
	
}
