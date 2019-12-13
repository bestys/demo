package com.ys;

import java.io.*;
import java.net.Socket;

/**
 * created by yuans on 2019/12/12
 **/
public class ServerHandler implements Runnable {

    private Socket socket;
    public ServerHandler(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        BufferedReader in = null;
        PrintWriter out = null;
        try{
           in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
           out = new PrintWriter(socket.getOutputStream(),true);
           String expression;
           String result;
           while (true){
               if((expression=in.readLine())==null){
                   break;
               }
               System.out.println("服务端收到信息：" + expression);
               result = Calculator.cal(expression);
               out.println(result);
           }
        }catch (IOException e){
            e.printStackTrace();
            System.out.println(e.getLocalizedMessage());
        }finally {
            if(in!=null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                in = null;
            }
            if(out!=null){
                out.close();
                out = null;
            }
        }
    }
}
