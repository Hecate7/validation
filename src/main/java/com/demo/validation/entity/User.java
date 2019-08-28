package com.demo.validation.entity;

import com.demo.validation.common.bean.ByteLength;
import lombok.Data;

import javax.validation.Valid;

@Data
public class User {
    @ByteLength(min = 5 ,max = 10,value = "userName", message = "最小字节长度为5，最大字节长度为10")
    private String userName;
    private String userNo;
    @Valid
    private User user;
}
