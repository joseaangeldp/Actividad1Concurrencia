package concurrenteJose;

import java.io.InvalidObjectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.io.BufferedReader;
import java.io.IOException;

public class Servidor implements Runnable {
	
	private Socket clientSocket;

	public Servidor(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}
	
	
	
	public static void main(String[] args) {
	
		try {
			
			ServerSocket serverSocket = new ServerSocket(5001);
			System.out.println("Servidor de chat iniciado");
			
			int i = 0;
			
			while(true) {
				Socket clientSocket2 = serverSocket.accept();
				System.out.println("Cliente conectado desde" + clientSocket2.getInetAddress());
				new Thread(new Servidor(clientSocket2), "cliente " + i++).start();
			}
			
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		

	}
	
	@Override
	public void run() {
		
		String inputLine;
		
		try {
			
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			out.println("bienvenido al servidor");
			out.println("Que quieres de comer  \n 1. Hamburguesas \n 2. Perro calientes \n 3. arroz chinos \n 4. tequenos \n 5. patacones");
			
			while ((inputLine = in.readLine()) != null) {
				//System.out.println("llego esto:" + inputLine);
				
				if(inputLine.equals("1")) {
					
					System.out.println("has seleccionado el numero " + inputLine +" Quieres Hamburguesas");
				}
				else if(inputLine.equals("2")){
					
					System.out.println("has seleccionado el numero " + inputLine +" Quieres Perro calientes");
				}
                else if(inputLine.equals("3")){
					
					System.out.println("has seleccionado el numero " + inputLine +" Quieres arroz chino");
				}
                else if(inputLine.equals("4")){
					
					System.out.println("has seleccionado el numero " + inputLine +" Quieres tequenos");
				}
                else if(inputLine.equals("5")){
					
					System.out.println("has seleccionado el numero " + inputLine +" Quieres patacones");
				}
			
				
				if(inputLine.equals("q")) {
					clientSocket.close();
					break;
				}
			}
			

			
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

}
