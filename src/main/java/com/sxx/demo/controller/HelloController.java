package com.sxx.demo.controller;

import com.sxx.demo.model.shop.ShopConfigModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {
    @RequestMapping("/")
    List hello() {
        ShopConfigModel shopConfigModel = new ShopConfigModel();
        return shopConfigModel.getGetShopType();
    }
}
