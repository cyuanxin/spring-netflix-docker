package com.zyx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhangyuanxin on 2017/3/13.
 */
@RestController
public class IndexController {
    @Autowired
    private Environment environment;
    @RequestMapping("hello")
    public String hello() {
        return "HellWorld now env:" + environment.getActiveProfiles()[0];
    }
}
