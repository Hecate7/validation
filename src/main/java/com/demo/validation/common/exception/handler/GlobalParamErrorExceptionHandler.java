package com.demo.validation.common.exception.handler;

import com.demo.validation.common.exception.ParamErrorException;
import com.demo.validation.common.util.ResultUtil;
import com.demo.validation.common.util.RetCodeUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Arrays;
import java.util.List;

@ResponseBody
@ControllerAdvice
public class GlobalParamErrorExceptionHandler {

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(value = {ParamErrorException.class})
    public ResultUtil paramErrorServletRequest(ParamErrorException ex){
        List<String> name = Arrays.asList(ex.getName().split("\\|"));
        List<String> value = Arrays.asList(ex.getValue().split("\\|"));
        List<String> message = Arrays.asList(ex.getMessage().split("\\|"));

        StringBuilder resultInfo = new StringBuilder();
        for (int i = 0; i < name.size(); i++) {
            String info = name.get(i)+"["+value.get(i)+"]"+message.get(i);
            resultInfo.append(info).append(";");
        }
        return new ResultUtil(RetCodeUtils.ERROR, resultInfo.toString());
    }
}
