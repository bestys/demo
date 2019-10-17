package com.ys.pattern.proxy.staticproxy;

public class Passenger {
    private String name;
    public void buyTicket(){
        System.out.println(name + "买票成功！");
    }
    public Passenger(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        // 当张三来买票时，需要以下步骤
        new HuangNiuProxy(new Passenger("张三")).buyTicket();
        // 当李四来买票时，需要以下步骤
        new HuangNiuProxy(new Passenger("李四")).buyTicket();
    }
}
