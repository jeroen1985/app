package com.app.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class TestController {


    @GetMapping("/")
    public String test() {
        return "OK - test";
    }

}