package id.ac.sgu.homecontroller;
import java.time.*;
import java.time.format.*;

public class TimeParser {

	DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_TIME;
	 
	public LocalTime parser(String time) {
		LocalTime parsedTime = LocalTime.parse(time, dateTimeFormatter);
	    return parsedTime;
	}
}
