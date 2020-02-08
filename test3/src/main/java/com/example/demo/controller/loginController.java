package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class loginController {

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.GET)

    public ModelAndView method(@RequestParam("api") String api) {
        String client_id = "ELSFGTITL3RXX33VGCHMJ5XXCHSAKKWN4IHX3W2PL3EC0DEI";
        String url = "http://140.121.197.137:8080/user";

        String projectUrl = "https://foursquare.com/oauth2/authenticate" +
                "?client_id="+client_id+
                "&response_type=code" +
                "&redirect_uri="+url;
        System.out.println(projectUrl);
        return new ModelAndView("redirect:" + projectUrl);
    }


}
