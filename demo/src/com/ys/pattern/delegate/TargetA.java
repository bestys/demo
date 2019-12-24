package com.ys.pattern.delegate;

public class TargetA implements Target {

    @Override
    public void doing(String commend) {
        System.out.println("我是A,我正在"+ commend);
    }
}
