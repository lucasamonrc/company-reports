package reports;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * This is a utility class to handle operations with date and time. All of its
 * methods are static and are used in the project to handle time calculation and
 * conversion.
 * 
 * @authors Lucas Castro  
 *  
 */
public class DatetimeUtils {
	public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm";

	/**
	 * This functions converts miliseconds into a hours-minutes representation.
	 * 
	 * @param miliseconds - the duration in ms to be converted.
	 * @return a string in the format HH:mm representing the duration in hours and
	 *         minutes.
	 */
	public static String msToHoursAndMinutes(long miliseconds) {
		Duration time = Duration.ofMillis(miliseconds);

		long hours = time.toHours();
		int minutes = time.toMinutesPart();

		return String.format("%02d:%02d", hours, minutes);
	}

	/**
	 * This function calculates the time difference in miliseconds between two dates
	 * in the "yyyy-MM-dd HH:mm" format.
	 * 
	 * @param start - the start date
	 * @param end   - the end date
	 * @return the time difference in miliseconds
	 */
	public static long timeDifferenceInMili(String start, String end) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATETIME_FORMAT);

		LocalDateTime _start = LocalDateTime.parse(start, formatter);
		LocalDateTime _end = LocalDateTime.parse(end, formatter);

		return Duration.between(_start, _end).toMillis();
	}

	/**
	 * This functions converts date and time to a ISO format, so it can be used with
	 * the other utility functions of this class.
	 * 
	 * @param date - the date string portion formatted as "MM/dd/yyyy"
	 * @param time - the time string portion formatted as "HH:mm AM"
	 * @return a datetime string formatted as "yyyy-MM-dd HH:mm"
	 */
	public static String toISOString(String date, String time) {
		String isoDate = dateToISO(date);
		String isoTime = timeToISO(time);

		return isoDate + " " + isoTime;
	}

	/**
	 * This helper function takes in a date string and converts it to the ISO
	 * format.
	 * 
	 * @param date - the date sring formatted as "MM/dd/yyyy"
	 * @return the ISO format of the date: "yyyy-MM-dd"
	 */
	private static String dateToISO(String date) {
		String[] dateParts = date.split("/");

		String _year = dateParts[2], _month = dateParts[0], _day = dateParts[1];

		int year = Integer.parseInt(_year);
		int month = Integer.parseInt(_month);
		int day = Integer.parseInt(_day);

		return String.format("%d-%02d-%02d", year, month, day);
	}

	/**
	 * This helper function takes in a time string and converts it to the ISO
	 * format.
	 * 
	 * @param time - the date sring formatted as "HH:mm AM"
	 * @return the ISO format of the time: "HH:mm" (0-23):(0-59)
	 */
	private static String timeToISO(String time) {
		String[] timeParts = time.split(" ");
		String[] hoursAndMinutes = timeParts[0].split(":");

		int minutes = Integer.parseInt(hoursAndMinutes[1]);
		int hours = Integer.parseInt(hoursAndMinutes[0]);

		if (timeParts[1].equals("AM") && hours == 12) {
			hours = 0;
		}

		if (timeParts[1].equals("PM") && hours != 12) {
			hours += 12;
		}

		return String.format("%02d:%02d", hours, minutes);
	}

}
