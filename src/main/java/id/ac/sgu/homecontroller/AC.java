package id.ac.sgu.homecontroller;

public class AC extends abstractActor {
	//Device status 1=Turned On 0=Turned Off
	int acStatus = 0;
	String timeOn;
	String timeOff;
	
	public AC(Behaviour blowingwind) {
		this.behaviour = blowingwind;
	}

	@Override
	public void turnOn() {
		this.acStatus = 1;
		System.out.println("Turned on the AC");
		doAction();
	}

	@Override
	public void turnOff() {
		this.acStatus = 0;
		System.out.println("Turned off the AC");
	}

	@Override
	public String getTimerOn() {
		// TODO Auto-generated method stub
		return timeOn;
	}

	@Override
	public String getTimerOff() {
		
		return timeOff;
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
	public int getStatus() {
		
		return acStatus;
	}

	@Override
	public void setStatus(int status) {
		this.acStatus = status;
	}
	
	
}
