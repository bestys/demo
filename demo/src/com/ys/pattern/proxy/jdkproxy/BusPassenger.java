package com.ys.pattern.proxy.jdkproxy;

public class BusPassenger implements Passenger{
    private String name;

    public BusPassenger(String name) {
        this.name = name;
    }

    @Override
    public void buyTicket() {
        System.out.println(name + "买汽车票成功！");
    }
}
