package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class htmlController {

    @GetMapping("/")
    public String indexHtml() {
        return "index";
    }


    @GetMapping("/result")
    public String resultHtml() {
        return "result";
    }

}

