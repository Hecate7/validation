package com.demo.validation.controller;

import com.demo.validation.common.util.ResultUtil;
import com.demo.validation.entity.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user", method = RequestMethod.POST)
public class UserController {

    @RequestMapping(value = "/demo", method = RequestMethod.POST)
    public ResultUtil demo(@RequestBody(required = false) User user){
        return new ResultUtil();
    }
}
