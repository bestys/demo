package com.ys.pattern.strategy;

public class Order {
    private String id;
    private String amount;

    public Order(String id, String amount) {
        this.id = id;
        this.amount = amount;
    }
    public PayState pay(PayType type){
        return type.getPay().pay();
    }

    public static void main(String[] args) {
        System.out.println(new Order("1111","500").pay(PayType.ALI_PAY));
    }
}
