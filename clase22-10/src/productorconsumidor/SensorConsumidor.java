package productorconsumidor;

public class SensorConsumidor extends Thread{
	
	Buffer b; //atributo, para poder usarlo
	
	public SensorConsumidor(Buffer b) {
		this.b = b;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			int valor = b.sacar();
			
			while (valor == -1) { //lo que dijimos en buffer de que hay que volver a pedir en vez de imprimir
				valor = b.sacar();
			}
			
		}
	}

}