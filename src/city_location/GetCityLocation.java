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
	        /* "citycode":"101010100",       // 城市编码
	        "citylevel":"1",              // 城市级别
	        "countyname_en":"beijing",    // 英文县名
	        "countyname_cn":"北京",       // 中文县名
	        "cityname_en":"beijing",      // 英文城市名
	        "cityname_cn":"北京",         // 中文城市名
	        "provincename_en":"beijing",  // 英文省份名
	        "provincename_cn":"北京",     // 中文省份名
	        "nationname_en":"china",      // 英文国家名
	        "nationname_cn":"中国",       // 中文国家名
	        "areanumber":"010",           // 区号
	        "zipcode":"100000",           // 邮政编码
	        "longitude":"116.391000",     // 经度
	        "latitude":"39.904000",       // 纬度
	        "altitude":"33",              // 海拔
	        "uptime":"201509141100"       // 数据更新时间
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
