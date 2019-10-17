package com.ys.pattern.proxy.jdkproxy;

public class AirPassenger implements Passenger{
    private String name;

    public AirPassenger(String name) {
        this.name = name;
    }

    @Override
    public void buyTicket() {
        System.out.println(name + "买机票成功！");
    }
}
