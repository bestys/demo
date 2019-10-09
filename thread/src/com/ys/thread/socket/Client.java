package com.ys.thread.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("192.168.90.15",8080);
//		socket.bind(new InetSocketAddress());
		OutputStream outputStream = socket.getOutputStream();
		outputStream.write("我来了".getBytes());
		outputStream.flush();
		socket.shutdownOutput();
		InputStream inputStream = socket.getInputStream();
		byte[] arr = new byte[1024];
		int len = 0;
		while((len = inputStream.read(arr))!=-1) {
			System.out.println(new String(arr));
		}
//		DataInputStream dataInputStream = new DataInputStream(inputStream);
//		int len = dataInputStream.readInt();
//		byte[] arr = new byte[len];
//		dataInputStream.read(arr);
//		System.out.println(new String(arr));
//		dataInputStream.close();
		inputStream.close();
		outputStream.close();
		socket.close();
	}
}
