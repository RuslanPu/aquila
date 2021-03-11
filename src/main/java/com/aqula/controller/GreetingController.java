package com.aqula.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class GreetingController {


    @GetMapping(value = "/admin")
    public String index() {
        return "/admin";
    }

}
