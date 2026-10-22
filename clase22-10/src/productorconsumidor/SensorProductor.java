package productorconsumidor;

public class SensorProductor extends Thread {
	
	Buffer b; //atributo, para poder usarlo
	
	public SensorProductor(Buffer b) {
		this.b = b;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			boolean guardado = b.guardar(i);
			
			//si no se ha guardado, se intenta guardar 
			//while() 
			} //mira el github del profe, me falta esta parte
		}
	}

