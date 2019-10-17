package com.ys.pattern.proxy.jdkproxy;

public class RailWayPassenger implements Passenger{
    private String name;

    public RailWayPassenger(String name) {
        this.name = name;
    }

    @Override
    public void buyTicket() {
        System.out.println(name + "买火车票成功！");
    }
}
