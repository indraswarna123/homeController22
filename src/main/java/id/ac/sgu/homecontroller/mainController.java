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
	
	public String getTimerOn() {
		return this.actor.getTimerOn();
	}
	
	public String getTimerOff() {
		return this.actor.getTimerOff();
	}
	
	public int getStatus() {
		return this.actor.getStatus();
	}
	
	public void setTimerOn(String time) {
		this.actor.setTimerOn(time);
	}
	
	public void setTimerOff(String time) {
		this.actor.setTimerOff(time);
	}
	
	public void setStatus(int status) {
		this.actor.setStatus(status);
	}
	
	
}

class TemperatureObserver implements Observer {
	mainController controller;   
	public TemperatureObserver(mainController controller) {
		this.controller = controller;
	}
	
	@Override
	public void update(Observable o, Object temp) {
		if((Double)temp>22.0) {
			this.controller.actor.setStatus(1);
			System.out.println(this.controller.getStatus());
		}else {
			this.controller.actor.setStatus(0);
			System.out.println(this.controller.getStatus());
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

class ACTimeObserver implements Observer {
	mainController controller;
	DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_TIME;
	public ACTimeObserver(mainController controller) {
		this.controller = controller;
	}
	
	@Override
	public void update(Observable o, Object temp) {
		
		String time0000 = "00:00";
		String time2400 = "23:59";
		String time1200 = "12:00";
		
		String timeOn = controller.getTimerOn();
		String timeOff = controller.getTimerOff();
		LocalTime parsedTimeOn = LocalTime.parse(timeOn, dateTimeFormatter);
		LocalTime parsedTimeOff = LocalTime.parse(timeOff, dateTimeFormatter);
		LocalTime parsedTime00 = LocalTime.parse(time0000, dateTimeFormatter);
		LocalTime parsedTime12 = LocalTime.parse(time1200, dateTimeFormatter);		
		LocalTime parsedTime24 = LocalTime.parse(time2400, dateTimeFormatter);
		
		if(this.controller.getStatus() == 1) {
			if(((LocalTime) temp).isAfter(parsedTime12) && ((LocalTime) temp).isBefore(parsedTime24)){
				if(((LocalTime) temp).isAfter(parsedTimeOn)) {
					this.controller.setStatus(0);
					this.controller.actor.turnOn();
				}else {
					this.controller.setStatus(1);
					this.controller.actor.turnOff();
				}
			}else if(((LocalTime) temp).isAfter(parsedTime00) && ((LocalTime) temp).isBefore(parsedTime12)){
				if(((LocalTime) temp).isAfter(parsedTimeOff)) {
					this.controller.setStatus(1);
					this.controller.actor.turnOff();
				}else {
					this.controller.setStatus(0);
					this.controller.actor.turnOn();
				}
			}
		}else {
			this.controller.setStatus(0);
		}
		
		
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
		
		String time0000 = "00:00";
		String time2400 = "23:59";
		String time1200 = "12:00";
		
		String timeOn = controller.getTimerOn();
		String timeOff = controller.getTimerOff();
		LocalTime parsedTimeOn = LocalTime.parse(timeOn, dateTimeFormatter);
		LocalTime parsedTimeOff = LocalTime.parse(timeOff, dateTimeFormatter);
		LocalTime parsedTime00 = LocalTime.parse(time0000, dateTimeFormatter);
		LocalTime parsedTime12 = LocalTime.parse(time1200, dateTimeFormatter);		
		LocalTime parsedTime24 = LocalTime.parse(time2400, dateTimeFormatter);

		if(((LocalTime) temp).isAfter(parsedTime12) && ((LocalTime) temp).isBefore(parsedTime24)){
			if(((LocalTime) temp).isAfter(parsedTimeOn)) {
				this.controller.actor.setStatus(0);
				this.controller.actor.turnOff();
				
			}else {
				this.controller.actor.setStatus(1);
				this.controller.actor.turnOn();
			}
		}else if(((LocalTime) temp).isAfter(parsedTime00) && ((LocalTime) temp).isBefore(parsedTime12)){
			if(((LocalTime) temp).isAfter(parsedTimeOff)) {
				this.controller.actor.setStatus(1);
				this.controller.actor.turnOn();
			}else {
				this.controller.actor.setStatus(0);
				this.controller.actor.turnOff();
			}
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
		String time0000 = "00:00";
		String time2400 = "23:59";
		String time1200 = "12:00";
		
		String timeOn = controller.getTimerOn();
		String timeOff = controller.getTimerOff();
		LocalTime parsedTimeOn = LocalTime.parse(timeOn, dateTimeFormatter);
		LocalTime parsedTimeOff = LocalTime.parse(timeOff, dateTimeFormatter);
		LocalTime parsedTime00 = LocalTime.parse(time0000, dateTimeFormatter);
		LocalTime parsedTime12 = LocalTime.parse(time1200, dateTimeFormatter);		
		LocalTime parsedTime24 = LocalTime.parse(time2400, dateTimeFormatter);

		if(((LocalTime) temp).isAfter(parsedTime12) && ((LocalTime) temp).isBefore(parsedTime24)){
			if(((LocalTime) temp).isAfter(parsedTimeOn)) {
				this.controller.actor.setStatus(1);
				this.controller.actor.turnOn();
			}else {
				this.controller.actor.setStatus(0);
				this.controller.actor.turnOff();
			}
		}else if(((LocalTime) temp).isAfter(parsedTime00) && ((LocalTime) temp).isBefore(parsedTime12)){
			if(((LocalTime) temp).isAfter(parsedTimeOff)) {
				this.controller.actor.setStatus(0);
				this.controller.actor.turnOff();
			}else {
				this.controller.actor.setStatus(1);
				this.controller.actor.turnOn();
			}
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




