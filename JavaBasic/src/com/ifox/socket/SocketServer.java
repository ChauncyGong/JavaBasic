package com.ifox.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class SocketServer {
	
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("127.0.0.1", 7878);
			BufferedReader bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
