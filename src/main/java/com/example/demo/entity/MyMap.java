package com.example.demo.entity;

import java.util.HashMap;
import java.util.Map;

public class MyMap {
    private Map<String, Object> map;

    public MyMap() {
        map = new HashMap<>();
    }

    public void add(String string, Object object){
        map.put(string, object);
    }
}
