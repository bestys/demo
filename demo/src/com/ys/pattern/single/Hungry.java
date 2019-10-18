package com.ys.pattern.single;

// 饿汉式
public class Hungry {
    private static final Hungry hungry = new Hungry();

    private Hungry(){

    }
    public static Hungry instance(){
        return hungry;
    }
}
