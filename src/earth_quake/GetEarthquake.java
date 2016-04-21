package earth_quake;


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

public class GetEarthquake {
	  public String getEarthquakesRspJson(String baseUrl,String accessId,File file) throws IOException
	    {
	        String url = baseUrl + "/getMostRecentEarthquake";
	        Map<String, Object> reqMap = new HashMap<String, Object>();
	         
	        reqMap.put("accessId", accessId);
	         
	         
	        Gson gson = new Gson();
	        String reqJson = gson.toJson(reqMap);
	         
	        String response = null;
	        ClientResource clientResource = new ClientResource(url);
	        try
	        {
	            Representation rep = new JsonRepresentation(new JSONObject(reqJson));
	            rep.setMediaType(MediaType.APPLICATION_JSON);
	            Representation reply = clientResource.post(rep);
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
	         
	        Earthquake earthquake=gson.fromJson(response, Earthquake.class);
	        EarthquakeInfo earthquakeInfo=earthquake.getInfo();
	        FileWriter fileWriter=new FileWriter(file,true);
	      /*  "mag":"1.4",                           // 地震等级
	        "time":"2015-11-19 15:16:59",          // 地震发生时间
	        "updated":"2015-11-19 15:29:31",       // 更新时间
	        "longitude":"-151.2664",               // 震源经度
	        "latitude":"62.3431",                  // 震源纬度
	        "place":"59km W of Talkeetna, Alaska", // 地震发生地点
	        "depth":"61.0",                        // 震源深度
	        "type":"earthquake",                   // 类型
	        "net":"ak",                            // 地震网信息
	        "tsunami":"0",                         // 海啸
*/	       
	        fileWriter.write(earthquakeInfo.getMag()+","+earthquakeInfo.getTime()+","+earthquakeInfo.getUpdated()
	        +","+earthquakeInfo.getLongitude()+","+earthquakeInfo.getLatitude()+","+earthquakeInfo.getPlace()
	        +","+earthquakeInfo.getDepth()+","+earthquakeInfo.getType()+","+earthquakeInfo.getNet()+","+earthquakeInfo.getTsunami()+"\n");
	        fileWriter.close();
	        
	        
	        
	        
	        
	        return response;
	    }
}
