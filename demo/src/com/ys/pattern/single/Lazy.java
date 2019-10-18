package com.ys.pattern.single;

public class Lazy {

    private static Lazy lazy;

    private Lazy(){}
    // 存在线程安全问题
    /*public static Lazy instance(){
        if(lazy==null){
            lazy = new Lazy();
        }
        return lazy;
    }*/
    // 方法加锁,解决线程安全问题
    public static synchronized Lazy instance() {
        if (lazy == null) {
            lazy = new Lazy();
        }
        return lazy;
    }
}
