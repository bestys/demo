package com.ys.nio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * created by yuans on 2019/12/13
 **/
public class FileChannelDemo {

    public static void wirteFile(String path,String data){
        try {
            // 创建文件，向文件中写入数据
            File file = new File(path);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(file);
            FileChannel fc = fos.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(64);
            buffer.put(data.getBytes("UTF-8"));
            buffer.flip();

            fc.write(buffer);
            buffer.clear();

            buffer.put(" by yuans".getBytes("UTF-8"));
            buffer.flip();
            fc.write(buffer);

            fc.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static String readFile(String path){
        try {
            // 读取文件内容
            Path paths = Paths.get(path);
            FileChannel fc = FileChannel.open(paths);

            ByteBuffer byteBuffer = ByteBuffer.allocate((int) fc.size() + 1);
            fc.read(byteBuffer);
            byteBuffer.flip();

            Charset utf8 = Charset.forName("UTF-8");
            CharBuffer charBuffer = utf8.decode(byteBuffer);
            System.out.println(charBuffer.toString());

            byteBuffer.clear();
            fc.close();
            return charBuffer.toString();
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        FileChannelDemo.wirteFile("nio_file.data","Hello nio");
        FileChannelDemo.readFile("nio_file.data");
    }
}
