package air_quality;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

import com.google.gson.Gson;

public class GetAirQuality {
	
	
	 public String getCityChemForecastRspJson(String baseUrl,
             String accessId, String citycode,File file)
{
String response = null;

String url = baseUrl + "/getCityChemForecast?citycode="
+ citycode + "&ak=" + accessId;

ClientResource clientResource = new ClientResource(url);
try
{
Representation reply = clientResource.get();
response = reply.getText();
}
catch(Exception e)
{
e.printStackTrace();
}
finally
{
clientResource.release();
}
System.out.println(response);
return response;
}
}
	/* public void getCityChemForecastRspJson(String baseUrl,
              String accessId, String citycode,File file) throws IOException{
	String response=null;
	
	String url = baseUrl + "/getCityChemForecast?citycode="
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
	
	System.out.println(response);
	Gson gson=new Gson();
	AirQuality airQuality=gson.fromJson(response, AirQuality.class);
	AirQualityInfo airQualityInfo=airQuality.getInfo();
	AirQualityForecast[] airQualityForecast=airQualityInfo.getForecast();
    FileWriter fileWriter=new FileWriter(file,true);
	
	for(int i=0;i<airQualityForecast.length;i++){
		fileWriter.write(airQualityInfo.getCitycode()+","+airQualityInfo.getCityName()+","+airQualityInfo.getPublishdate()
		+","+airQualityForecast[i].getNo2_max()+","+airQualityForecast[i].getO3_8h_max()
		+","+airQualityForecast[i].getNo2_min()+","+airQualityForecast[i].getAqi_avg()
		+","+airQualityForecast[i].getO3_min()+","+airQualityForecast[i].getDate()+","+airQualityForecast[i].getCo_max()
		+","+airQualityForecast[i].getO3_max()+","+airQualityForecast[i].getCo_min()+","+airQualityForecast[i].getPm10_max()
		+","+airQualityForecast[i].getSo2_max()+","+airQualityForecast[i].getSo2_min()
		+","+airQualityForecast[i].getPm25_min()+","+airQualityForecast[i].getPm25_max()
		+","+airQualityForecast[i].getO3_8h_min()+","+airQualityForecast[i].getPm10_min()+"\n");
	}
	fileWriter.close();
	
	
	}
}*/
