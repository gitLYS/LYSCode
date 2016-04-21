package live_weather;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

import com.google.gson.Gson;

public class GetLiveWeather {
	/*{
	    "resultCode":"0",                      // 结果码，0为成功，1为失败
	    "resultDesc":"Success",                // 结果描述
	    "info":
	    {
	        "citycode":"101010100",            // 城市编码
	        "windspeed":"2.3m/s",              // 风速
	        "phenomena":"晴",                  // 天气状况
	        "airpressure":"1024",              // 大气压
	        "humidity":"69",                   // 湿度(%)
	        "updatetime":"2015-12-24 12:00",   // 更新时间
	        "windpower":"微风",                // 风力
	        "feelst":"-0.1",                   // 体感温度(℃)
	        "winddirect":"东北风",             // 风向
	        "weekofday":"4",                   // 星期几，0代表周日
	        "rain":"0.0",                      // 降雨量(mm)
	        "temperature":"2.4"                // 气温(℃)
	    }
	}*/
	public void getWeatherCurrentGetRsp(String baseUrl, String accessId,
            String citycode,File file) throws IOException
    {
        String response = null;
         
        String url = baseUrl + "/getWeatherCurrent?citycode=" + citycode
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
         
        FileWriter fileWriter=new FileWriter(file,true);
        Gson gson=new Gson();
        LiveWeather liveWeather=gson.fromJson(response, LiveWeather.class);
        LiveWeatherInfo liveWeatherInfo=liveWeather.getInfo();
        
     

        fileWriter.write(liveWeatherInfo.getCitycode()+","+liveWeatherInfo.getWindspeed()+","+liveWeatherInfo.getPhenomena()
        +","+liveWeatherInfo.getAirpressure()+","+liveWeatherInfo.getHumidity()+","+liveWeatherInfo.getUpdatetime()
        +","+liveWeatherInfo.getWindpower()+","+liveWeatherInfo.getFeelst()+","+liveWeatherInfo.getWinddirect()
        +","+liveWeatherInfo.getWeekofday()+","+liveWeatherInfo.getRain()+","+liveWeatherInfo.getTemperature()+"\n");
       fileWriter.close();
    }
}
