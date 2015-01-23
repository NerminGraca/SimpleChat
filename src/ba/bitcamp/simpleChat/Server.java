package ba.bitcamp.simpleChat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static final int port = 1728;
	
	public static void startServer() {
		try {
			ServerSocket server = new ServerSocket(port);
			while(true){
				System.out.println("Waiting");
				Socket client = server.accept();
				
				OutputStream os = client.getOutputStream();
				InputStream is = client.getInputStream();
				
				SocketRW sc = new SocketRW(is, os);
				while (true) {
					sc.sendMessage(os);
					sc.receiveMessage(is);
				}
				
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		startServer();
	}

}
