package jac444.ws10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		try (Socket socket = new Socket("localhost", 8000)) {
			BufferedReader data = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter stringToPrint = new PrintWriter(socket.getOutputStream(), true);

			Scanner sc = new Scanner(System.in);
			String userInput;
			String responseString;
			System.out.print("Enter you name: ");
			userInput = sc.nextLine();
			stringToPrint.println(userInput);
			while (!userInput.equals("exit")) {
				// stringToPrint.println(userInput);
				responseString = data.readLine();
				System.out.print(responseString);
				userInput = sc.nextLine();
				stringToPrint.println(userInput);
			}
			// sc.close();
		} catch (IOException ex) {
			System.out.println("Client Side Error: " + ex.getMessage());
		}
	}
}
