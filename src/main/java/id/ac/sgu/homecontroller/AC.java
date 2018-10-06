package id.ac.sgu.homecontroller;

public class AC extends abstractActor {
	//Device status 1=Turned On 0=Turned Off
	int acStatus = 0;
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
	
	
}
