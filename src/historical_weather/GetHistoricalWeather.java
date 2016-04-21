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
        "citycode":"101010100",  // ���б���
        "details":
        [{
            "updatetime":"2015-09-16 14:25",  // ���ݷ���ʱ��
            "weekofday":"3",                  // ���ڼ�
            "phenomena":"��",                 // ��������
            "temperature":"26.3",             // ����
            "feelst":"23.7",                  // ����¶�
            "humidity":"43",                  // ʪ�ȣ�%��
            "rain":"0.0",                     // ��������mm��
            "airpressure":"1014",             // ����ѹ
            "winddirect":"���Ϸ�",            // ����
            "windpower":"΢��",               // ����
            "windspeed":"3.2m/s"              // ����
        },
        {
            ����  // ��ʱ������ʱ���ó��е�������Ϣ
        },
        ����
        ]
    },
    "resultCode":"0",       // ����룬0Ϊ�ɹ���1Ϊʧ��
    "resultDesc":"Success"  // �������
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
