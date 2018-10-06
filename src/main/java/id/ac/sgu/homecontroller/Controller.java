package id.ac.sgu.homecontroller;

public class Controller {
	
	public static void main(String[] args) {
		Sensor themTest = new Thermometer();
		Sensor barTest = new Barometer();
		themTest.doubledValue();
		barTest.doubledValue();
		UserGUI ug = new UserGUI();
		ug.frameInit();
	}
}
