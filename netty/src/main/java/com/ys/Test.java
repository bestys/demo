package com.ys;

import com.ys.Client;
import com.ys.Server;

import java.util.Random;

/**
 * created by yuans on 2019/12/12
 **/
public class Test {

    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            try{
                Server.start();
            }catch (Exception e){
                e.printStackTrace();
            }
        }).start();
        Thread.sleep(1000);
        char[] op = new char[]{'+','-','*','/'};
        Random random = new Random(System.currentTimeMillis());

        new Thread(()->{
            while (true){
                String expression = random.nextInt(10) + "" + op[random.nextInt(4)] + random.nextInt(10);
                Client.send(expression);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
