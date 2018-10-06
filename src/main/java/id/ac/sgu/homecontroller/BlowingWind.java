package id.ac.sgu.homecontroller;

public class BlowingWind implements Behaviour {
	String sound = "Blowing Wind";
	@Override
	public void action() {
		System.out.println(sound);
	}

}
