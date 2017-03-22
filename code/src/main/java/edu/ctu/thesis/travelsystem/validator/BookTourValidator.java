package edu.ctu.thesis.travelsystem.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
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
		// ValidationUtils.rejectIfEmpty(errors, "cusName",
		// "NotEmpty.cusData.cusName");
		// ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cusEmail",
		// "NotEmpty.cusData.cusEmail");
		// ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cusPhone",
		// "NotEmpty.cusData.cusPhone");
		// ValidationUtils.rejectIfEmpty(errors, "cusAddress",
		// "NotEmpty.cusData.cusAddress");

		// Catch length character errors
		// In Customer name field
		if (bookTour.getCusName() != null
				&& (bookTour.getCusName().length() > 40 || bookTour.getCusName().length() < 8)) {
			errors.rejectValue("cusName", "Size.cusData.cusName");
		}
		// In Customer email field
		/*if (bookTour.getCusEmail() != null
				&& (bookTour.getCusEmail().length() > 40 || bookTour.getCusEmail().length() < 10)) {
			errors.rejectValue("cusEmail", "Size.cusData.cusEmail");
		}
		// In Customer phone field
		if (bookTour.getCusPhone() != null
				&& (bookTour.getCusPhone().length() > 15 || bookTour.getCusPhone().length() < 10)) {
			errors.rejectValue("cusPhone", "Size.cusData.cusPhone");
		}*/
		// In Customer address field
		if (bookTour.getCusAddress() != null
				&& (bookTour.getCusAddress().length() > 100 || bookTour.getCusAddress().length() < 6)) {
			errors.rejectValue("cusAddress", "Size.cusData.cusAddress");
		}
		// In Customer id card field
		/*if (bookTour.getCusIdCard() != null
				&& (bookTour.getCusIdCard().length() > 12 || bookTour.getCusIdCard().length() < 10)) {
			errors.rejectValue("cusIdCard", "Size.cusData.cusIdCard");
		}*/

		// Catch characters errors
		// In Customer phone field
		if (bookTour.getCusPhone() != null && (validUtil.findAlphabet(bookTour.getCusPhone()))) {
			errors.rejectValue("cusPhone", "Invalid.cusData.cusPhone");
		}
		// In Customer id card field
		if (bookTour.getCusIdCard() != null && (validUtil.findAlphabet(bookTour.getCusIdCard()))) {
			errors.rejectValue("cusIdCard", "Invalid.cusData.cusIdCard");
		}

		// Catch digit errors in Customer name field
		if (bookTour.getCusName() != null && (validUtil.findDigit(bookTour.getCusName()))) {
			errors.rejectValue("cusName", "Invalid.cusData.cusName");
		}
	}
}
