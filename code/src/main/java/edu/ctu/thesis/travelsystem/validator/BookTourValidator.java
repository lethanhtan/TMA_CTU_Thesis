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

		// Catch length character errors
		// In Customer name field
		if (bookTour.getCusName() != null
				&& (bookTour.getCusName().length() > 40 || bookTour.getCusName().length() < 8)) {
			errors.rejectValue("cusName", "Size.cusData.cusName");
		}
		// In Customer email field
		if (bookTour.getCusEmail() != null
				&& (bookTour.getCusEmail().length() > 40 || bookTour.getCusEmail().length() < 10)) {
			errors.rejectValue("cusEmail", "Size.cusData.cusEmail");
		}
		// In Customer phone field
		if (bookTour.getCusPhone() != null
				&& (bookTour.getCusPhone().length() > 15 || bookTour.getCusPhone().length() < 10)) {
			errors.rejectValue("cusPhone", "Size.cusData.cusPhone");
		}
		// In Customer address field
		if (bookTour.getCusAddress() != null
				&& (bookTour.getCusAddress().length() > 100 || bookTour.getCusAddress().length() < 6)) {
			errors.rejectValue("cusAddress", "Size.cusData.cusAddress");
		}
		// In Customer id card field
		if (bookTour.getCusIdCard() != null
				&& (bookTour.getCusIdCard().length() > 12 || bookTour.getCusIdCard().length() < 9)) {
			errors.rejectValue("cusIdCard", "Size.cusData.cusIdCard");
		}
		// In Customer nam 1 field
		if (bookTour.getCusName1() != null
				&& (bookTour.getCusName1().length() > 40 || bookTour.getCusName1().length() < 8)) {
			errors.rejectValue("cusName1", "Size.cusData.cusName1");
		}
		// In Customer nam 2 field
		if (bookTour.getCusName2() != null
				&& (bookTour.getCusName2().length() > 40 || bookTour.getCusName2().length() < 8)) {
			errors.rejectValue("cusName2", "Size.cusData.cusName2");
		}
		// In Customer nam 3 field
		if (bookTour.getCusName3() != null
				&& (bookTour.getCusName3().length() > 40 || bookTour.getCusName3().length() < 8)) {
			errors.rejectValue("cusName3", "Size.cusData.cusName3");
		}
		// In Customer year of birth 1 field
		if (bookTour.getCusYearOfBirth1() != null && (bookTour.getCusYearOfBirth1().length() != 4)) {
			errors.rejectValue("cusYearOfBirth1", "Size.cusData.cusYearOfBirth1");
		}
		// In Customer year of birth 2 field
		if (bookTour.getCusYearOfBirth2() != null && (bookTour.getCusYearOfBirth2().length() != 4)) {
			errors.rejectValue("cusYearOfBirth2", "Size.cusData.cusYearOfBirth2");
		}
		// In Customer year of birth 3 field
		if (bookTour.getCusYearOfBirth3() != null && (bookTour.getCusYearOfBirth1().length() != 4)) {
			errors.rejectValue("cusYearOfBirth3", "Size.cusData.cusYearOfBirth3");
		}

		// Catch characters errors
		// In Customer phone field
		if (bookTour.getCusPhone() != null && (validUtil.findAlphabet(bookTour.getCusPhone()))) {
			errors.rejectValue("cusPhone", "Invalid.cusData.cusPhone");
		}
		// In Customer id card field
		if (bookTour.getCusIdCard() != null && (validUtil.findAlphabet(bookTour.getCusIdCard()))) {
			errors.rejectValue("cusIdCard", "Invalid.cusData.cusIdCard");
		}
		// In Customer year of birth 1 field
		if (bookTour.getCusYearOfBirth1() != null && (validUtil.findAlphabet(bookTour.getCusYearOfBirth1()))) {
			errors.rejectValue("cusYearOfBirth1", "Invalid.cusData.cusYearOfBirth1");
		}
		// In Customer year of birth 2 field
		if (bookTour.getCusYearOfBirth2() != null && (validUtil.findAlphabet(bookTour.getCusYearOfBirth2()))) {
			errors.rejectValue("cusYearOfBirth2", "Invalid.cusData.cusYearOfBirth2");
		}
		// In Customer year of birth 3 field
		if (bookTour.getCusYearOfBirth3() != null && (validUtil.findAlphabet(bookTour.getCusYearOfBirth3()))) {
			errors.rejectValue("cusYearOfBirth3", "Invalid.cusData.cusYearOfBirth3");
		}

		// Catch digit errors
		// In Customer name field
		if (bookTour.getCusName() != null && (validUtil.findDigit(bookTour.getCusName()))) {
			errors.rejectValue("cusName", "Invalid.cusData.cusName");
		}
		// In Customer name 1 field
		if (bookTour.getCusName1() != null && (validUtil.findDigit(bookTour.getCusName1()))) {
			errors.rejectValue("cusName1", "Invalid.cusData.cusName1");
		}
		// In Customer name 2 field
		if (bookTour.getCusName2() != null && (validUtil.findDigit(bookTour.getCusName2()))) {
			errors.rejectValue("cusName2", "Invalid.cusData.cusName2");
		}
		// In Customer name 3 field
		if (bookTour.getCusName3() != null && (validUtil.findDigit(bookTour.getCusName3()))) {
			errors.rejectValue("cusName3", "Invalid.cusData.cusName3");
		}
	}
}
