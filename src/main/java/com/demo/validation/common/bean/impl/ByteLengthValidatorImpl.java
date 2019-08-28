package com.demo.validation.common.bean.impl;

import com.demo.validation.common.bean.ByteLength;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.io.UnsupportedEncodingException;

public class ByteLengthValidatorImpl implements ConstraintValidator<ByteLength, Object> {
    private int min;
    private int max;
    @Override
    public void initialize(ByteLength constraintAnnotation) {
        this.min = constraintAnnotation.min();
        this.max = constraintAnnotation.max();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        try {
            int byteLength = ((String)o).getBytes("GBK").length;
            if (byteLength >= min && byteLength <= max){
                return true;
            }
            return false;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return false;
    }
}
