package weather_forecast;
/*
 * ������GET��ʽ��ȡ��������Ԥ����Ϣ
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
        "citycode":"101010100",            // ���б���
        "cityname":"����",                 // ��������
        "publishTime":"2015-12-07",        // ��������
        "currentTemp":"3.0",               // ʵʱ����(��)
        "forecast":                        // Ԥ����Ϣ
        [{
            "hightemp":"3��",              // ����¶�
            "fengxiang":"�޳�������",      // ����
            "lowtemp":"0��",               // ����¶�
            "fengli":"΢�缶",             // ����
            "date":"2015-12-07",           // Ԥ������
            "type":"��",                   // ����״��
            "week":"����һ"                // ���ڼ�
        },{
            "hightemp":"3��",
            "fengxiang":"�޳�������",
            "lowtemp":"1��",
            "fengli":"΢�缶",
            "date":"2015-12-08",
            "type":"��",
            "week":"���ڶ�"
        },{
            "hightemp":"3��",
            "fengxiang":"�޳�������",
            "lowtemp":"-1��",
            "fengli":"΢�缶",
            "date":"2015-12-09",
            "type":"��",
            "week":"������"
        },{
            "hightemp":"2��",
            "fengxiang":"�޳�������",
            "lowtemp":"-1��",
            "fengli":"΢�缶",
            "date":"2015-12-10",
            "type":"���ѩ",
            "week":"������"
        },{
            "hightemp":"5��",
            "fengxiang":"�޳�������",
            "lowtemp":"-4��",
            "fengli":"΢�缶",
            "date":"2015-12-11",
            "type":"����",
            "week":"������"
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
		//��ȡ���������ص�json��ʽ����
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
        //jsonת��
        Gson gson=new Gson();
        WeatherForecast weatherJson=gson.fromJson(response, WeatherForecast.class);
        WeatherForecastInfo info=weatherJson.getInfo();
        
        
        String 	citycode1=info.getCitycode();   //���б���
        String 	cityname=info.getCityname();   	//��������
        String	publishTime=info.getPublishTime();	//��������
        String	currentTemp=info.getCurrentTemp();	//ʵʱ���£��棩
        Forecast[] forecast=info.getForecast();
        
        //׼��д���ı��ļ�
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
        	//��δ��뿴�����е㷳����ʵ����Ϊ�˽�������ı��ļ�֮��������û������������
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

 


