package edu.ctu.thesis.travelsystem.extra;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidUtil {
	static String pattern = "[a-z,A-Z,\\s]";
	static Pattern p = Pattern.compile(pattern);
	static String pattern2 = "[0-9]";
	static Pattern p2 = Pattern.compile(pattern2);

	public final boolean findAlphabet(String str) {
		// create matcher object
		Matcher m = p.matcher(str);
		if (m.find()) {
			return true;
		} else {
			return false;
		}
	}

	public final boolean findDigit(String str) {
		// create matcher object
		Matcher m = p2.matcher(str);
		if (m.find()) {
			return true;
		} else {
			return false;
		}
	}
}
