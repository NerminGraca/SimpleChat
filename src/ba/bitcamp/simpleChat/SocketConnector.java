package ba.bitcamp.simpleChat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketConnector {
	
	public static final String serverAdress = "127.0.0.1";
	public static final int serverPort = 1728;
	
	private static void connectToServer() throws UnknownHostException, IOException {
		Socket client = new Socket(serverAdress, serverPort);
		OutputStream clientOut = client.getOutputStream();
		InputStream clientIn = client.getInputStream();
		
		SocketRW sc = new SocketRW(clientIn, clientOut);
		while (true) {
			System.out.print("Server: ");
			sc.receiveMessage(clientIn);
			sc.sendMessage(clientOut);
			
		}
		
		
	}
	
	public static void main(String[] args) {
		 try {
			connectToServer();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
