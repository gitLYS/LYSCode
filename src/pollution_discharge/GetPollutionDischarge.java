package pollution_discharge;

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

public class GetPollutionDischarge {
	
	
	
	
	   public void getDischargeByCategoryRspJson(String baseUrl,String accessId,
               String year,String province,String category,File file) throws IOException
		{
			String url=baseUrl+"/getDischargeByCategory";
			Map<String,Object> reqMap = new HashMap<String,Object>();
			reqMap.put("accessId", accessId);
			reqMap.put("year", year);
			reqMap.put("province", province);
			reqMap.put("category", category);
			Gson gson = new Gson();
			
			String reqJson = gson.toJson(reqMap);
			String response=null;  
			ClientResource clientResource = new ClientResource(url);
		try{
			Representation rep = new JsonRepresentation(new JSONObject(reqJson));
			rep.setMediaType(MediaType.APPLICATION_JSON);
			Representation reply = clientResource.post(rep);
			response= reply.getText();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			clientResource.release();
		}
		
		
		PollutionDiacharge pollutionDiacharge=gson.fromJson(response, PollutionDiacharge.class);
		PollutionDiachargeInfo[] pollutionDiachargeInfo=pollutionDiacharge.getInfo();
		
		try{
		FileWriter fileWriter=new FileWriter(file, true);
		for(int i=0;i<pollutionDiachargeInfo.length;i++){
			fileWriter.write(pollutionDiachargeInfo[i].getUnit()+","+pollutionDiachargeInfo[i].getCategory()
		+","+pollutionDiachargeInfo[i].getSource()+","+pollutionDiachargeInfo[i].getProvince()+","+pollutionDiachargeInfo[i].getValue()
		+","+pollutionDiachargeInfo[i].getYear()+","+pollutionDiachargeInfo[i].getType()+","+pollutionDiachargeInfo[i].getPollutant()+"\n");
		}
		fileWriter.close();
		}catch(Exception e){
			System.out.println("暂无污染物数据或者输入城市名称、污染物种类错误");
			
		}
		
		
	}
		
}
	  
	   
	   
	   
	   

