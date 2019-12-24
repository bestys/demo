package com.ys.pattern.strategy;

public class PayState {
    private String code;
    private String msg;

    public PayState(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "状态码：" + code +
                ",交易信息：" + msg ;
    }
}
