package com.ys.pattern.proxy.cglibproxy;

import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test {
    public static void main(String[] args) {
        AirPassenger proxy = (AirPassenger)new HuangNiuProxy().newProxyInstance(AirPassenger.class,new Object[]{"张三"});
        proxy.buyTicket();

        System.out.println(proxy.getClass());

    }
}
