package edu.ctu.thesis.travelsystem.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import edu.ctu.thesis.travelsystem.extra.ValidUtil;
import edu.ctu.thesis.travelsystem.model.User;
import edu.ctu.thesis.travelsystem.service.UserService;

@Component
public class UserValidator implements Validator {
	@Autowired
	UserService userService;
	
	@Override
	public boolean supports(Class<?> arg0) {
		return User.class.equals(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		ValidUtil validUtil = new ValidUtil();
		
		// Catch empty and whitespace errors
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "NotEmpty.userData.userName");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.userData.password");
		ValidationUtils.rejectIfEmpty(errors, "fullName", "NotEmpty.userData.fullName");
		ValidationUtils.rejectIfEmpty(errors, "address", "NotEmpty.userData.address");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "NotEmpty.userData.phone");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.userData.email");

		// Catch other errors
		// Catch size user name
		if (user.getUserName().length() > 40 || user.getUserName().length() < 6) {
			errors.rejectValue("userName", "Size.userData.userName");
		}

		// catch size password
		if (user.getPassword().length() > 20 || user.getPassword().length() < 8) {
			errors.rejectValue("password", "Size.userData.password");
		}
		// cath fullname exception
		if (user.getFullName().length() > 80 || user.getFullName().length() < 8) {
			errors.rejectValue("fullName", "Size.userData.fullName");
		}
		if (validUtil.findDigit(user.getFullName())) {
			errors.rejectValue("fullName", "Invalid.userData.fullName");
		}

		// catch phone invalid
		if (validUtil.findAlphabet(user.getPhone())) {
			errors.rejectValue("phone", "Invalid.userData.phone");
		}
		
		
	}
}