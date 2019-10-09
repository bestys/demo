package com.ys.thread.socket;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		ServerSocket server = null;
		Socket socket =  null;
		InputStream inputStream = null;
		OutputStream outputStream = null;
		try {
			server = new ServerSocket();
		server.bind(new InetSocketAddress("192.168.90.15",8080));
		socket = server.accept();
		inputStream = socket.getInputStream();
		outputStream = socket.getOutputStream();
		byte[] arr = new byte[1024];
		int len = 0;
		while((len = inputStream.read(arr))!=-1) {
			System.out.println(new String(arr));
		}
//		DataInputStream dataInputStream = new DataInputStream(inputStream);
//		int len = dataInputStream.readInt();
//		byte[] arr = new byte[len-1];
//		dataInputStream.read(arr);
		
//		dataInputStream.close();
		outputStream.write("我又来了".getBytes());
		outputStream.flush();
		} catch (Exception e) {
				e.printStackTrace();
		} finally {
			try {
				inputStream.close();
				outputStream.close();
				socket.close();
				server.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}
	}
}
