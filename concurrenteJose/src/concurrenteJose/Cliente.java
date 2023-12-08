package concurrenteJose;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class Cliente{

	public static void main(String[] args) {
		
		try {
			Socket socket = new Socket("localHost", 5001);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			
			while (true) {
				String inputLine = in.readLine();
				System.out.println(inputLine);
				inputLine = in.readLine();
				System.out.println(inputLine);
				System.out.println(inputLine);
				System.out.println();
				Scanner scanner = new Scanner(System.in);
				
				while(true) {
					String response = scanner.nextLine();
					out.println(response);
				}
				
			}
		
		
		
		
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
