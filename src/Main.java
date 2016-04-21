
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

import air_quality.GetAirQuality;
import atmospheric_environment.GetAtmosphericAnvironment;
import earth_quake.GetEarthquake;
import historical_weather.GetHistoricalWeather;
import live_weather.GetLiveWeather;
import water_environment.GetWaterEnvironment;
import weather_forecast.GetWeatherForcast;

public class Main {
	public static final String PRI_KEY="BGL1EXVZAHVHBMCXNDYXMDYWNDQ5MDA2";
	public static final String BASEURL="http://service.envicloud.cn:8082/api";
	static int flag;
	
	public static void main(String[] args) throws Exception {
		
		System.out.println("请输入你想要生成的tex文件内容：");
		Scanner sc=new Scanner(System.in);
		flag=sc.nextInt();
		
		//选择要获取的文件
		switch(flag){
			case 1:
				ArrayList<String> arrayListForecast=(ArrayList) (new AreaID()).getAreaID();
				Iterator<String> iteratorForcast = arrayListForecast.iterator();
				String citycodeForcast;
				//第一行为列名，丢弃
				citycodeForcast=iteratorForcast.next();
					//获取天气预报
					File weather_forecast_txt=new File("weather_forecast.txt");
					if(!weather_forecast_txt.exists())
			        	weather_forecast_txt.createNewFile();
					while(iteratorForcast.hasNext()){
						citycodeForcast=iteratorForcast.next();
						GetWeatherForcast getWeatherForcast=new GetWeatherForcast();	
						getWeatherForcast.getWeatherForecastGetRsp(BASEURL, PRI_KEY, citycodeForcast,weather_forecast_txt);
					}break;
				
			case 2:
				ArrayList<String> arrayListHistorical=(ArrayList) (new AreaID()).getAreaID();
				Iterator<String> iteratorHistorical = arrayListHistorical.iterator();
				String citycodeHistorical;
				//第一行为列名，丢弃
				citycodeHistorical=iteratorHistorical.next();
					File history_weather_txt=new File("history_weather.txt");
					//这个时间只能用2015091614，别的日期都是错的，不知道什么原因
					String querytime="2015091614";
					if(!history_weather_txt.exists())
						history_weather_txt.createNewFile();
					while(iteratorHistorical.hasNext()){
						citycodeHistorical=iteratorHistorical.next();
						GetHistoricalWeather getHistoricalWeather=new GetHistoricalWeather();
						getHistoricalWeather.getWeatherHistoryGetRsp(BASEURL, PRI_KEY,querytime,citycodeHistorical,history_weather_txt);
					} 
			        break;
			case 3:
				ArrayList<String> arrayListLive=(ArrayList) (new AreaID()).getAreaID();
				Iterator<String> iteratorLive = arrayListLive.iterator();
				String citycodeLive;
				//第一行为列名，丢弃
				citycodeLive=iteratorLive.next();
					File live_weather_txt=new File("live_weather.txt");
					if(!live_weather_txt.exists())
						live_weather_txt.createNewFile();
					while(iteratorLive.hasNext()){
						citycodeLive=iteratorLive.next();
						GetLiveWeather getLiveWeather=new GetLiveWeather();
						getLiveWeather.getWeatherCurrentGetRsp(BASEURL, PRI_KEY, citycodeLive,live_weather_txt);
					}
					break;
			case 4://未完待续
					ArrayList<String> waterArrayList=new WaterDrainage().getWaterDrainage();
					Iterator<String> waterIterator=waterArrayList.iterator();
					waterIterator.next();
					//这里可以修改
					String startDate="2014-11-18";
			        String endDate="2014-11-30";
			        GetWaterEnvironment getWaterEnvironment=new GetWaterEnvironment();
			        File water_envronment_txt=new File("water_envronment.txt");
					while(waterIterator.hasNext()){
						getWaterEnvironment.getWaterQualityByPTRspJson(BASEURL, PRI_KEY, startDate, endDate, 
								waterIterator.next(),water_envronment_txt);
						
						
					}
					
					break;
			case 5:
					ArrayList<String> arrayListAtmospheric=new AreaID().getAreaID();
					Iterator<String> iteratorAtmospheric = arrayListAtmospheric.iterator();
					String citycodeAtmospheric;
					//第一行为列名，丢弃
					citycodeAtmospheric=iteratorAtmospheric.next();
					File atmospheric_environment_txt=new File("atmospheric_environment.txt");
					if(!atmospheric_environment_txt.exists())
						atmospheric_environment_txt.createNewFile();
					while(iteratorAtmospheric.hasNext()){
						citycodeAtmospheric=iteratorAtmospheric.next();
						GetAtmosphericAnvironment getAtmosphericAnvironment=new GetAtmosphericAnvironment();
						getAtmosphericAnvironment.getRealtimeAirInfoGetRsp(BASEURL, PRI_KEY, citycodeAtmospheric,atmospheric_environment_txt);
					}break;
			case 6:
				ArrayList<String> arrayListAir=new AreaID().getAreaID();
				Iterator<String> iteratorAir = arrayListAir.iterator();
				String citycodeAir;
				//第一行为列名，丢弃
				citycodeAir=iteratorAir.next();
				File air_quality_txt=new File("air_quality.txt");
				if(!air_quality_txt.exists())
					air_quality_txt.createNewFile();
				while(iteratorAir.hasNext()){
					citycodeAir=iteratorAir.next();
					GetAirQuality getAirQuality=new GetAirQuality();
					getAirQuality.getCityChemForecastRspJson(BASEURL, PRI_KEY, citycodeAir, air_quality_txt);
				}break;
				
			case 7:
				File earth_quake_txt=new File("earth_quake.txt");
				if(!earth_quake_txt.exists())
					earth_quake_txt.createNewFile();
				
				GetEarthquake getEarthquake=new GetEarthquake();
				getEarthquake.getEarthquakesRspJson(BASEURL, PRI_KEY,earth_quake_txt);
				break;
				
				
			default:
				System.out.println("您输入的数字有误！");
		}
	}

}


