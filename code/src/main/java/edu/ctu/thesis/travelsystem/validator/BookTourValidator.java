package edu.ctu.thesis.travelsystem.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import edu.ctu.thesis.travelsystem.dto.BookTourInfoVO;
import edu.ctu.thesis.travelsystem.dto.SubBookTourVO;
import edu.ctu.thesis.travelsystem.extra.ValidUtil;
import edu.ctu.thesis.travelsystem.model.BookTour;
import edu.ctu.thesis.travelsystem.model.Tour;
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

		// Catch characters errors
		// In Customer phone field
		if (bookTour.getCusPhone() != null && (validUtil.findAlphabet(bookTour.getCusPhone()))) {
			errors.rejectValue("cusPhone", "Invalid.cusData.cusPhone");
		}
		// In Customer id card field
		if (bookTour.getCusIdCard() != null && (validUtil.findAlphabet(bookTour.getCusIdCard()))) {
			errors.rejectValue("cusIdCard", "Invalid.cusData.cusIdCard");
		}

		// Catch digit errors
		// In Customer name field
		if (bookTour.getCusName() != null && (validUtil.findDigit(bookTour.getCusName()))) {
			errors.rejectValue("cusName", "Invalid.cusData.cusName");
		}
	}

	public boolean validateRegister(ModelMap model, Tour tour, List<BookTourInfoVO> bookTourInfos, int numOfTicket) {
		List<String> invalidInfos = new ArrayList<String>();
		SubBookTourVO cusData = new SubBookTourVO();
		List<BookTourInfoVO> infos = new ArrayList<>(numOfTicket);
		for (BookTourInfoVO info : bookTourInfos) {
			// Catch error for customer name if field customer name not null 
			if (tour.getFieldName()) {
				if (ValidUtil.findDigit(info.getCusName()) || info.getCusName() == null
						|| info.getCusName().length() > 40 || info.getCusName().length() < 8) {
					info.setValidCusName(false);
				}
			}
			
			// Catch error for customer year of birth if field customer year of birth not null
			if (tour.getFieldYearOfBirth()) {
				if (ValidUtil.findAlphabet(info.getCusYearOfBirth()) || info.getCusYearOfBirth() == null
						|| info.getCusYearOfBirth().length() != 4) {
					info.setValidCusYearOfBirth(false);
				}
			}
			
			// Catch error for customer phone if field customer phone not null
			if (tour.getFieldPhone()) {
				if (ValidUtil.findAlphabet(info.getCusPhone()) || info.getCusPhone() == null
						|| info.getCusPhone().length() > 15 || info.getCusPhone().length() < 10) {
					info.setValidCusPhone(false);
				}
			}
			
			// Catch error for customer email if field customer email not null
			if (tour.getFieldEmail()) {
				if (info.getCusEmail() == null || info.getCusEmail().length() > 40 || info.getCusEmail().length() < 10) {
					info.setValidCusEmail(false);
				}
			}

			
			// Catch error for customer address if field customer address not null
			if (tour.getFieldAddress()) {
				if (info.getCusAddress() == null | info.getCusAddress().length() > 100 || info.getCusAddress().length() < 6) {
					info.setValidCusAddress(false);
				}
			}

			// Catch error for customer id card if field customer id card not null
			if (tour.getFieldIdCard()) {
				if (ValidUtil.findAlphabet(info.getCusIdCard()) || info.getCusIdCard() == null
						|| info.getCusIdCard().length() > 12 || info.getCusIdCard().length() < 9) {
					info.setValidCusIdCard(false);
				}
			}

			if (!info.isValidCusName() || !info.isValidCusAddress() || !info.isValidCusPhone()
					|| !info.isValidCusYearOfBirth() || !info.isValidCusIdCard() || !info.isValidCusEmail()) {
				invalidInfos.add(info.getCusName());
			}
			infos.add(info);
			cusData.setInfo(infos);
			model.addAttribute("cusData", cusData);
		}
		return invalidInfos.isEmpty();
	}
}
