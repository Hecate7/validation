package com.demo.validation.common.aop;

import com.demo.validation.common.exception.ParamErrorException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.hibernate.validator.HibernateValidator;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

@Aspect
@Component
public class ParamCheckAspect {
    @Before("execution(public * com.demo.validation.controller..*.*(..))")
    public void doBefore(JoinPoint joinPoint){
        Validator validator = Validation
                .byProvider(HibernateValidator.class)
                .configure()
                .failFast(false)
                .buildValidatorFactory()
                .getValidator();

        for (Object arg : joinPoint.getArgs()) {
            Set<ConstraintViolation<Object>> validation = validator.validate(arg);
            if (validation != null){
                StringBuilder name = new StringBuilder();
                StringBuilder value = new StringBuilder();
                StringBuilder message = new StringBuilder();
                for (ConstraintViolation<Object> violation : validation) {
                    name.append(violation.getConstraintDescriptor().getAttributes().get("value")).append("|");
                    value.append(violation.getInvalidValue()).append("|");
                    message.append(violation.getMessage()).append("|");
                }
                throw new ParamErrorException(name.toString(), value.toString(), message.toString());
            }
        }
    }
}
