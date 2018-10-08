package id.ac.sgu.homecontroller;

public abstract class abstractActor implements Actor {
	Behaviour behaviour;
	
	public void doAction() {
		behaviour.action();
	}
	

	
}
