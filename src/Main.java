
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

import air_quality.GetAirQuality;
import atmospheric_environment.GetAtmosphericAnvironment;
import city_location.GetCityLocation;
import earth_quake.GetEarthquake;
import historical_weather.GetHistoricalWeather;
import live_weather.GetLiveWeather;
import meteorological_disaster.GetMeteorologicalDisaster;
import pollution_discharge.GetPollutionDischarge;
import water_environment.GetWaterEnvironment;
import weather_forecast.GetWeatherForcast;

public class Main {
	public static final String PRI_KEY="BGL1EXVZAHVHBMCXNDYXMDYWNDQ5MDA2";
	public static final String BASEURL="http://service.envicloud.cn:8082/api";
	private static String[] pollutant_categoyr={"ˮ��Ⱦ���ŷ�","������Ⱦ���ŷ�","������Ⱦ���ŷ�","���������ŷż��ܺ�"};
	
	public static void main(String[] args) throws Exception {
		
		System.out.println("***************************");
		System.out.println("**����1�������Ԥ����ѯtxt�ļ�         **");
		System.out.println("**����2�����ʷ����txt��ѯ�ļ�         **");
		System.out.println("**����3�������ʵ��txt��ѯ�ļ�         **");
		System.out.println("**����4���ˮ�廷����ѯtxt�ļ�         **");
		System.out.println("**����5��ô���������ѯtxt�ļ�         **");
		System.out.println("**����6��ÿ���������ѯtxt�ļ�         **");
		System.out.println("**����7��õ����ֺ���ѯtxt�ļ�         **");
		System.out.println("**����8��ó���λ�ò�ѯtxt�ļ�         **");
		System.out.println("**����9��������ֺ���ѯtxt�ļ�         **");
		System.out.println("**����10�����Ⱦ���ѯtxt�ļ�         **");
		System.out.println("**����0�˳�����                                          **");
		System.out.println("***************************");
		System.out.println("����������Ҫ���ɵ�txt�ļ����ݣ�");
		Scanner sc=new Scanner(System.in);
		
		while(true){
			//ѡ��Ҫ��ȡ���ļ�
			switch(sc.nextInt()){
				case 1:
					ArrayList<String> arrayListForecast=(ArrayList) (new AreaID()).getAreaID();
					Iterator<String> iteratorForcast = arrayListForecast.iterator();
					String citycodeForcast;
					//��һ��Ϊ����������
					citycodeForcast=iteratorForcast.next();
						//��ȡ����Ԥ��
						File weather_forecast_txt=new File("TXT\\weather_forecast.txt");
						if(!weather_forecast_txt.exists())
				        	weather_forecast_txt.createNewFile();
						while(iteratorForcast.hasNext()){
							citycodeForcast=iteratorForcast.next();
							GetWeatherForcast getWeatherForcast=new GetWeatherForcast();	
							getWeatherForcast.getWeatherForecastGetRsp(BASEURL, PRI_KEY, citycodeForcast,weather_forecast_txt);
						}
						System.out.println("�ļ��������");
						System.out.println("����������Ҫ���ɵ�txt�ļ����ݣ�");
						break;
					
				case 2:
					ArrayList<String> arrayListHistorical=(ArrayList) (new AreaID()).getAreaID();
					Iterator<String> iteratorHistorical = arrayListHistorical.iterator();
					String citycodeHistorical;
					//��һ��Ϊ����������
					citycodeHistorical=iteratorHistorical.next();
						File history_weather_txt=new File("TXT\\history_weather.txt");
						//���ʱ��ֻ����2015091614��������ڶ��Ǵ�ģ���֪��ʲôԭ��
						String querytime="2015091614";
						if(!history_weather_txt.exists())
							history_weather_txt.createNewFile();
						while(iteratorHistorical.hasNext()){
							citycodeHistorical=iteratorHistorical.next();
							GetHistoricalWeather getHistoricalWeather=new GetHistoricalWeather();
							getHistoricalWeather.getWeatherHistoryGetRsp(BASEURL, PRI_KEY,querytime,citycodeHistorical,history_weather_txt);
						}
						System.out.println("�ļ��������");
						System.out.println("����������Ҫ���ɵ�txt�ļ����ݣ�");
				        break;
				case 3:
					ArrayList<String> arrayListLive=(ArrayList) (new AreaID()).getAreaID();
					Iterator<String> iteratorLive = arrayListLive.iterator();
					String citycodeLive;
					//��һ��Ϊ����������
					citycodeLive=iteratorLive.next();
						File live_weather_txt=new File("TXT\\live_weather.txt");
						if(!live_weather_txt.exists())
							live_weather_txt.createNewFile();
						while(iteratorLive.hasNext()){
							citycodeLive=iteratorLive.next();
							GetLiveWeather getLiveWeather=new GetLiveWeather();
							getLiveWeather.getWeatherCurrentGetRsp(BASEURL, PRI_KEY, citycodeLive,live_weather_txt);
						}
						System.out.println("�ļ��������");
						System.out.println("����������Ҫ���ɵ�txt�ļ����ݣ�");
						break;
				case 4://δ�����
						ArrayList<String> waterArrayList=new WaterDrainage().getWaterDrainage();
						Iterator<String> waterIterator=waterArrayList.iterator();
						waterIterator.next();
						//��������޸�
						String startDate="2014-11-18";
				        String endDate="2014-11-30";
				        GetWaterEnvironment getWaterEnvironment=new GetWaterEnvironment();
				        File water_envronment_txt=new File("TXT\\water_envronment.txt");
						while(waterIterator.hasNext()){
							getWaterEnvironment.getWaterQualityByPTRspJson(BASEURL, PRI_KEY, startDate, endDate, 
									waterIterator.next(),water_envronment_txt);
						}
						System.out.println("�ļ��������");
						System.out.println("����������Ҫ���ɵ�txt�ļ����ݣ�");
						break;
				case 5:
						ArrayList<String> arrayListAtmospheric=new AreaID().getAreaID();
						Iterator<String> iteratorAtmospheric = arrayListAtmospheric.iterator();
						String citycodeAtmospheric;
						//��һ��Ϊ����������
						citycodeAtmospheric=iteratorAtmospheric.next();
						File atmospheric_environment_txt=new File("TXT\\atmospheric_environment.txt");
						if(!atmospheric_environment_txt.exists())
							atmospheric_environment_txt.createNewFile();
						while(iteratorAtmospheric.hasNext()){
							citycodeAtmospheric=iteratorAtmospheric.next();
							GetAtmosphericAnvironment getAtmosphericAnvironment=new GetAtmosphericAnvironment();
							getAtmosphericAnvironment.getRealtimeAirInfoGetRsp(BASEURL, PRI_KEY, citycodeAtmospheric,atmospheric_environment_txt);
						}
						System.out.println("�ļ��������");
						System.out.println("����������Ҫ���ɵ�txt�ļ����ݣ�");
						break;
				case 6:
					ArrayList<String> arrayListAir=new AreaID().getAreaID();
					Iterator<String> iteratorAir = arrayListAir.iterator();
					String citycodeAir;
					//��һ��Ϊ����������
					citycodeAir=iteratorAir.next();
					File air_quality_txt=new File("TXT\\air_quality.txt");
					if(!air_quality_txt.exists())
						air_quality_txt.createNewFile();
					while(iteratorAir.hasNext()){
						citycodeAir=iteratorAir.next();
						GetAirQuality getAirQuality=new GetAirQuality();
						getAirQuality.getCityChemForecastRspJson(BASEURL, PRI_KEY, citycodeAir, air_quality_txt);
					}
					System.out.println("�ļ��������");
					System.out.println("����������Ҫ���ɵ�txt�ļ����ݣ�");
					break;
					
				case 7:
					File earth_quake_txt=new File("TXT\\earth_quake.txt");
					if(!earth_quake_txt.exists())
						earth_quake_txt.createNewFile();
					GetEarthquake getEarthquake=new GetEarthquake();
					getEarthquake.getEarthquakesRspJson(BASEURL, PRI_KEY,earth_quake_txt);
					System.out.println("�ļ��������");
					System.out.println("����������Ҫ���ɵ�txt�ļ����ݣ�");
					break;
					
				case 8:
					ArrayList<String> arrayListLocation=new AreaID().getAreaID();
					Iterator<String> iteratorLocation = arrayListLocation.iterator();
					String citycodeLocation;
					//��һ��Ϊ����������
					citycodeLocation=iteratorLocation.next();
					File city_location_txt=new File("TXT\\city_location.txt");
					if(!city_location_txt.exists())
						city_location_txt.createNewFile();
					while(iteratorLocation.hasNext()){
						citycodeLocation=iteratorLocation.next();
						GetCityLocation getCityLocation=new GetCityLocation();
						getCityLocation.getGisLocationPostRsp(BASEURL, PRI_KEY, citycodeLocation,city_location_txt);
					}
					System.out.println("�ļ��������");
					System.out.println("����������Ҫ���ɵ�txt�ļ����ݣ�");
					break;	
				case 9:
					File mateorological_disaster_txt=new File("TXT\\mateorological_disaster.txt"); 
					if(!mateorological_disaster_txt.exists())
						mateorological_disaster_txt.createNewFile();
					GetMeteorologicalDisaster getMeteorologicalDisaster=new GetMeteorologicalDisaster();
					getMeteorologicalDisaster.getTyphoonDetailRspJson(BASEURL, PRI_KEY, "2012",mateorological_disaster_txt);
					System.out.println("�ļ��������");
					break;
				case 10:
					File pollution_discharge_txt=new File("TXT\\pollution_discharge.txt");
					if(!pollution_discharge_txt.exists())
						pollution_discharge_txt.createNewFile();
					System.out.println("������Ҫ��ѯ��ʡ�ݣ�ֻ֧���й�ʡ�ݡ�ֱϽ�л���������Ĭ�ϱ�������");
	
					String province=sc.next();
					System.err.println(province);
					System.out.println("��ѡ��Ҫ��ѯ��ָ�꣺");
					System.out.println("1��ˮ��Ⱦ���ŷ�   ,   2:������Ⱦ���ŷ�    ,   3:������Ⱦ���ŷ�   ,   4:���������ŷż��ܺ�");
					int i=sc.nextInt();
					new GetPollutionDischarge().getDischargeByCategoryRspJson(BASEURL, PRI_KEY, "2009", province, pollutant_categoyr[i], pollution_discharge_txt);
					break;
				
				case 0:
					System.out.println("�˳�����");
					return;
				
					
				default:
					System.out.println("�������������������������");
					System.out.println("����������Ҫ���ɵ�txt�ļ����ݣ�");
					break;
			}
	}
	}

}


