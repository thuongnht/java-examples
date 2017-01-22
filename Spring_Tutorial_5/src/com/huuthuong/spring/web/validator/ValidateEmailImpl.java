package com.huuthuong.spring.web.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidateEmailImpl implements ConstraintValidator<ValidateEmail, String>{

	private int min;
	private int max;
	private String pattern;
	
	@Override
	public void initialize(ValidateEmail constraintAnnotation) {
		min = constraintAnnotation.min();
		max = constraintAnnotation.max();
		pattern = constraintAnnotation.pattern();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value.length()<min || value.length()>max) return false;
		
		if (!value.matches(pattern)) return false;
		return true;
	}

}
