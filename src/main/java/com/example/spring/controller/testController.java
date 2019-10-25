package com.example.spring.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {
    @RequestMapping("test")
    public Byte[] test(){
        Byte[] bytes = {1,2,3,4,5,6,7,8,9};
        return bytes;
    }
}
