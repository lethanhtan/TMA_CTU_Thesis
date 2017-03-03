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
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "NotEmpty.customerData.userName");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.customerData.password");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwordConfirm", "NotEmpty.customerData.passwordConfirm");
		ValidationUtils.rejectIfEmpty(errors, "nameUser", "NotEmpty.customerData.nameUser");
		ValidationUtils.rejectIfEmpty(errors, "addressUser", "NotEmpty.customerData.addressUser");
<<<<<<< HEAD
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phoneUser", "NotEmpty.customerData.phoneUser");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailUser", "NotEmpty.customerData.emailUser");
=======
		ValidationUtils.rejectIfEmpty(errors, "phoneUser", "NotEmpty.customerData.phoneUser");
		ValidationUtils.rejectIfEmpty(errors, "emailUser", "NotEmpty.customerData.emailUser");
>>>>>>> refs/remotes/tma_ctu/master
		ValidationUtils.rejectIfEmpty(errors, "dateUser", "NotEmpty.customerData.dateUser");
		
		//Catch other errors
		//Catch size user name
		if (user.getUserName().length() > 40 || user.getUserName().length() < 6) {
			errors.rejectValue("userName", "Size.customerData.userName");
		}
		
		//catch size password
		if (user.getPassword().length() > 20 || user.getPassword().length() < 8) {
			errors.rejectValue("password", "Size.customerData.password");
		}
		
		//catch not same password confirm
		if (!user.getPasswordConfirm().equals(user.getPassword())) {
			errors.rejectValue("passwordConfirm", "Diff.customerData.passwordConfirm");
		}
		
		//cath fullname exception
		if (user.getNameUser().length() > 80 || user.getNameUser().length() < 8) {
			errors.rejectValue("nameUser", "Size.customerData.nameUser");
		}
		if (fDigit.findDigit(user.getNameUser())) {
			errors.rejectValue("nameUser", "Invalid.customerData.nameUser");
		}
		
		//catch phone invalid
		if (fAlphabet.findAlphabet(user.getPhoneUser())) {
			errors.rejectValue("phoneUser", "Invalid.customerData.phoneUser");
		}
	}
<<<<<<< HEAD
=======
	

>>>>>>> refs/remotes/tma_ctu/master
}