package com.ys.pattern.delegate;

public class TargetB implements Target {
    @Override
    public void doing(String commend) {
        System.out.println("我是B,我正在" + commend);
    }
}
