package weather_forecast;
/*
 * 该类用GET方式获取城市天气预报信息
 * */
import java.io.File;

import java.io.FileWriter;
import java.io.IOException;

import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

import com.google.gson.Gson;
/*{
    "info":
    {
        "citycode":"101010100",            // 城市编码
        "cityname":"北京",                 // 城市名称
        "publishTime":"2015-12-07",        // 发布日期
        "currentTemp":"3.0",               // 实时气温(℃)
        "forecast":                        // 预报信息
        [{
            "hightemp":"3℃",              // 最高温度
            "fengxiang":"无持续风向",      // 风向
            "lowtemp":"0℃",               // 最低温度
            "fengli":"微风级",             // 风力
            "date":"2015-12-07",           // 预报日期
            "type":"霾",                   // 天气状况
            "week":"星期一"                // 星期几
        },{
            "hightemp":"3℃",
            "fengxiang":"无持续风向",
            "lowtemp":"1℃",
            "fengli":"微风级",
            "date":"2015-12-08",
            "type":"霾",
            "week":"星期二"
        },{
            "hightemp":"3℃",
            "fengxiang":"无持续风向",
            "lowtemp":"-1℃",
            "fengli":"微风级",
            "date":"2015-12-09",
            "type":"霾",
            "week":"星期三"
        },{
            "hightemp":"2℃",
            "fengxiang":"无持续风向",
            "lowtemp":"-1℃",
            "fengli":"微风级",
            "date":"2015-12-10",
            "type":"雨夹雪",
            "week":"星期四"
        },{
            "hightemp":"5℃",
            "fengxiang":"无持续风向",
            "lowtemp":"-4℃",
            "fengli":"微风级",
            "date":"2015-12-11",
            "type":"多云",
            "week":"星期五"
        }]
    },
    "resultCode":"0",
    "resultDesc":"Success"
}
*/


public class GetWeatherForcast {
	public  void getWeatherForecastGetRsp(String baseUrl, String accessId,
            String citycode,File file) throws IOException
    {
		//获取服务器返回的json格式数据
        String response = null;
        String url = baseUrl + "/getWeatherForecast?citycode="
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
 
        try{
        //json转化
        Gson gson=new Gson();
        WeatherForecast weatherJson=gson.fromJson(response, WeatherForecast.class);
        WeatherForecastInfo info=weatherJson.getInfo();
        
        
        String 	citycode1=info.getCitycode();   //城市编码
        String 	cityname=info.getCityname();   	//城市名称
        String	publishTime=info.getPublishTime();	//发布日期
        String	currentTemp=info.getCurrentTemp();	//实时气温（℃）
        Forecast[] forecast=info.getForecast();
        
        //准备写入文本文件
        FileWriter fileWriter=new FileWriter(file,true);
        for(int i=0;i<forecast.length;i++){
        	fileWriter.write(citycode1+","+cityname+","+publishTime+","+currentTemp+","+forecast[i].getDate()
    				+","+forecast[i].getFengli()+","+forecast[i].getFengxiang()+","+forecast[i].getHightemp()
    				+","+forecast[i].getLowtemp()+","+forecast[i].getType()+","+forecast[i].getWeek()+"\n");
        }
        
        fileWriter.close();
        }catch(Exception e){
        	e.printStackTrace();
        }
        
       /* for(int i=0;i<=4;i++)
        	//这段代码看起来有点烦，事实上是为了解决输入文本文件之后列数据没对整齐的情况！
        if(cityname.length()>=4){
        	if(forecast[i].getFengxiang().length()>=4){
        		fileWriter.write(citycode1+","+"\t"+cityname+","+"\t"+publishTime+","+"\t"+currentTemp+","+"\t"+forecast[i].getDate()
        				+","+"\t"+forecast[i].getFengli()+","+"\t"+forecast[i].getFengxiang()+","+"\t"+forecast[i].getHightemp()+","
        				+"\t"+forecast[i].getLowtemp()+","+"\t"+forecast[i].getType()+","+"\t"+forecast[i].getWeek()+"\n");
        	}
        	else{
        		fileWriter.write(citycode1+","+"\t"+cityname+","+"\t"+publishTime+","+"\t"+currentTemp+","+"\t"+forecast[i].getDate()
        				+","+"\t"+forecast[i].getFengli()+","+"\t"+forecast[i].getFengxiang()+","+"\t\t"+forecast[i].getHightemp()
        				+","+"\t"+forecast[i].getLowtemp()+","+"\t"+forecast[i].getType()+","+"\t"+forecast[i].getWeek()+"\n");
        	}
        }
        	
        else{
        	if(forecast[i].getFengxiang().length()>=4){
        		fileWriter.write(citycode1+","+"\t"+cityname+","+"\t\t"+publishTime+","+"\t"+currentTemp+","+"\t"+forecast[i].getDate()
        				+","+"\t"+forecast[i].getFengli()+","+"\t"+forecast[i].getFengxiang()+","+"\t"+forecast[i].getHightemp()
        				+","+"\t"+forecast[i].getLowtemp()+","+"\t"+forecast[i].getType()+","+"\t"+forecast[i].getWeek()+"\n");
        	}
        	else{
        		fileWriter.write(citycode1+","+"\t"+cityname+","+"\t\t"+publishTime+","+"\t"+currentTemp+","+"\t"+forecast[i].getDate()+","
        				+"\t"+forecast[i].getFengli()+","+"\t"+forecast[i].getFengxiang()+","+"\t\t"+forecast[i].getHightemp()
        				+","+"\t"+forecast[i].getLowtemp()+","+"\t"+forecast[i].getType()+","+"\t"+forecast[i].getWeek()+"\n");
        	}
        }*/
    }
}

 


