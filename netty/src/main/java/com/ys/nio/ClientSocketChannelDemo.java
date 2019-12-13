package com.ys.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

/**
 * created by yuans on 2019/12/13
 **/
public class ClientSocketChannelDemo {
    public static class TCPEchoClient implements Runnable{

        private String threadName;
        private Random rnm = new Random();

        private InetSocketAddress remoteAddress;

        public TCPEchoClient(String threadName, Random rnm, InetSocketAddress remoteAddress) {
            this.threadName = threadName;
            this.rnm = rnm;
            this.remoteAddress = remoteAddress;
        }

        @Override
        public void run() {
            Charset utf8 = Charset.forName("UTF-8");
            Selector selector;
            try{
                SocketChannel sc = SocketChannel.open();
                sc.configureBlocking(false);
                selector = Selector.open();
                int interestSet = SelectionKey.OP_READ | SelectionKey.OP_WRITE;
                sc.register(selector,interestSet);
                sc.connect(remoteAddress);
                while (!sc.finishConnect()){

                }
                while(!Thread.currentThread().isInterrupted()){
                    selector.select();
                    Set<SelectionKey> keys = selector.selectedKeys();
                    Iterator<SelectionKey> it = keys.iterator();
                    while(it.hasNext()){
                        SelectionKey key = it.next();
                        it.remove();
                        // 然后和服务端代码一致
                    }
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
