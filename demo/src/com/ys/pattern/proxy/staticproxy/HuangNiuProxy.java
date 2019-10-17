package com.ys.pattern.proxy.staticproxy;
// 注意：黄牛代替了乘客去排队和邮寄行李，让乘客只关注与买票的业务
// 缺点：只能代理一种类型，比如这里是买票业务需要排队和邮寄行李，那如果我有其他业务也需要排队和邮寄操作则只能再也一个代理类（如买机票，买火车票，买汽车票）
public class HuangNiuProxy {
    private Passenger passenger;
    public HuangNiuProxy(Passenger passenger) {
        this.passenger = passenger;
    }
    public void buyTicket(){
        waitTicket("黄牛");
        passenger.buyTicket();
        luggage("黄牛");
    }
    public void waitTicket(String who){
        System.out.println(who + "排队等待买票！");
    }

    public void luggage(String who){
        System.out.println(who + "邮寄行李！");
    }
}
