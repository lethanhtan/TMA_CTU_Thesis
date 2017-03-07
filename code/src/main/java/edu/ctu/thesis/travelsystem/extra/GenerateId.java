package edu.ctu.thesis.travelsystem.extra;
import org.apache.commons.lang3.RandomStringUtils;

public class GenerateId {
	
	public String generateIdUser(String userName) {
		return new String(userName.substring(0, 3) + RandomStringUtils.randomAlphanumeric(6)).toUpperCase();
	}
	public String generateIdTour() {
		return new String("TOUR" + RandomStringUtils.randomAlphanumeric(6)).toUpperCase();
	}
	
	public String generateIdBT() {
		return new String("BOOK" + RandomStringUtils.randomAlphanumeric(6)).toUpperCase();
	}
}
