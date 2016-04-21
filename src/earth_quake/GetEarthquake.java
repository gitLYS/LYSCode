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
	      /*  "mag":"1.4",                           // ����ȼ�
	        "time":"2015-11-19 15:16:59",          // ������ʱ��
	        "updated":"2015-11-19 15:29:31",       // ����ʱ��
	        "longitude":"-151.2664",               // ��Դ����
	        "latitude":"62.3431",                  // ��Դγ��
	        "place":"59km W of Talkeetna, Alaska", // �������ص�
	        "depth":"61.0",                        // ��Դ���
	        "type":"earthquake",                   // ����
	        "net":"ak",                            // ��������Ϣ
	        "tsunami":"0",                         // ��Х
*/	       
	        fileWriter.write(earthquakeInfo.getMag()+","+earthquakeInfo.getTime()+","+earthquakeInfo.getUpdated()
	        +","+earthquakeInfo.getLongitude()+","+earthquakeInfo.getLatitude()+","+earthquakeInfo.getPlace()
	        +","+earthquakeInfo.getDepth()+","+earthquakeInfo.getType()+","+earthquakeInfo.getNet()+","+earthquakeInfo.getTsunami()+"\n");
	        fileWriter.close();
	        
	        
	        
	        
	        
	        return response;
	    }
}
