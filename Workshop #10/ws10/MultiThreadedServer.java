package jac444.ws10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;

public class MultiThreadedServer {
	static ArrayList<Server> serverList = new ArrayList<>();
	static int count = 0;
	static final int PORT = 8000;

	public static void main(String[] args) {
		try (ServerSocket serverSocket = new ServerSocket(PORT)) {
			long millis = System.currentTimeMillis();
			Date date = new Date(millis);
			System.out.println("MultiThreadedServer Started at " + date + "\n");

			while (true) {
				Socket socket = serverSocket.accept();
				System.out.println("Connection from " + socket + "\n");

				 BufferedReader inputFromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				 PrintWriter utputToClient = new PrintWriter(socket.getOutputStream(), true);

				Server server = new Server(socket, " ", inputFromClient, utputToClient);
				serverList.add(server);
				System.out.println(serverList.size() + " servers in the array");
				server.start();
				server.setName(Integer.toString(count));
				count++;
			}

		} catch (IOException ex) {
			System.out.println("Server Exception: " + ex.getMessage());
		}
	}
}
