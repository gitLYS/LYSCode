package meteorological_disaster;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

import com.google.gson.Gson;

public class GetMeteorologicalDisaster {
	static String[] typhoonArray={"PAKHAR","SANVU","MAWAR", "GUCHOL", 
			"TALIM","DOKSURI","KHANUN", "VICENTE", 
			"SAOLA","DAMREY","HAIKUI","KIROGI",
			"KAI-TAK","TEMBIN","BOLAVEN","SANBA",
			"JELAWAT","EWINIAR","MALIKSI","GAEMI",
			"PRAPIROON","MARIA","SON-TINH","BOPHA",
			"WUKONG"};
	
	
	public void getTyphoonDetailRspJson(String baseUrl,
            String accessId, String year,File file) throws IOException{
		String response = null;
		for(int i=0;i<typhoonArray.length;i++){
			synchronized (baseUrl) {
				String name=typhoonArray[i];
				String url = baseUrl + "/getTyphoonDetail?name=" + name 
					    + "&year=" + year + "&ak=" + accessId;     
					
					ClientResource clientResource = new ClientResource(url);
					try{
						Representation reply = clientResource.get();
						response = reply.getText();
					}
					catch(Exception e){
						e.printStackTrace();
					}
					finally{
						clientResource.release();
					}
					try{
					Gson gson=new Gson();
					MeteorolgicalDisaster meteorolgicalDisaster=gson.fromJson(response, MeteorolgicalDisaster.class);
					MeteorolgicalDisasterInfo meteorolgicalDisasterInfo=meteorolgicalDisaster.getInfo();
					MeteorolgicalDisasterDetails[] meteorolgicalDisasterDetails=meteorolgicalDisasterInfo.getDetails();
					
					FileWriter fileWriter=new FileWriter(file,true);
					/* "centerWindSpeed":"18",     // ̨�����ķ���(m/s)
				     "time":"2012-12-25_08:00",  // ʱ��
				     "centerWindPower":"",       // ̨�����ķ���
				     "centerPressure":"1000",    // ̨��������ѹ(hPa)
				     "cir7radii":"150",          // 7�������뾶(km)
				     "type":"2",                 // ����
				     "cir10radii":"",            // 10�������뾶(km)
				     "y":"10.3",                 // ̨�����ľ���
				     "x":"128.6"                 // ̨������γ��
				*/
					for(int j=0;j<meteorolgicalDisasterDetails.length;j++)
					fileWriter.write(meteorolgicalDisasterInfo.getTyphoonNo()+","+meteorolgicalDisasterInfo.getName_cn()
					+","+meteorolgicalDisasterInfo.getName_en()+","+meteorolgicalDisasterInfo.getYear()
					+","+meteorolgicalDisasterInfo.getDatasource()+","+meteorolgicalDisasterDetails[j].getCenterWindSpeed()
					+","+meteorolgicalDisasterDetails[j].getTime()+","+meteorolgicalDisasterDetails[j].getCenterWindPowe()
					+","+meteorolgicalDisasterDetails[j].getCenterPressure()+","+meteorolgicalDisasterDetails[j].getCir7radii()
					+","+meteorolgicalDisasterDetails[j].getType()+","+meteorolgicalDisasterDetails[j].getCir10radii()
					+","+meteorolgicalDisasterDetails[j].getX()+","+meteorolgicalDisasterDetails[j].getY()+"\n");
					fileWriter.close();
					}catch(Exception e){
						e.printStackTrace();
					}
			}
		}
		
		}
}
