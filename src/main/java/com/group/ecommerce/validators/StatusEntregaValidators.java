package com.group.ecommerce.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StatusEntregaValidators implements ConstraintValidator<StatusEntrega, String> {
	
	@Override
	public void initialize(StatusEntrega constraintAnnotation) {
		
	}
	
	@Override
	public boolean isValid(String valor, ConstraintValidatorContext constraintValidatorContext) {
		if(valor == null || valor.isEmpty())
			return false;
		
		return valor.toUpperCase().equals("PENDENTE") || valor.toUpperCase().equals("CANCELADO") || valor.toUpperCase().equals("ENTREGUE");
	}

}
