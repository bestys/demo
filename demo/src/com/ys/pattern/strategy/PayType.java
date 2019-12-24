package com.ys.pattern.strategy;

public enum PayType {
    ALI_PAY(new AliPay()),WECHAT_PAY(new WechatPay());
    private Pay pay;

    PayType(Pay pay) {
        this.pay = pay;
    }
    public Pay getPay(){
        return pay;
    }
}
