package historical_weather;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

import com.google.gson.Gson;
/*{
    "info":
    {
        "citycode":"101010100",  // 城市编码
        "details":
        [{
            "updatetime":"2015-09-16 14:25",  // 数据发布时间
            "weekofday":"3",                  // 星期几
            "phenomena":"晴",                 // 天气现象
            "temperature":"26.3",             // 气温
            "feelst":"23.7",                  // 体感温度
            "humidity":"43",                  // 湿度（%）
            "rain":"0.0",                     // 降雨量（mm）
            "airpressure":"1014",             // 大气压
            "winddirect":"西南风",            // 风向
            "windpower":"微风",               // 风力
            "windspeed":"3.2m/s"              // 风速
        },
        {
            ……  // 该时段其余时间点该城市的天气信息
        },
        ……
        ]
    },
    "resultCode":"0",       // 结果码，0为成功，1为失败
    "resultDesc":"Success"  // 结果描述
}*/


public class GetHistoricalWeather {
	

	public  void getWeatherHistoryGetRsp(String baseUrl, String accessId,
            String querytime, String citycode,File file) throws IOException
    {
        String response = null;
         
        String url = baseUrl + "/getWeatherHistory?citycode=" + citycode
                + "&querytime=" + querytime + "&ak=" + accessId;
         
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
           
        Gson gson=new Gson();
        HistoricalWeather historicalWeather=gson.fromJson(response, HistoricalWeather.class);
        HistoricalWeatherInfo info=historicalWeather.getInfo();
        Details[] details =info.getDetails();
        FileWriter fileWriter=new FileWriter(file,true);
        for(int i=0;i<=3;i++){
        	fileWriter.write(info.getCitycode()+","+details[i].getUpdatetime()+","+details[i].getWeekofday()
        			+","+details[i].getPhenomena()+","+details[i].getTemperature()+","+details[i].getFeelst()
        			+","+details[i].getHumidity()+","+details[i].getRain()+","+details[i].getAirpressure()
        			+","+details[i].getWinddirect()+","+details[i].getWindpower()+","+details[i].getWindspeed()+"\n");
        }
        fileWriter.close();
        
       
        //fileWriter.write(info.getCitycode());
       
}
}
