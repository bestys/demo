package com.ys.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

/**
 * created by yuans on 2019/12/13
 **/
public class ServerSocketChannelDemo {

    public static class TCPEchoServer implements Runnable{
        private InetSocketAddress localAddress;

        public TCPEchoServer(InetSocketAddress localAddress) {
            this.localAddress = localAddress;
        }

        @Override
        public void run() {
            Charset utf8 = Charset.forName("UTF-8");
            ServerSocketChannel ssc = null;
            Selector selector = null;
            Random random = new Random();
            try{
                // 创建选择器
                selector = Selector.open();
                // 创建服务器通道
                ssc = ServerSocketChannel.open();
                ssc.configureBlocking(false);
                // backlog为最大连接数
                ssc.bind(localAddress,100);
                ssc.register(selector, SelectionKey.OP_ACCEPT);
            }catch (IOException e){
                e.printStackTrace();
            }
            try {
                while(!Thread.currentThread().isInterrupted()){
                    int n = selector.select();
                    if(n==0){
                        continue;
                    }
                    Set<SelectionKey> keys = selector.selectedKeys();
                    Iterator<SelectionKey> it = keys.iterator();
                    SelectionKey key = null;
                    while (it.hasNext()){
                        key = it.next();
                        it.remove();
                        if(key.isAcceptable()){
                            SocketChannel sc = ssc.accept();
                            sc.configureBlocking(false);
                            sc.register(selector,SelectionKey.OP_READ);
                        }
                        if(key.isReadable()){
                            SocketChannel channel = (SocketChannel)key.channel();
                            ByteBuffer receivebuffer = ByteBuffer.allocate(4096);
                            channel.read(receivebuffer);
                            receivebuffer.flip();
                            CharBuffer charBuffer = utf8.decode(receivebuffer);
                            System.out.println(charBuffer.toString());
                            key.interestOps(key.interestOps()|SelectionKey.OP_WRITE);
//                            ssc.register(selector,SelectionKey.OP_WRITE);
                        }
                        if(key.isWritable()){
                            SocketChannel channel = (SocketChannel)key.channel();
                            String sendText="message from server--";
                            ByteBuffer buffer = ByteBuffer.allocate(4096);
                            //向缓冲区中输入数据
                            buffer.put(sendText.getBytes());
                            channel.write(buffer);
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
