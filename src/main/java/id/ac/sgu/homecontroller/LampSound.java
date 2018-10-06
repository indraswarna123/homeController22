package id.ac.sgu.homecontroller;

public class LampSound implements Behaviour {
	String sound = "cring!!";
	@Override
	public void action() {
		System.out.println(sound);

	}

}
