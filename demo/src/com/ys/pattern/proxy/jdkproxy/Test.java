package com.ys.pattern.proxy.jdkproxy;

import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test {
    public static void main(String[] args) {
        Passenger proxy = (Passenger)new HuangNiuProxy().newProxyInstance(new AirPassenger("张三"));
        proxy.buyTicket();

        System.out.println(proxy.getClass());
        // 解析生成的$Proxy0
        // 过程：1.拿到被代理对象的引用，然后获取它的接口
        // 2.JDK重新生成一个实现了上述接口的类
        // 3.生成字节码
        // 4.编译加载

        // 获取字节码内容
        byte[] data = ProxyGenerator.generateProxyClass("$Proxy0",new Class[]{proxy.getClass()});
        try {
            FileOutputStream os = new FileOutputStream("D:/$Proxy0.class");
            os.write(data);
            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
