package live_weather;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

import com.google.gson.Gson;

public class GetLiveWeather {
	/*{
	    "resultCode":"0",                      // ����룬0Ϊ�ɹ���1Ϊʧ��
	    "resultDesc":"Success",                // �������
	    "info":
	    {
	        "citycode":"101010100",            // ���б���
	        "windspeed":"2.3m/s",              // ����
	        "phenomena":"��",                  // ����״��
	        "airpressure":"1024",              // ����ѹ
	        "humidity":"69",                   // ʪ��(%)
	        "updatetime":"2015-12-24 12:00",   // ����ʱ��
	        "windpower":"΢��",                // ����
	        "feelst":"-0.1",                   // ����¶�(��)
	        "winddirect":"������",             // ����
	        "weekofday":"4",                   // ���ڼ���0��������
	        "rain":"0.0",                      // ������(mm)
	        "temperature":"2.4"                // ����(��)
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
