package com.ys.pattern.proxy.cglibproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class HuangNiuProxy implements MethodInterceptor {

    public Object newProxyInstance(Class<?> clazz,Object[] objs){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(new HuangNiuProxy());
        return enhancer.create(new Class[]{String.class},objs);
    }

    @Override
    public Object intercept(Object sub, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("黄牛排队等待买票！");
        methodProxy.invokeSuper(sub,objects);
        System.out.println("黄牛邮寄行李！");
        return null;
    }
}
