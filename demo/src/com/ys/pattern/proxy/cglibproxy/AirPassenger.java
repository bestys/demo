package com.ys.pattern.proxy.cglibproxy;

public class AirPassenger{
    private String name;

    public AirPassenger(String name) {
        this.name = name;
    }

    public void buyTicket() {
        System.out.println(name + "买机票成功！");
    }
}
