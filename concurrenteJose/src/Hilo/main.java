package Hilo;

public class main {

	public static void main(String[] args) {
		new Thread("Hilo 1").start();
		new Thread("Hilo 2").start();
		new Thread("Hilo 3").start();
		new Thread("Hilo 4").start();
		new Thread("Hilo 5").start();
		
		System.out.println("Termino el Main");
		
	}
	
	

}
