package com.learning.spring.singletondemo.controller;

import java.util.ArrayList;
import java.util.List;

public class NumberCollector {

    private  List<String> list = new ArrayList<>();

    public void add(String value) {
        list.add(value);
    }

    public List<String> getList() {
        return list;
    }
}
