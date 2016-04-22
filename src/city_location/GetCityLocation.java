package city_location;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.restlet.data.MediaType;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

import com.google.gson.Gson;

public class GetCityLocation {
	 public String getGisLocationPostRsp(String baseUrl, String accessId,
	            String citycode,File file) throws IOException
	    {
		 String response = null;
         
	        String url = baseUrl + "/getGisLocation?citycode=" + citycode
	                + "&ak=" + accessId;
	         
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
	        /* "citycode":"101010100",       // ���б���
	        "citylevel":"1",              // ���м���
	        "countyname_en":"beijing",    // Ӣ������
	        "countyname_cn":"����",       // ��������
	        "cityname_en":"beijing",      // Ӣ�ĳ�����
	        "cityname_cn":"����",         // ���ĳ�����
	        "provincename_en":"beijing",  // Ӣ��ʡ����
	        "provincename_cn":"����",     // ����ʡ����
	        "nationname_en":"china",      // Ӣ�Ĺ�����
	        "nationname_cn":"�й�",       // ���Ĺ�����
	        "areanumber":"010",           // ����
	        "zipcode":"100000",           // ��������
	        "longitude":"116.391000",     // ����
	        "latitude":"39.904000",       // γ��
	        "altitude":"33",              // ����
	        "uptime":"201509141100"       // ���ݸ���ʱ��
	   */
	        try{
	        Gson gson=new Gson();
	        CityLocation cityLocation=gson.fromJson(response, CityLocation.class);
	        CityLocationInfo cityLocationinfo=cityLocation.getInfo();
	        FileWriter fileWriter=new FileWriter(file,true);
	        fileWriter.write(cityLocationinfo.getCitycode()+","+cityLocationinfo.getCitylevel()+","+cityLocationinfo.getCountyname_en()
	        +","+cityLocationinfo.getCountyname_cn()+","+cityLocationinfo.getCityname_en()+","+cityLocationinfo.getCityname_cn()
	        +","+cityLocationinfo.getProvincename_en()+","+cityLocationinfo.getProvincename_cn()+","+cityLocationinfo.getNationname_en()
	        +","+cityLocationinfo.getNationname_cn()+","+cityLocationinfo.getAreanumber()+","+cityLocationinfo.getZipcode()
	        +","+cityLocationinfo.getLongitude()+","+cityLocationinfo.getLongitude()+","+cityLocationinfo.getLatitude()
	        +","+cityLocationinfo.getAltitude()+","+cityLocationinfo.getUptime()+"\n");
	        fileWriter.close();
	        }catch(Exception e){
	        	e.printStackTrace();
	        }
	        
	        return response;
	    }
}
