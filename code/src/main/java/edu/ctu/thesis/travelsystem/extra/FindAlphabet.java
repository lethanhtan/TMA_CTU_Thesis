package edu.ctu.thesis.travelsystem.extra;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindAlphabet {
	
	public boolean findAlphabet(String str) {
		String pattern = "[a-z,A-Z,\\s]";
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
