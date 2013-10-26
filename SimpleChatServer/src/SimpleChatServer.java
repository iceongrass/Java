//import java.awt.*;
import java.util.*;
import java.io.*;
import java.net.*;
//import java.awt.event.*;

public class SimpleChatServer {
	
	ArrayList clientOutputStreams;
	
	public static void main (String [] args) {
		SimpleChatServer server = new SimpleChatServer();
		server.go();
	} // end main()
	
	public void go() {
		clientOutputStreams = new ArrayList();
		
		try{
			ServerSocket serverSock = new ServerSocket(5000);
			
			while (true) {
				Socket clientSock = serverSock.accept();
				PrintWriter writer = new PrintWriter(clientSock.getOutputStream());
				clientOutputStreams.add(writer);
				
				Thread t = new Thread(new ClientHandler(clientSock));
				t.start();
				System.out.println("got a connection");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} // end try
	
	} // end go()
	
	public class ClientHandler implements Runnable {

		BufferedReader reader;
		Socket sock;
		
		public ClientHandler (Socket clientSocket) {
			try {
				sock = clientSocket;
				InputStreamReader isReader = new InputStreamReader (sock.getInputStream());
				reader = new BufferedReader(isReader);
			} catch (Exception ex) {
				ex.printStackTrace();
			} // end try
		} // end ClientHandler()
				
		@Override
		public void run() {
			String messages;
			
			try {
				while((messages = reader.readLine()) != null) {
					System.out.println("read " + messages);
					tellEveryone(messages);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			} // end try
			
		} // end run()
		
	} // end class ClientHandler
	
	
	public void tellEveryone(String message) {
		
		Iterator it = clientOutputStreams.iterator();
		while (it.hasNext()) {
			try {
				PrintWriter writer = (PrintWriter) it.next();
				writer.println(message);
				writer.flush();
			} catch (Exception ex) {
				ex.printStackTrace();
			} // end try
		} // end while
	} // end tellEveryone()
}
