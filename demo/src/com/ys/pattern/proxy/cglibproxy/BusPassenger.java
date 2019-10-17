package com.ys.pattern.proxy.cglibproxy;

public class BusPassenger{
    private String name;

    public BusPassenger(String name) {
        this.name = name;
    }

    public void buyTicket() {
        System.out.println(name + "买汽车票成功！");
    }
}
