package id.ac.sgu.homecontroller;

public class Lamps extends abstractActor {
	int lampStatus;

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

}
