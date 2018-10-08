package id.ac.sgu.homecontroller;
import java.util.Observable;
import java.util.Observer;
import java.time.*;
import java.time.format.DateTimeFormatter;
public class mainController{
	Actor actor;
	Behaviour behaviour;
	public mainController(Actor actor,Behaviour behaviour) {
		this.actor = actor;
		this.behaviour = behaviour;
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
	DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_TIME;
	public TimeObserver(mainController controller) {
		this.controller = controller;
	}
	
	@Override
	public void update(Observable o, Object temp) {
		String time1800 = "18:00";
		String time0600 = "06:00";
		String time0000 = "00:00";
		String time2400 = "23:59";
		
		
	    LocalTime time18 = LocalTime.parse(time1800, dateTimeFormatter);
	    LocalTime time06 = LocalTime.parse(time0600, dateTimeFormatter);
	    LocalTime time00 = LocalTime.parse(time0000, dateTimeFormatter);
		LocalTime time24 = LocalTime.parse(time2400, dateTimeFormatter);
		
		if(((LocalTime) temp).isAfter(time18) && ((LocalTime) temp).isBefore(time24)) {
			this.controller.actor.turnOff();
	    }else if(((LocalTime) temp).isAfter(time00) && ((LocalTime) temp).isBefore(time06)){
			this.controller.actor.turnOff();
	    }else {
			this.controller.actor.turnOn();
		}
		
	}
	
}

class LampObserver implements Observer {
	mainController controller;   
	DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_TIME;
	public LampObserver(mainController controller) {
		this.controller = controller;
	}
	
	@Override
	public void update(Observable o, Object temp) {
		String time1800 = "18:00";
		String time0600 = "06:00";
		String time0000 = "00:00";
		String time2400 = "23:59";
		
		
	    LocalTime time18 = LocalTime.parse(time1800, dateTimeFormatter);
	    LocalTime time06 = LocalTime.parse(time0600, dateTimeFormatter);
	    LocalTime time00 = LocalTime.parse(time0000, dateTimeFormatter);
		LocalTime time24 = LocalTime.parse(time2400, dateTimeFormatter);
		
		if(((LocalTime) temp).isAfter(time18) && ((LocalTime) temp).isBefore(time24)) {
			this.controller.actor.turnOn();
	    }else if(((LocalTime) temp).isAfter(time00) && ((LocalTime) temp).isBefore(time06)){
			this.controller.actor.turnOn();
		}else {
			this.controller.actor.turnOff();
		}
	}
	
}





class Time extends Observable{
	LocalTime time;
	public void setTime(LocalTime time) {
		this.time = time;
		setChanged();
        notifyObservers(this.time);
	}
	
}




