package com.sachinkhetarpal.jwt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {

    @RequestMapping("/welcome")
    public String welcome()
    {
        String text = "This is a private page";
        return text;
    }
}
