package id.ac.sgu.homecontroller;
import java.time.LocalTime;
import java.util.*;

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
		
		
		time.addObserver(timeObserver);
		time.addObserver(lampObserver);
		
		
	    
	    
	    TimeParser parser = new TimeParser();
	    

		Random rand = new Random();
		int[] temp = new int[]{18,26};
		ArrayList<LocalTime> timeList = new ArrayList<LocalTime>();
		timeList.add(parser.parser("07:00"));
		timeList.add(parser.parser("18:59"));
		
		
		Thread thread = new Thread(){
		    public void run(){
		      try {
		          while(true){
		        	 LocalTime temporaryTime = timeList.get(rand.nextInt(timeList.size()));
		        	 time.setTime(temporaryTime);
		        	 int temporaryTemp = temp[rand.nextInt(temp.length)];
		        	 temperature.setTemperature(temporaryTemp);
		        	 System.out.println("Current Time : "+temporaryTime);
		        	 System.out.println("Current Temperature : "+temporaryTemp);
		             // Let the thread sleep for a while.
		             Thread.sleep(10000);
		          }
		       } catch (InterruptedException e) {
		          System.out.println("Closed.");
		       }
		    }
		  };
		
		thread.start();
		
		 
		

//		Sensor themTest = new Thermometer();
//		Sensor barTest = new Barometer();
//		themTest.doubledValue();
//		barTest.doubledValue();
//		UserGUI ug = new UserGUI();
//		ug.frameInit();

	}
	
	//public void getValueFrom
}
