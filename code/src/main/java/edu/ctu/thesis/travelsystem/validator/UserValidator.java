package edu.ctu.thesis.travelsystem.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import edu.ctu.thesis.travelsystem.extra.FindAlphabet;
import edu.ctu.thesis.travelsystem.extra.FindDigit;
import edu.ctu.thesis.travelsystem.model.User;
import edu.ctu.thesis.travelsystem.service.UserService;

@Component
public class UserValidator implements Validator {
	
	FindDigit fDigit = new FindDigit();
	
	FindAlphabet fAlphabet = new FindAlphabet();

	@Autowired
	UserService userService;
	
	
	@Override
	public boolean supports(Class<?> arg0) {

		return User.class.equals(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		User user =(User) target;
		//Catch empty and whitespace errors
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "NotEmpty.userData.userName");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.userData.password");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwordConfirm", "NotEmpty.userData.passwordConfirm");
		ValidationUtils.rejectIfEmpty(errors, "fullName", "NotEmpty.userData.fullName");
		ValidationUtils.rejectIfEmpty(errors, "address", "NotEmpty.userData.address");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "NotEmpty.userData.phone");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.userData.email");
		ValidationUtils.rejectIfEmpty(errors, "birthday", "NotEmpty.userData.birthday");
		
		//Catch other errors
		//Catch size user name
		if (user.getUserName().length() > 40 || user.getUserName().length() < 6) {
			errors.rejectValue("userName", "Size.userData.userName");
		}
		
		//catch size password
		if (user.getPassword().length() > 20 || user.getPassword().length() < 8) {
			errors.rejectValue("password", "Size.userData.password");
		}
		
		//catch not same password confirm
		if (!user.getPasswordConfirm().equals(user.getPassword())) {
			errors.rejectValue("passwordConfirm", "Diff.userData.passwordConfirm");
		}
		
		//cath fullname exception
		if (user.getFullName().length() > 80 || user.getFullName().length() < 8) {
			errors.rejectValue("fullName", "Size.userData.fullName");
		}
		if (fDigit.findDigit(user.getFullName())) {
			errors.rejectValue("fullName", "Invalid.userData.fullName");
		}
		
		//catch phone invalid
		if (fAlphabet.findAlphabet(user.getPhone())) {
			errors.rejectValue("phone", "Invalid.userData.phone");
		}
	}
}