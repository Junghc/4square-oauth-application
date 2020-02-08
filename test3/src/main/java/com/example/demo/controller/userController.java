package com.example.demo.controller;

import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;


@Controller
public class userController {

    @ResponseBody
    @RequestMapping("/user")


    public ModelAndView getapincode(@RequestParam String code){

        String api="users/self/venuelikes";
        return new ModelAndView("redirect:/foursquareApiList?code="+code+"&api="+api);
    }


}
