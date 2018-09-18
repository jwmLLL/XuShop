package com.sxx.demo.controller;

import com.sxx.demo.model.shop.ShopConfigModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController()
@RequestMapping(value = "/login")
public class LoginController {
    @RequestMapping(value = "",method = RequestMethod.POST)
    void login(@RequestBody Map<String, String> code) {
        System.out.println("code   "+code.get("code"));
    }
    
}
