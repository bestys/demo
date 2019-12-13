package com.ys;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * created by yuans on 2019/12/12
 * BIO客户端
 **/
public class Client {
    private static int DEFAULT_PORT = 7777;

    private static String DEFAULT_IP = "127.0.0.1";

    public static void send(String expression){
        send(DEFAULT_PORT,expression);
    }
    public static void send(int port,String expression){
        System.out.println("算数处理表达式为：" + expression);
        Socket socket = null;
        BufferedReader in = null;
        PrintWriter out = null;
        try{
            socket = new Socket(DEFAULT_IP,port);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(),true);
            out.println(expression);
            String result = in.readLine();
            System.out.println("结果为：" + result);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(in!=null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(out!=null){
                out.close();
            }
        }
    }
}
