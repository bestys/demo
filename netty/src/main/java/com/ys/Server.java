package com.ys;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * created by yuans on 2019/12/12
 * BIO服务端
 **/
public class Server {
    // 默认端口号
    private static int DEFAULT_PORT = 7777;

    // 单例的ServerSocket
    private static ServerSocket serverSocket;

    //
    public static void start(){
        start(DEFAULT_PORT);
    }
    public synchronized static void start(int port){
        if(serverSocket!=null){
            return ;
        }
        try{
            serverSocket = new ServerSocket(port);
            System.out.println("服务端已启动，端口号：" + port);
            while (true){
                Socket socket = serverSocket.accept();
                new Thread(new ServerHandler(socket)).start();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(serverSocket!=null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                serverSocket = null;
                System.out.println("服务端已关闭");
            }
        }
    }
}
