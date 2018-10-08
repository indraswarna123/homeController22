package id.ac.sgu.homecontroller;
import java.util.Observable;
import java.util.Observer;

public class mainController{
	Actor actor;
	Behaviour behaviour;
	public mainController(Actor actor,Behaviour behaviour) {
		this.actor = actor;
		this.behaviour = behaviour;
	}
	
	public mainController(){
		
	}
	
	public String returnImage(String summary) {
		String summaryReturn = "QuestionMark.png";
		if(summary.matches(".*Cloudy.*")) {
			if(summary.matches(".*Partly.*")) {
				summaryReturn = "Weather_Sun_Cloudy.png";
			}else if(summary.matches(".*Storm.*")) {
				summaryReturn = "Weater_RainyStorm.png";
			}else if(summary.matches(".*Rainy.*")) {
				summaryReturn = "Weather_Rainy.png";
			}else {
				summaryReturn = "Weather_Cloudy.png";
			}
		}else if(summary.matches(".*Sun.*")){
			summaryReturn = "Weather_Sun.png";
		}else {
			summaryReturn = "QuestionMark.png";
		}
		
		return summaryReturn;
	}
	
	
}

class TemperatureObserver implements Observer {
	mainController controller;   
	public TemperatureObserver(mainController controller) {
		this.controller = controller;
	}
	
	@Override
	public void update(Observable o, Object temp) {
		if((Double)temp>25.0) {
			this.controller.actor.turnOn();
		}else {
			this.controller.actor.turnOff();
		}
	}
	
}

class Temperature extends Observable{
	double temperature = 30;
	public void setTemperature(double temp) {
		this.temperature = temp;
		setChanged();
        notifyObservers(this.temperature);
	}
}

class TimeObserver implements Observer {
	mainController controller;   
	public TimeObserver(mainController controller) {
		this.controller = controller;
	}
	
	@Override
	public void update(Observable o, Object temp) {
		if((int)temp>1800 && (int)temp<2400) {
			this.controller.actor.turnOff();
		}else if((int)temp>0000 && (int)temp<0600){
			this.controller.actor.turnOff();
		}else {
			this.controller.actor.turnOn();
		}
	}
	
}

class LampObserver implements Observer {
	mainController controller;   
	public LampObserver(mainController controller) {
		this.controller = controller;
	}
	
	@Override
	public void update(Observable o, Object temp) {
		if((int)temp>1800 && (int)temp<2400) {
			this.controller.actor.turnOn();
		}else if((int)temp>0000 && (int)temp<0600){
			this.controller.actor.turnOn();
		}else {
			this.controller.actor.turnOff();
		}
	}
	
}



class Time extends Observable{
	int time = 0000;
	public void setTime(int time) {
		this.time = time;
		setChanged();
        notifyObservers(this.time);
	}
}




