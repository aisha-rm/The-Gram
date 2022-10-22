package com.tmt.thegram;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeValidator implements ConstraintValidator<Age, Date> {

    @Override
    public boolean isValid(Date value, ConstraintValidatorContext context) {
        Date today = new Date();
        long diff = today.getTime() - value.getTime();
        int age = (int) (TimeUnit.MILLISECONDS.toDays(diff)/365);
        if(age > 18){
            return true; //if value meets criteria
        }
        return false;  //value invalid, add error to bindingResult
    }
}
    
