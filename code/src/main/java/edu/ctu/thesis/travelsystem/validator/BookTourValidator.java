package edu.ctu.thesis.travelsystem.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import edu.ctu.thesis.travelsystem.extra.ValidUtil;
import edu.ctu.thesis.travelsystem.model.BookTour;
import edu.ctu.thesis.travelsystem.service.BookTourService;

@Component
public class BookTourValidator implements Validator {

	@Autowired
	BookTourService bookTourService;

	@Override
	public boolean supports(Class<?> arg0) {
		return BookTour.class.equals(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {
		BookTour bookTour = (BookTour) target;
		ValidUtil validUtil = new ValidUtil();

		// Catch empty errors
		ValidationUtils.rejectIfEmpty(errors, "cusName", "NotEmpty.cusData.cusName");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cusEmail", "NotEmpty.cusData.cusEmail");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cusPhone", "NotEmpty.cusData.cusPhone");
		ValidationUtils.rejectIfEmpty(errors, "cusAddress", "NotEmpty.cusData.cusAddress");

		// Catch length character errors
		// In Customer name field
		if (bookTour.getCusName().length() > 40 || bookTour.getCusName().length() < 6) {
			errors.rejectValue("cusName", "Size.cusData.cusName");
		}
		// In Customer address field
		if (bookTour.getCusAddress().length() > 100 || bookTour.getCusAddress().length() < 6) {
			errors.rejectValue("cusAddress", "Size.cusData.cusAddress");
		}

		//ValidUtil validaUtil;
		// Catch characters error in Customer phone field
		if (validUtil.findAlphabet(bookTour.getCusPhone())) {
			errors.rejectValue("cusPhone", "Invalid.cusData.cusPhone");
		}
		
		// Catch digit error in Customer name field
		if (validUtil.findDigit(bookTour.getCusName())) {
			errors.rejectValue("cusName", "Invalid.cusData.cusName");
		}
	}
}
