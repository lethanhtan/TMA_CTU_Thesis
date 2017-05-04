package edu.ctu.thesis.travelsystem.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import edu.ctu.thesis.travelsystem.extra.ValidUtil;
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
		Tour tour = (Tour) target;
		ValidUtil validUtil = new ValidUtil();
		
		// Catch empty errors
		ValidationUtils.rejectIfEmpty(errors, "name", "NotEmpty.tourData.name");
		ValidationUtils.rejectIfEmpty(errors, "departureDate", "NotEmpty.tourData.departureDate");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "departureTime", "NotEmpty.tourData.departureTime");
		ValidationUtils.rejectIfEmpty(errors, "returnDate", "NotEmpty.tourData.returnDate");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "returnTime", "NotEmpty.tourData.returnTime");
		ValidationUtils.rejectIfEmpty(errors, "price", "NotEmpty.tourData.price");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "quantum", "NotEmpty.tourData.quantum");
		ValidationUtils.rejectIfEmpty(errors, "detail", "NotEmpty.tourData.detail");

		// Catch length character errors
		// In Tour name field
		if (tour.getName().length() > 200 || tour.getName().length() < 6) {
			errors.rejectValue("name", "Size.tourData.name");
		}
		// In Tour detail field
		//if (tour.getDetail().length() > 5000 || tour.getDetail().length() < 10) {
		//	errors.rejectValue("detail", "Size.tourData.detail");
		//}

		// Catch characters errors
		// In Departure time field
		if (validUtil.findAlphabet(tour.getDepartureTime())) {
			errors.rejectValue("departureTime", "Invalid.tourData.departureTime");
		}
		// In Return time field
		if (validUtil.findAlphabet(tour.getReturnTime())) {
			errors.rejectValue("returnTime", "Invalid.tourData.returnTime");
		}
	}
}
