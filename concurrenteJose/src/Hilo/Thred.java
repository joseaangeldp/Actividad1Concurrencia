package Hilo;

public class Thred extends Thread{
	
	public Thred(String name) {
		super(name);
		
		
	}
	
	public void run() {
		for(int i = 0; i < 5; i++) {
			System.out.println("Indice: " + i + "Thread name: " + getName());
		}
	}


}
