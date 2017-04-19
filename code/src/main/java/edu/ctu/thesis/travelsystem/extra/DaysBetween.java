package edu.ctu.thesis.travelsystem.extra;

import java.util.Calendar;
import java.util.Date;

public class DaysBetween {
	public int daysBetween(Date date1, Date date2) {
		Calendar day1 = Calendar.getInstance();
		Calendar day2 = Calendar.getInstance();
		day1.setTime(date1);
		day2.setTime(date2);
		int daysBetween = day1.get(Calendar.DAY_OF_YEAR) - day2.get(Calendar.DAY_OF_YEAR);
		return daysBetween;
	}
}
