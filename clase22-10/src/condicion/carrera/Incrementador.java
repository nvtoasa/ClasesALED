package condicion.carrera;

public class Incrementador extends Thread {
	
	Contador c; //atributo, lo puedo usar donde me de la gana
	
	Object cerrojo = new Object();
	
	public Incrementador(Contador c) { //recibe ese contador cuando se crea la hebra
		
		this.c = c;
	}
	
	@Override
	//10000 veces incremente el contador. quiero que las dos hebras accedan al mismo contador, no que cada una cree uno propio -> añado constructor
	public void run() {
		for (int i = 0; i < 10000; i++){
			c.incrementar(cerrojo);
		}
		
	}

}
