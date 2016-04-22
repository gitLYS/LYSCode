package atmospheric_environment;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

import com.google.gson.Gson;

public class GetAtmosphericAnvironment {
	public String getRealtimeAirInfoGetRsp(String baseUrl, String accessId,
             String citycode,File file) throws IOException{
	String response = null;
	
	String url = baseUrl + "/getRealtimeAir?citycode="
	+ citycode + "&ak=" + accessId;
	
	ClientResource clientResource = new ClientResource(url);
	try{
	Representation reply = clientResource.get();
	response = reply.getText();
	}
	catch(Exception e){
	e.printStackTrace();
	}
	finally{
	clientResource.release();
	}
	
	try{
	FileWriter fileWriter=new FileWriter(file,true);
	Gson gson=new Gson();
	AtmosphericEnvironment atmosphericEnvironment=gson.fromJson(response, AtmosphericEnvironment.class);
	AtmosphericEnvironmentInfo[] info=atmosphericEnvironment.getInfo();
	
	for(int i=0;i<=info.length-1;i++){
		
				fileWriter.write(info[i].getSo2_24h()+","+info[i].getNo2_24h()+","+info[i].getSo2()+","+info[i].getCo_24h()
				+","+info[i].getDevid()+","+info[i].getO3()+","+info[i].getPmvalue_24h()+","+info[i].getCitycode()
				+","+info[i].getPrkey()+","+info[i].getCo()+","+info[i].getPublishtime()+","+info[i].getNo2()
				+","+info[i].getPm10_24h()+","+info[i].getAqi()+","+info[i].getPm10()+","+info[i].getLongtude()
				+","+info[i].getLatitude()+","+info[i].getO3_24h()+","+info[i].getO3_8h_24h()+","+info[i].getO3_8h()+"\n");
	}
	fileWriter.close();
	}catch(Exception e){
		e.printStackTrace();
	}
	
	return response;
	}   
}
