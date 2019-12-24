package com.ys.pattern.strategy;

public class WechatPay implements Pay {
    @Override
    public PayState pay() {
        System.out.println("欢迎使用微信支付！");
        System.out.println("开始扣款！");
        return new PayState("200","支付成功！");
    }
}
