package edu.ctu.thesis.travelsystem.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

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
		
		//User user =(User) target;
		//Catch empty errors
		ValidationUtils.rejectIfEmpty(errors, "userName", "NotEmpty.customerData.userName");
		ValidationUtils.rejectIfEmpty(errors, "password", "NotEmpty.customerData.password");
		ValidationUtils.rejectIfEmpty(errors, "passwordConfirm", "NotEmpty.customerData.passwordConfirm");
		ValidationUtils.rejectIfEmpty(errors, "nameUser", "NotEmpty.customerData.nameUser");
		ValidationUtils.rejectIfEmpty(errors, "addressUser", "NotEmpty.customerData.addressUser");
		ValidationUtils.rejectIfEmpty(errors, "phoneUser", "NotEmpty.customerData.phoneUser");
		ValidationUtils.rejectIfEmpty(errors, "emailUser", "NotEmpty.customerData.emailUser");
		ValidationUtils.rejectIfEmpty(errors, "sex", "NotEmpty.customerData.sex");
		ValidationUtils.rejectIfEmpty(errors, "dateUser", "NotEmpty.customerData.dateUser");
		
		//Catch other errors
	}
	

}
