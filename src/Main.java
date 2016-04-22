
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
	private static String[] pollutant_categoyr={"水污染物排放","空气污染物排放","固体污染物排放","温室气体排放及能耗"};
	
	public static void main(String[] args) throws Exception {
		
		System.out.println("***************************");
		System.out.println("**输入1获得天气预报查询txt文件         **");
		System.out.println("**输入2获得历史天气txt查询文件         **");
		System.out.println("**输入3获得天气实况txt查询文件         **");
		System.out.println("**输入4获得水体环境查询txt文件         **");
		System.out.println("**输入5获得大气环境查询txt文件         **");
		System.out.println("**输入6获得空气质量查询txt文件         **");
		System.out.println("**输入7获得地质灾害查询txt文件         **");
		System.out.println("**输入8获得城市位置查询txt文件         **");
		System.out.println("**输入9获得气象灾害查询txt文件         **");
		System.out.println("**输入10获得污染物查询txt文件         **");
		System.out.println("**输入0退出程序                                          **");
		System.out.println("***************************");
		System.out.println("请输入你想要生成的txt文件内容：");
		Scanner sc=new Scanner(System.in);
		
		while(true){
			//选择要获取的文件
			switch(sc.nextInt()){
				case 1:
					ArrayList<String> arrayListForecast=(ArrayList) (new AreaID()).getAreaID();
					Iterator<String> iteratorForcast = arrayListForecast.iterator();
					String citycodeForcast;
					//第一行为列名，丢弃
					citycodeForcast=iteratorForcast.next();
						//获取天气预报
						File weather_forecast_txt=new File("TXT\\weather_forecast.txt");
						if(!weather_forecast_txt.exists())
				        	weather_forecast_txt.createNewFile();
						while(iteratorForcast.hasNext()){
							citycodeForcast=iteratorForcast.next();
							GetWeatherForcast getWeatherForcast=new GetWeatherForcast();	
							getWeatherForcast.getWeatherForecastGetRsp(BASEURL, PRI_KEY, citycodeForcast,weather_forecast_txt);
						}
						System.out.println("文件创建完成");
						System.out.println("请输入你想要生成的txt文件内容：");
						break;
					
				case 2:
					ArrayList<String> arrayListHistorical=(ArrayList) (new AreaID()).getAreaID();
					Iterator<String> iteratorHistorical = arrayListHistorical.iterator();
					String citycodeHistorical;
					//第一行为列名，丢弃
					citycodeHistorical=iteratorHistorical.next();
						File history_weather_txt=new File("TXT\\history_weather.txt");
						//这个时间只能用2015091614，别的日期都是错的，不知道什么原因
						String querytime="2015091614";
						if(!history_weather_txt.exists())
							history_weather_txt.createNewFile();
						while(iteratorHistorical.hasNext()){
							citycodeHistorical=iteratorHistorical.next();
							GetHistoricalWeather getHistoricalWeather=new GetHistoricalWeather();
							getHistoricalWeather.getWeatherHistoryGetRsp(BASEURL, PRI_KEY,querytime,citycodeHistorical,history_weather_txt);
						}
						System.out.println("文件创建完成");
						System.out.println("请输入你想要生成的txt文件内容：");
				        break;
				case 3:
					ArrayList<String> arrayListLive=(ArrayList) (new AreaID()).getAreaID();
					Iterator<String> iteratorLive = arrayListLive.iterator();
					String citycodeLive;
					//第一行为列名，丢弃
					citycodeLive=iteratorLive.next();
						File live_weather_txt=new File("TXT\\live_weather.txt");
						if(!live_weather_txt.exists())
							live_weather_txt.createNewFile();
						while(iteratorLive.hasNext()){
							citycodeLive=iteratorLive.next();
							GetLiveWeather getLiveWeather=new GetLiveWeather();
							getLiveWeather.getWeatherCurrentGetRsp(BASEURL, PRI_KEY, citycodeLive,live_weather_txt);
						}
						System.out.println("文件创建完成");
						System.out.println("请输入你想要生成的txt文件内容：");
						break;
				case 4://未完待续
						ArrayList<String> waterArrayList=new WaterDrainage().getWaterDrainage();
						Iterator<String> waterIterator=waterArrayList.iterator();
						waterIterator.next();
						//这里可以修改
						String startDate="2014-11-18";
				        String endDate="2014-11-30";
				        GetWaterEnvironment getWaterEnvironment=new GetWaterEnvironment();
				        File water_envronment_txt=new File("TXT\\water_envronment.txt");
						while(waterIterator.hasNext()){
							getWaterEnvironment.getWaterQualityByPTRspJson(BASEURL, PRI_KEY, startDate, endDate, 
									waterIterator.next(),water_envronment_txt);
						}
						System.out.println("文件创建完成");
						System.out.println("请输入你想要生成的txt文件内容：");
						break;
				case 5:
						ArrayList<String> arrayListAtmospheric=new AreaID().getAreaID();
						Iterator<String> iteratorAtmospheric = arrayListAtmospheric.iterator();
						String citycodeAtmospheric;
						//第一行为列名，丢弃
						citycodeAtmospheric=iteratorAtmospheric.next();
						File atmospheric_environment_txt=new File("TXT\\atmospheric_environment.txt");
						if(!atmospheric_environment_txt.exists())
							atmospheric_environment_txt.createNewFile();
						while(iteratorAtmospheric.hasNext()){
							citycodeAtmospheric=iteratorAtmospheric.next();
							GetAtmosphericAnvironment getAtmosphericAnvironment=new GetAtmosphericAnvironment();
							getAtmosphericAnvironment.getRealtimeAirInfoGetRsp(BASEURL, PRI_KEY, citycodeAtmospheric,atmospheric_environment_txt);
						}
						System.out.println("文件创建完成");
						System.out.println("请输入你想要生成的txt文件内容：");
						break;
				case 6:
					ArrayList<String> arrayListAir=new AreaID().getAreaID();
					Iterator<String> iteratorAir = arrayListAir.iterator();
					String citycodeAir;
					//第一行为列名，丢弃
					citycodeAir=iteratorAir.next();
					File air_quality_txt=new File("TXT\\air_quality.txt");
					if(!air_quality_txt.exists())
						air_quality_txt.createNewFile();
					while(iteratorAir.hasNext()){
						citycodeAir=iteratorAir.next();
						GetAirQuality getAirQuality=new GetAirQuality();
						getAirQuality.getCityChemForecastRspJson(BASEURL, PRI_KEY, citycodeAir, air_quality_txt);
					}
					System.out.println("文件创建完成");
					System.out.println("请输入你想要生成的txt文件内容：");
					break;
					
				case 7:
					File earth_quake_txt=new File("TXT\\earth_quake.txt");
					if(!earth_quake_txt.exists())
						earth_quake_txt.createNewFile();
					GetEarthquake getEarthquake=new GetEarthquake();
					getEarthquake.getEarthquakesRspJson(BASEURL, PRI_KEY,earth_quake_txt);
					System.out.println("文件创建完成");
					System.out.println("请输入你想要生成的txt文件内容：");
					break;
					
				case 8:
					ArrayList<String> arrayListLocation=new AreaID().getAreaID();
					Iterator<String> iteratorLocation = arrayListLocation.iterator();
					String citycodeLocation;
					//第一行为列名，丢弃
					citycodeLocation=iteratorLocation.next();
					File city_location_txt=new File("TXT\\city_location.txt");
					if(!city_location_txt.exists())
						city_location_txt.createNewFile();
					while(iteratorLocation.hasNext()){
						citycodeLocation=iteratorLocation.next();
						GetCityLocation getCityLocation=new GetCityLocation();
						getCityLocation.getGisLocationPostRsp(BASEURL, PRI_KEY, citycodeLocation,city_location_txt);
					}
					System.out.println("文件创建完成");
					System.out.println("请输入你想要生成的txt文件内容：");
					break;	
				case 9:
					File mateorological_disaster_txt=new File("TXT\\mateorological_disaster.txt"); 
					if(!mateorological_disaster_txt.exists())
						mateorological_disaster_txt.createNewFile();
					GetMeteorologicalDisaster getMeteorologicalDisaster=new GetMeteorologicalDisaster();
					getMeteorologicalDisaster.getTyphoonDetailRspJson(BASEURL, PRI_KEY, "2012",mateorological_disaster_txt);
					System.out.println("文件创建完成");
					break;
				case 10:
					File pollution_discharge_txt=new File("TXT\\pollution_discharge.txt");
					if(!pollution_discharge_txt.exists())
						pollution_discharge_txt.createNewFile();
					System.out.println("请输入要查询的省份（只支持中国省份、直辖市或自治区，默认北京）：");
	
					String province=sc.next();
					System.err.println(province);
					System.out.println("请选择要查询的指标：");
					System.out.println("1：水污染物排放   ,   2:空气污染物排放    ,   3:固体污染物排放   ,   4:温室气体排放及能耗");
					int i=sc.nextInt();
					new GetPollutionDischarge().getDischargeByCategoryRspJson(BASEURL, PRI_KEY, "2009", province, pollutant_categoyr[i], pollution_discharge_txt);
					break;
				
				case 0:
					System.out.println("退出程序");
					return;
				
					
				default:
					System.out.println("您输入的数字有误！请重新输入");
					System.out.println("请输入你想要生成的txt文件内容：");
					break;
			}
	}
	}

}


