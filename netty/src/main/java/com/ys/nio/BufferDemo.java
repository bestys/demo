package com.ys.nio;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * created by yuans on 2019/12/13
 **/
public class BufferDemo {

    public static byte[] encode(String str){
        CharBuffer charBuffer = CharBuffer.allocate(128);
        charBuffer.append(str);
        charBuffer.flip();
        // 获取UTF-8的编码解析器
        Charset utf8 = Charset.forName("UTF-8");
        // 对charBuffer中的内容解码
        ByteBuffer byteBuffer = utf8.encode(charBuffer);
        // array()返回的就是内部的数组引用
        byte[] bytes = Arrays.copyOf(byteBuffer.array(), byteBuffer.limit());
        System.out.println(Arrays.toString(bytes));
        return bytes;
    }
    public static void decode(byte[] bytes) throws UnsupportedEncodingException {
        ByteBuffer byteBuffer = ByteBuffer.allocate(128);
        byteBuffer.put(bytes);
        byteBuffer.flip();

        // 获取utf8编码的解析器
        Charset utf8 = Charset.forName("UTF-8");
        CharBuffer charBuffer = utf8.decode(byteBuffer);
        char[] chars = Arrays.copyOf(charBuffer.array(), charBuffer.limit());
        System.out.println(chars);
    }

    public static void main(String[] args) {
        try {
            BufferDemo.decode(BufferDemo.encode("袁帅"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
