package jac444.ws10;

import java.io.BufferedReader;

import java.io.IOException;

import java.io.PrintWriter;
import java.net.Socket;

public class Server extends Thread {
	private Socket socket;
	private String tName;
	private BufferedReader inputFromClient;
	private PrintWriter outputToClient;

	public Server(Socket socket, String name, BufferedReader inputFromClient, PrintWriter outputToClient) {
		this.socket = socket;
		this.tName = name;
		this.inputFromClient = inputFromClient;
		this.outputToClient = outputToClient;
	}
	
	PrintWriter getOutPutToClient(){
		return this.outputToClient;
	}

	@Override
	public void run() {
		try {
			while (true) {
				//BufferedReader inputFromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				//PrintWriter outputToClient = new PrintWriter(socket.getOutputStream(), true); // true: flash the buffer
																								// automatically
				String receivedString = inputFromClient.readLine();
				// System.out.println(receivedString);
				if (this.tName.equals(" ")) {
					this.tName = receivedString;
					outputToClient.println(this.tName + ": ");
				}

				if (!this.tName.equals(receivedString)) {
					System.out.println(this.tName + ": " + receivedString);
					for (int i = 0; i < MultiThreadedServer.serverList.size(); i++) {
						if(i == Integer.parseInt(this.getName())) {
							MultiThreadedServer.serverList.get(i).outputToClient.println(this.tName + ": ");
						}
						else {
							MultiThreadedServer.serverList.get(i).outputToClient.println(this.tName + ": " + receivedString);
						}						
					}

				}

				if (receivedString.equals("exit")) {
					System.out.println(this.tName + " is done");
					break;
				}

			}
		} catch (IOException ex) {
		}

	}
}
