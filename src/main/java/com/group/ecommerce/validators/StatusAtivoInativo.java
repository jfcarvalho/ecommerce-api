package com.group.ecommerce.validators;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = {StatusValidators.class})
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public @interface StatusAtivoInativo {
	String message() default "Status Invalido";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
