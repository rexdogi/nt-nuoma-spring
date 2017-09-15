package com.nt.app.validators.uniquevalidator;


import com.nt.app.persistence.dao.UserRepository;
import com.nt.app.persistence.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueValidator implements ConstraintValidator<Unique, String> {

    @Autowired
    private UserRepository userRepository;

    public void initialize(Unique constraintAnnotation) { }

    public boolean isValid(String object, ConstraintValidatorContext constraintContext) {

        return object == null || userRepository.findByEmail(object) == null;

    }

}