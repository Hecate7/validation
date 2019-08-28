package com.demo.validation.common.bean;

import com.demo.validation.common.bean.impl.ByteLengthValidatorImpl;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;


@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD})
@Constraint(validatedBy = ByteLengthValidatorImpl.class)
public @interface ByteLength {
    int min() default 0;

    int max() default 2147483647;

    String value() default "";

    String message() default "字节长度不符合规范";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
