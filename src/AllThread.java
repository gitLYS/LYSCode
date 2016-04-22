import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

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

public class AllThread extends Thread{
	public static final String PRI_KEY="BGL1EXVZAHVHBMCXNDYXMDYWNDQ5MDA2";
	public static final String BASEURL="http://service.envicloud.cn:8082/api";
	public static String[] pollutant_categoyr={"水污染物排放","空气污染物排放","固体污染物排放","温室气体排放及能耗"};
}

class WeatherForecastThread extends Thread{
	@Override
	public void run() {
		ArrayList<String> arrayListForecast=new AreaID().getAreaID();
		Iterator<String> iteratorForcast = arrayListForecast.iterator();
		String citycodeForcast;
		//第一行为列名，丢弃
		citycodeForcast=iteratorForcast.next();
			//获取天气预报
			File weather_forecast_txt=new File("TXT\\weather_forecast.txt");
			if(!weather_forecast_txt.exists())
				try {
					weather_forecast_txt.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			while(iteratorForcast.hasNext()){
				citycodeForcast=iteratorForcast.next();
				GetWeatherForcast getWeatherForcast=new GetWeatherForcast();	
				try {
					getWeatherForcast.getWeatherForecastGetRsp(AllThread.BASEURL, AllThread.PRI_KEY, citycodeForcast,weather_forecast_txt);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
	}
}

class HisoricalWeatherThread extends Thread{
	@Override
	public void run() {
		ArrayList<String> arrayListHistorical=new AreaID().getAreaID();
		Iterator<String> iteratorHistorical = arrayListHistorical.iterator();
		String citycodeHistorical;
		//第一行为列名，丢弃
		citycodeHistorical=iteratorHistorical.next();
			File history_weather_txt=new File("TXT\\history_weather.txt");
			//这个时间只能用2015091614，别的日期都是错的，不知道什么原因
			String querytime="2015091614";
			if(!history_weather_txt.exists())
				try {
					history_weather_txt.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			while(iteratorHistorical.hasNext()){
				citycodeHistorical=iteratorHistorical.next();
				GetHistoricalWeather getHistoricalWeather=new GetHistoricalWeather();
				try {
					getHistoricalWeather.getWeatherHistoryGetRsp(AllThread.BASEURL,AllThread.PRI_KEY,querytime,citycodeHistorical,history_weather_txt);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}
}

class LiveWeaterThread extends Thread{
	@Override
	public void run() {
		ArrayList<String> arrayListLive=new AreaID().getAreaID();
		Iterator<String> iteratorLive = arrayListLive.iterator();
		String citycodeLive;
		//第一行为列名，丢弃
		citycodeLive=iteratorLive.next();
			File live_weather_txt=new File("TXT\\live_weather.txt");
			if(!live_weather_txt.exists())
				try {
					live_weather_txt.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			while(iteratorLive.hasNext()){
				citycodeLive=iteratorLive.next();
				GetLiveWeather getLiveWeather=new GetLiveWeather();
				try {
					getLiveWeather.getWeatherCurrentGetRsp(AllThread.BASEURL, AllThread.PRI_KEY, citycodeLive,live_weather_txt);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}
}

class WaterEnvironmentThread extends Thread{
	@Override
	public void run() {
		ArrayList<String> waterArrayList=new WaterDrainage().getWaterDrainage();
		Iterator<String> waterIterator=waterArrayList.iterator();
		waterIterator.next();
		//这里可以修改
		String startDate="2014-11-18";
        String endDate="2014-11-30";
        GetWaterEnvironment getWaterEnvironment=new GetWaterEnvironment();
        File water_envronment_txt=new File("TXT\\water_envronment.txt");
		while(waterIterator.hasNext()){
			try {
				getWaterEnvironment.getWaterQualityByPTRspJson(AllThread.BASEURL, AllThread.PRI_KEY, startDate, endDate, 
						waterIterator.next(),water_envronment_txt);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}


class AtmosphericEnvironmentThread extends Thread{
	@Override
	public void run() {
		ArrayList<String> arrayListAtmospheric=new AreaID().getAreaID();
		Iterator<String> iteratorAtmospheric = arrayListAtmospheric.iterator();
		String citycodeAtmospheric;
		//第一行为列名，丢弃
		citycodeAtmospheric=iteratorAtmospheric.next();
		File atmospheric_environment_txt=new File("TXT\\atmospheric_environment.txt");
		if(!atmospheric_environment_txt.exists())
			try {
				atmospheric_environment_txt.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		while(iteratorAtmospheric.hasNext()){
			citycodeAtmospheric=iteratorAtmospheric.next();
			GetAtmosphericAnvironment getAtmosphericAnvironment=new GetAtmosphericAnvironment();
			try {
				getAtmosphericAnvironment.getRealtimeAirInfoGetRsp(AllThread.BASEURL,AllThread.PRI_KEY, citycodeAtmospheric,atmospheric_environment_txt);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class AirQualityThread extends Thread{
	@Override
	public void run() {
		ArrayList<String> arrayListAir=new AreaID().getAreaID();
		Iterator<String> iteratorAir = arrayListAir.iterator();
		String citycodeAir;
		//第一行为列名，丢弃
		citycodeAir=iteratorAir.next();
		File air_quality_txt=new File("TXT\\air_quality.txt");
		if(!air_quality_txt.exists())
			try {
				air_quality_txt.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		while(iteratorAir.hasNext()){
			citycodeAir=iteratorAir.next();
			GetAirQuality getAirQuality=new GetAirQuality();
			getAirQuality.getCityChemForecastRspJson(AllThread.BASEURL, AllThread.PRI_KEY, citycodeAir, air_quality_txt);
		}
	}
}

class EarthQuakeThread extends Thread{
	@Override
	public void run() {
		File earth_quake_txt=new File("TXT\\earth_quake.txt");
		if(!earth_quake_txt.exists())
			try {
				earth_quake_txt.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		GetEarthquake getEarthquake=new GetEarthquake();
		try {
			getEarthquake.getEarthquakesRspJson(AllThread.BASEURL, AllThread.PRI_KEY,earth_quake_txt);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("文件创建完成");
	}
}

class CityLocationThread extends Thread{
	@Override
	public void run() {
		ArrayList<String> arrayListLocation=new AreaID().getAreaID();
		Iterator<String> iteratorLocation = arrayListLocation.iterator();
		String citycodeLocation;
		//第一行为列名，丢弃
		citycodeLocation=iteratorLocation.next();
		File city_location_txt=new File("TXT\\city_location.txt");
		if(!city_location_txt.exists())
			try {
				city_location_txt.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		while(iteratorLocation.hasNext()){
			citycodeLocation=iteratorLocation.next();
			GetCityLocation getCityLocation=new GetCityLocation();
			try {
				getCityLocation.getGisLocationPostRsp(AllThread.BASEURL, AllThread.PRI_KEY, citycodeLocation,city_location_txt);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}


class MeteorologicalDisasterThread extends Thread{
	@Override
	public void run() {
		File mateorological_disaster_txt=new File("TXT\\mateorological_disaster.txt"); 
		if(!mateorological_disaster_txt.exists())
			try {
				mateorological_disaster_txt.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		GetMeteorologicalDisaster getMeteorologicalDisaster=new GetMeteorologicalDisaster();
		try {
			getMeteorologicalDisaster.getTyphoonDetailRspJson(AllThread.BASEURL,AllThread.PRI_KEY, "2012",mateorological_disaster_txt);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


class PollutionDischargeThread extends Thread{
	@Override
	public void run() {
		ArrayList<String> arrayListPollution=new AreaID().getCityname();
		Iterator<String> iteratorPollution = arrayListPollution.iterator();
		iteratorPollution.next();
		String province=iteratorPollution.next();
		String s=null;
		File pollution_discharge_txt=new File("TXT\\pollution_discharge.txt");
		if(!pollution_discharge_txt.exists())
			try {
				pollution_discharge_txt.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		while(iteratorPollution.hasNext()){
			
			//如果provice跟上一次不相同，才进入这个循环
			if(!province.equals(s)){
				for (int i = 0; i <AllThread.pollutant_categoyr.length; i++) {
					try {
						new GetPollutionDischarge().getDischargeByCategoryRspJson(AllThread.BASEURL, AllThread.PRI_KEY, "2009",
								province, AllThread.pollutant_categoyr[i], pollution_discharge_txt);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			s=province;
			province=iteratorPollution.next();
			
			
			
			
			
		}
	}
}