package edu.ctu.thesis.travelsystem.extra;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidUtil {
	public static String pattern = "[a-z,A-Z,\\s]";
	public static Pattern p = Pattern.compile(pattern);
	public static String pattern2 = "[0-9]";
	public static Pattern p2 = Pattern.compile(pattern2);

	public static boolean findAlphabet(String str) {
		// create matcher object
		Matcher m = p.matcher(str);
		if (m.find()) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean findDigit(String str) {
		// create matcher object
		Matcher m = p2.matcher(str);
		if (m.find()) {
			return true;
		} else {
			return false;
		}
	}
}
