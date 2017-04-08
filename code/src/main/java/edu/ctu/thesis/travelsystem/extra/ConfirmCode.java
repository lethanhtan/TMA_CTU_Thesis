package edu.ctu.thesis.travelsystem.extra;

import org.apache.log4j.Logger;

public class ConfirmCode {
	private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	private static final Logger logger = Logger.getLogger(ConfirmCode.class);
	
	public static String generateCode(int count) {
		StringBuilder builder = new StringBuilder();

		while (count-- != 0) {

		int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());

		builder.append(ALPHA_NUMERIC_STRING.charAt(character));

		}

		return builder.toString();
	}
	public static void main(String[] args) {
		logger.info(generateCode(6));
	}
	
}

