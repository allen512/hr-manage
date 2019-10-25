package com.example.spring.controller;

import com.example.spring.model.Hr;
import com.example.spring.model.Menu;
import com.example.spring.service.MenuService;
import com.example.spring.util.HrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/config")
public class ConfigController {
    @Autowired
    MenuService menuService;

    @RequestMapping("/sysmenu")
    public List<Menu> sysmenu() {
        return menuService.getMenusByHrId();
    }

    @RequestMapping("/user")
    public Hr currentUser() {
        return HrUtils.getCurrentHr();
    }
}
