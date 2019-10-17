package com.ys.pattern.proxy.cglibproxy;

public class RailWayPassenger{
    private String name;

    public RailWayPassenger(String name) {
        this.name = name;
    }

    public void buyTicket() {
        System.out.println(name + "买火车票成功！");
    }
}
