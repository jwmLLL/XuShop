package com.sxx.demo.model.shop;

import java.util.ArrayList;

public class ShopConfigModel {

    private ArrayList<ShopType> getShopType;

    public ArrayList<ShopType> getGetShopType() {
        if(getShopType==null){
            getShopType = new ArrayList<>();
        }
        getShopType.add(new ShopType("1","水产店"));
//        getShopType.add(new ShopType("2","餐饮"));
//        getShopType.add(new ShopType("3","便利点"));
//        getShopType.add(new ShopType("4","杂货店"));
        return getShopType;
    }

    public void setGetShopType(ArrayList<ShopType> getShopType) {
        this.getShopType = getShopType;
    }

    class ShopType {
        public String id;
        public String name;

        public ShopType(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
