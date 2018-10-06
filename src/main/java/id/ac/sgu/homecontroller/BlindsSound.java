package id.ac.sgu.homecontroller;

public class BlindsSound implements Behaviour {
	String sound = "Skitskit";
	@Override
	public void action() {
		System.out.println(sound);
	}

}
