package com.demo.validation.common.util;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Data
public class ResultUtil<T> implements Serializable {
    private int resultCode;
    private String resultInfo;
    private Object result;
    private List<T> data;

    public ResultUtil() {
    }

    public ResultUtil(int resultCode, String resultInfo) {
        this.resultCode = resultCode;
        this.resultInfo = resultInfo;
    }
}
