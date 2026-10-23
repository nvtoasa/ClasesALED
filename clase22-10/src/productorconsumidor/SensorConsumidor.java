package productorconsumidor;

public class SensorConsumidor extends Thread{
	
	Buffer b; //atributo, para poder usarlo
	
	public SensorConsumidor(Buffer b) {
		this.b = b;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			b.sacar();
		}
	}

}