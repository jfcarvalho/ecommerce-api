package com.group.ecommerce.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StatusValidators implements ConstraintValidator<StatusAtivoInativo, String> {
	@Override
	public void initialize(StatusAtivoInativo constraintAnnotation) {
		
	}
	
	@Override
	public boolean isValid(String valor, ConstraintValidatorContext constraintValidatorContext) {
		if(valor == null || valor.isEmpty())
			return false;
		
		return valor.toUpperCase().equals("ATIVO") || valor.toUpperCase().equals("INATIVO");
	}

}
