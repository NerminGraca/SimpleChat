package ba.bitcamp.simpleChat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class SocketRW {
	
	InputStream ClientIn;
	OutputStream ClientOut;
	
	public SocketRW(InputStream ClientIn, OutputStream ClientOut) {
		this.ClientIn = ClientIn;
		this.ClientOut = ClientOut;
	}
	
	public void sendMessage(OutputStream clientOut) throws IOException {
		
		String message = TextIO.getln();
		if (message.equals("quit")) {
			System.out.println("Chat Ended");
			clientOut.close();
			
		}
		byte[] messageBytes = message.getBytes();
		clientOut.write(messageBytes.length);
		clientOut.write(messageBytes);
	}
	
	public void  receiveMessage(InputStream clientIn) {
		
		String bufferedString = "";
		try {
			
			int messageLength = clientIn.read();
			byte[] buffer = new byte[messageLength];
			int byteRead = 0;
			StringBuilder sb = new StringBuilder();
			while ((byteRead += clientIn.read(buffer)) >= 0) {
				sb.append(new String(buffer).replaceAll("\\s+$", ""));
				if (byteRead >= messageLength) {
					break;
				}
			}
			bufferedString = sb.toString();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(bufferedString);
		
	}

}
