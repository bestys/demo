package com.ys.pattern.proxy.noproxy;

public class Passenger {
    private String name;

    public Passenger(String name) {
        this.name = name;
    }

    public void waitTicket(){
        System.out.println(name + "排队等待买票！");
    }
    public void buyTicket(){
        System.out.println(name + "买票！");
    }
    public void luggage(){
        System.out.println(name + "邮寄行李！");
    }
    public static void main(String[] args) {
        // 当张三来买票时，需要以下步骤
        Passenger zhangs = new Passenger("张三");
        zhangs.waitTicket();
        zhangs.buyTicket();
        zhangs.luggage();
        // 当李四来买票时，需要以下步骤
        Passenger lisi = new Passenger("李四");
        lisi.waitTicket();
        lisi.buyTicket();
        lisi.luggage();
    }
}
