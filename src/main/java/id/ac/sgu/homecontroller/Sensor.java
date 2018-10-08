package id.ac.sgu.homecontroller;

import java.util.Observer;

import com.github.dvdme.ForecastIOLib.FIOMinutely;
import com.github.dvdme.ForecastIOLib.ForecastIO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

class RealFeel{
	int time = 0;
	String summary = "";
	String icon = "";
	double precipIntensity = 0;
	double precipProbability= 0;
	double temperature= 0;
	double apparentTemperature= 0;
	double dewPoint= 0;
	double humidity= 0;
	double pressure= 0;
	double windSpeed= 0;
	double windGust= 0;
	double windBearing= 0;
	double cloudCover= 0;
	double uvIndex= 0;
	double visibility= 0;
	double ozone= 0;
}



public abstract class Sensor {
	double pressure;
	double temperature;
	private final String aPIKey = "7616641ac2e3c256aad01f8377537769";
	private final String langtitude = "-6.21462";
	private final String longtitude = "106.84513";
	
	ForecastIO fio = new ForecastIO(langtitude,longtitude,aPIKey);
	FIOMinutely minutely = new FIOMinutely(fio);
	Gson gson = new GsonBuilder().create();
	
	RealFeel rf;
	
	
	
	public void refresh() {
		fio.setUnits(ForecastIO.UNITS_SI);
		fio.setLang(ForecastIO.LANG_ENGLISH);
		System.out.println("inside Sensor Temperature :  "+fio.getCurrently());
		String parse = fio.getCurrently()+"";
		this.rf = gson.fromJson(parse, RealFeel.class);
		
	}
	
	public String getSummary() {
		refresh();
		System.out.println(rf.summary);
		return rf.summary;
	}
	
	abstract double doubledValue();
}
