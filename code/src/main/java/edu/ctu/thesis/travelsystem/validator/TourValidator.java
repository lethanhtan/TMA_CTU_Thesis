package edu.ctu.thesis.travelsystem.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import edu.ctu.thesis.travelsystem.extra.FindAlphabet;
import edu.ctu.thesis.travelsystem.model.Tour;
import edu.ctu.thesis.travelsystem.model.User;
import edu.ctu.thesis.travelsystem.service.TourService;

@Component
public class TourValidator implements Validator {

	@Autowired
	TourService tourService;

	@Override
	public boolean supports(Class<?> arg0) {
		return Tour.class.equals(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Tour tour = (Tour) target;
		FindAlphabet findAl = new FindAlphabet();

		// Catch empty errors
		ValidationUtils.rejectIfEmpty(errors, "tourName", "NotEmpty.tourData.tourName");
		ValidationUtils.rejectIfEmpty(errors, "departureDate", "NotEmpty.tourData.departureDate");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "departureTime", "NotEmpty.tourData.departureTime");
		ValidationUtils.rejectIfEmpty(errors, "returnDate", "NotEmpty.tourData.returnDate");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "returnTime", "NotEmpty.tourData.returnTime");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "NotEmpty.tourData.price");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "quantum", "NotEmpty.tourData.quantum");
		ValidationUtils.rejectIfEmpty(errors, "tourDetail", "NotEmpty.tourData.tourDetail");

		// Catch length character errors
		// In Tour name field
		if (tour.getTourName().length() > 50 || tour.getTourName().length() < 6) {
			errors.rejectValue("tourName", "Size.tourData.tourName");
		}
		// In Tour detail field
		if (tour.getTourDetail().length() > 2000 || tour.getTourDetail().length() < 10) {
			errors.rejectValue("tourDetail", "Size.tourData.tourDetail");
		}

		// Catch characters errors
		// In Departure time field
		if (findAl.findAlphabet(tour.getDepartureTime())) {
			errors.rejectValue("departureTime", "Invalid.tourData.departureTime");
		}
		// In Return time field
		if (findAl.findAlphabet(tour.getReturnTime())) {
			errors.rejectValue("returnTime", "Invalid.tourData.returnTime");
		}
		// In Price field
		if (findAl.findAlphabet(tour.getPrice())) {
			errors.rejectValue("price", "Invalid.tourData.price");
		}
		// In Quantum field
		if (findAl.findAlphabet(tour.getQuantum())) {
			errors.rejectValue("quantum", "Invalid.tourData.quantum");
		}
	}
}
