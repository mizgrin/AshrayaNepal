package com.ssm.ashrayanepal.service;

import java.sql.Connection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ssm.ashrayanepal.model.User;

@Component

public class UserValidator implements Validator{
	
	@Autowired
	UserService userService;

	
	public boolean supports (Class<?> aClass){
		return User.class.equals(aClass);
		
	}


	public void validate(Object o, Errors errors) {
		User user =(User) o;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
		if (user.getUserName().length()<6||user.getUserName().length()>32){
		errors.rejectValue("usename","Duplicate.userForm.username");
		
		}
		if (userService.findByUsername(user.getUserName())!=null){
			errors.rejectValue("username", "Duplicate.userform.username");
			
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
		if (user.getUserPassword().length()<8||user.getUserPassword().length()>50){
		errors.rejectValue("password", "size.userForm.password");
		
		}
		if (!user.getUserPasswordConfirm().equals(user.getUserPassword())){
			errors.rejectValue("password","diff.userForm.passwordconfirm" );
		}
		

	}


	public boolean validate(Connection arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}


	


	

}
