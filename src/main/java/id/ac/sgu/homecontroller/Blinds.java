package id.ac.sgu.homecontroller;

public class Blinds extends abstractActor {
	int blindsStatus = 0;
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
	

}
