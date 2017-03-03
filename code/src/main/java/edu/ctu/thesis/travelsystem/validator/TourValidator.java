package edu.ctu.thesis.travelsystem.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import edu.ctu.thesis.travelsystem.model.Tour;
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
		//Catch empty errors
		ValidationUtils.rejectIfEmpty(errors, "tourName", "NotEmpty.tourData.tourName");
		ValidationUtils.rejectIfEmpty(errors, "departureDate", "NotEmpty.tourData.departureDate");
		ValidationUtils.rejectIfEmpty(errors, "departureTime", "NotEmpty.tourData.departureTime");
		ValidationUtils.rejectIfEmpty(errors, "returnDate", "NotEmpty.tourData.returnDate");
		ValidationUtils.rejectIfEmpty(errors, "returnTime", "NotEmpty.tourData.returnTime");
		ValidationUtils.rejectIfEmpty(errors, "price", "NotEmpty.tourData.price");
		ValidationUtils.rejectIfEmpty(errors, "quantum", "NotEmpty.tourData.quantum");
		ValidationUtils.rejectIfEmpty(errors, "tourDetail", "NotEmpty.tourData.tourDetail");
		// Catch other errors
	}
}
