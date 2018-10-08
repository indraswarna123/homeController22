package id.ac.sgu.homecontroller;

public interface Actor {
	void doAction();
	void turnOn();
	void turnOff();
	String getTimerOn();
	String getTimerOff();
	int getStatus();
	void setTimerOn(String time);
	void setTimerOff(String time);
	void setStatus(int status);
	
}
