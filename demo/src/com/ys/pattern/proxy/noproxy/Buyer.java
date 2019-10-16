package com.ys.pattern.proxy.noproxy;

public class Buyer {
    private String name;

    public Buyer(String name) {
        this.name = name;
    }

    public String buyHouse(House house) {
        System.out.println("我叫：" + name + ",我买了一套房子：" +  house);
        return null;
    }
}
