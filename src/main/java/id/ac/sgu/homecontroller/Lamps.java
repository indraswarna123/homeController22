package id.ac.sgu.homecontroller;

public class Lamps extends abstractActor {
	int lampStatus;
	String timeOn;
	String timeOff;
	
	public Lamps(Behaviour lampBehaviour) {
		this.behaviour = lampBehaviour;
	}

	@Override
	public void turnOn() {
		this.lampStatus = 1;
		System.out.println("Lamp turned on");
		doAction();
	}

	@Override
	public void turnOff() {
		this.lampStatus = 0;
		System.out.println("Lamp turned off");
		doAction();
		
	}

	@Override
	public String getTimerOn() {
		return timeOn;
	}

	@Override
	public String getTimerOff() {
		return timeOff;
	}

	@Override
	public int getStatus() {
		return lampStatus;
	}

	@Override
	public void setTimerOn(String time) {
		this.timeOn = time;
	}

	@Override
	public void setTimerOff(String time) {
		this.timeOff = time;
	}

	@Override
	public void setStatus(int status) {
		this.lampStatus = status;
	}

}
