package com.ys.pattern.single;

public class Lazy {

    private static Lazy lazy;

    private boolean isInit = false;

    private Lazy(){
        // 防止反射入侵
        synchronized (this){
            if(!isInit){
                isInit = true;
            }else{
                throw new RuntimeException("单例已被反射入侵！");
            }
        }
    }
    // 1.存在线程安全问题
    /*public static Lazy instance(){
        if(lazy==null){
            lazy = new Lazy();
        }
        return lazy;
    }*/
    // 2.方法加锁,解决线程安全问题，但是存在性能问题
    /*public static synchronized Lazy instance() {
        if (lazy == null) {
            lazy = new Lazy();
        }
        return lazy;
    }*/
    // 3.双重检查锁（DCL）,会引发线程安全问题（因为new指令会转换为多条jvm指令，可能存在指令重排序）
    // 解决办法：将lazy使用volatile关键字修饰，静止指令重排序
    /*public static Lazy instance(){
        if(lazy==null){
            synchronized (Lazy.class){
                if(lazy==null){
                    lazy = new Lazy();
                }
            }
        }
        return lazy;
    }*/
    // 4.内部类实现(内部类的初始化必须在调用方法之前，所以不存在线程安全问题)
    // final 确保此方法不能被覆盖
    public final static Lazy instance(){
        return Inner.lazy;
    }
    private static class Inner{
        private static final Lazy lazy= new Lazy();
    }

}
