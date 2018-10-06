package id.ac.sgu.homecontroller;

public class Thermometer extends Sensor {

	public double getTemperature() {
		return temperature;
	}
	
	public double doubledValue(){
		refresh();
		System.out.println("Temperature outside : " + rf.temperature);
		return rf.temperature;
	}

}
