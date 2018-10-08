package id.ac.sgu.homecontroller;
import java.time.LocalTime;
import java.util.*;

import javax.swing.JPanel;

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
		remoteAC.setTimerOn("18:00");
		remoteAC.setTimerOff("06:00");
		remoteAC.setStatus(0);
		
		mainController remoteBlinds = new mainController(Blinds,BlindsBehaviour);
		remoteBlinds.setTimerOn("18:00");
		remoteBlinds.setTimerOff("06:00");
		remoteBlinds.setStatus(0);
		
		mainController remoteLamps = new mainController(Lamps,LampBehaviour);
		remoteLamps.setTimerOn("07:00");
		remoteLamps.setTimerOff("12:00");
		remoteLamps.setStatus(0);
		
		Temperature temperature = new Temperature();
		TemperatureObserver temperatureObserver = new TemperatureObserver(remoteAC);
		
		Time time = new Time();
			
		temperature.addObserver(temperatureObserver);
	
		TimeObserver timeObserver = new TimeObserver(remoteBlinds);
		ACTimeObserver acTimeObserver = new ACTimeObserver(remoteAC,temperature);
		LampObserver lampObserver = new LampObserver(remoteLamps);
		
		time.addObserver(timeObserver);
		time.addObserver(lampObserver);
		time.addObserver(acTimeObserver);
		
	    
	    TimeParser parser = new TimeParser();
		
		UserGUI ug = new UserGUI();
		JPanel panel = new ViewerPanel(remoteAC,remoteBlinds,remoteLamps,time,temperature);
		ug.frameInit(panel);
		

//		Sensor themTest = new Thermometer();
//		Sensor barTest = new Barometer();
//		themTest.doubledValue();
//		barTest.doubledValue();
//		UserGUI ug = new UserGUI();
//		ug.frameInit();


	}
	
	//public void getValueFrom
}
