package com.example.spring.controller;


import com.example.spring.model.Hr;
import com.example.spring.model.RespBean;
import com.example.spring.service.HrService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/")
public class LoginRegController {

    @Autowired
    HrService hrService;

    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    public RespBean userReg(@Validated Hr hr) {
        int result = hrService.hrReg(hr.getUsername(), hr.getPassword());
        if (result == 1) {
            log.info("注册了一个新用户");
            return RespBean.ok("注册成功！");
        } else if (result == -1) {
            return RespBean.error("该用户已被注册！");
        }
        return RespBean.error("注册失败！");

    }
}
