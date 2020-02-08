package com.example.demo.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.Map;


@Controller
public class getCode {


    @ResponseBody
    @RequestMapping("/foursquareApiList")

    public static String getAuthData(@RequestParam(required = false) String code,@RequestParam("api") String api) {
        Object result="";
        System.out.println(code);
        //System.out.println("getAuthData");
        String client_id = "ELSFGTITL3RXX33VGCHMJ5XXCHSAKKWN4IHX3W2PL3EC0DEI";
        String client_secret = "FT4XHOCSLPJ3AJ2X2EJUJQWQEFUCONGX12XZET0LSQEO35WO";
        if(code == null){
            System.out.println(api);
            String prefix = "https://api.foursquare.com/v2/";
            //api = "venues/explore?near=taipei";
            String userlessAuth = "&client_id=" + client_id + "&client_secret=" + client_secret + "&v=20190102";
            RestTemplate restTemplate = new RestTemplate();
            //System.out.println(prefix + api);
            result = restTemplate.getForObject(prefix + api + userlessAuth, Object.class);
            System.out.println(result);


        }

        else {


            System.out.println("------");

            String url = "http://140.121.197.137:8080/result";
            String tokenUrl = "https://foursquare.com/oauth2/access_token" +
                    "?client_id=" + client_id +
                    "&client_secret=" + client_secret +
                    "&grant_type=authorization_code" +
                    "&redirect_uri=" + url +
                    "&code=" + code;

            result = userAuth(tokenUrl,api);
            return result.toString();
        }
        return  result.toString();
    }

    public static String userAuth(String tokenUrl, String api){
        //System.out.println(api);
        //System.out.println("userAuth");
        RestTemplate restTemplate = new RestTemplate();
        String myToken = restTemplate.getForObject(tokenUrl, String.class);
        System.out.println(myToken);
        JsonParser springParser = JsonParserFactory.getJsonParser();
        Map<String, Object> map = springParser.parseMap(myToken);
        int i = 0;
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            myToken="";
            System.out.println(entry.getValue());
            myToken = entry.getValue().toString();
            i++;
        }


        String getAuth = "https://api.foursquare.com/v2/"+ api +"?oauth_token="+myToken+"&v=20190102";
        Object result = restTemplate.getForObject(getAuth, Object.class);
        //System.out.println(result);
        return result.toString();


    }
}

