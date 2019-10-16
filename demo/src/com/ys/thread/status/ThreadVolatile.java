package com.ys.thread.status;

import java.util.concurrent.TimeUnit;

public class ThreadVolatile {
     private static volatile  ThreadVolatile instance = null;

    public static ThreadVolatile getInstance() {
        if(instance==null){
            instance = new ThreadVolatile();
        }
        return instance;
    }
    public static void main(String[] args) {
        ThreadVolatile.getInstance();
    }
}
