package id.ac.sgu.homecontroller;

public class Barometer extends Sensor{
	
	public double getPressure() {
		return pressure;
	}
	
	public double doubledValue() {
		refresh();
		System.out.println("Pressure Outside : "+rf.windSpeed);
		return rf.windSpeed;
	}
}
