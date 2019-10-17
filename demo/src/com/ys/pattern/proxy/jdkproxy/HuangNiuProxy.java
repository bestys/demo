package com.ys.pattern.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class HuangNiuProxy implements InvocationHandler {

    private Passenger passenger;

    public Object newProxyInstance (Passenger passenger){
        this.passenger = passenger;
        return Proxy.newProxyInstance(passenger.getClass().getClassLoader(), passenger.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("黄牛排队等待买票！");
        method.invoke(passenger,args);
        System.out.println("黄牛邮寄行李！");
        return null;
    }
}
