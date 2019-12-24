package com.ys.pattern.strategy;

public class AliPay implements Pay {
    @Override
    public PayState pay() {
        System.out.println("欢迎使用支付宝！");
        System.out.println("开始扣款！");
        return new PayState("200","支付成功！");
    }
}
