package edu.ctu.thesis.travelsystem.extra;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindDigit {
	
	public boolean findDigit(String str) {
		String pattern = "[0-9]";
		//create patter object
		Pattern p = Pattern.compile(pattern);
		//create matcher object
		Matcher m = p.matcher(str);
		if (m.find()) {
			return true;
		}
		else {
			return false;
		}
	}

}
