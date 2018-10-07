package id.ac.sgu.homecontroller;

import java.io.IOException;

public class Controller {
	
	public static void main(String[] args) throws IOException {

		Behaviour ACBehaviour = new BlowingWind();
		Behaviour BlindsBehaviour = new BlindsSound();
		Behaviour LampBehaviour = new LampSound();
		Actor AC = new AC(ACBehaviour);
		Actor Blinds = new Blinds(BlindsBehaviour);
		Actor Lamps = new Lamps(LampBehaviour);

		mainController remoteAC = new mainController(AC,ACBehaviour);
		mainController remoteBlinds = new mainController(Blinds,BlindsBehaviour);
		mainController remoteLamps = new mainController(Lamps,LampBehaviour);

		Temperature temperature = new Temperature();
		TemperatureObserver temperatureObserver = new TemperatureObserver(remoteAC);
		
		Time time = new Time();
		TimeObserver timeObserver = new TimeObserver(remoteBlinds);
		
		LampObserver lampObserver = new LampObserver(remoteLamps);
		
		temperature.addObserver(temperatureObserver);
		temperature.setTemperature(30);
		
		time.addObserver(timeObserver);
		time.addObserver(lampObserver);
		time.setTime(0000);

//		Sensor themTest = new Thermometer();
//		Sensor barTest = new Barometer();
//		themTest.doubledValue();
//		barTest.doubledValue();
		UserGUI ug = new UserGUI();
		ug.frameInit();

	}
	
	//public void getValueFrom
}
