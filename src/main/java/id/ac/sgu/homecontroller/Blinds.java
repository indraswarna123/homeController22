package id.ac.sgu.homecontroller;

public class Blinds extends abstractActor {
	int blindsStatus = 0;
	String timeOn;
	String timeOff;
	
	public Blinds(Behaviour blindsBehaviour) {
		this.behaviour = blindsBehaviour;
	}
	
	@Override
	public void turnOn() {
		this.blindsStatus = 1;
		System.out.println("Blind opened");
		doAction();
	}

	@Override
	public void turnOff() {
		this.blindsStatus = 0;
		System.out.println("Blind closed");
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
		return blindsStatus;
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
		this.blindsStatus = status;
	}
	

}
