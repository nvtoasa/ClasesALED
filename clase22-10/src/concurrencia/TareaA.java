package concurrencia;

public class TareaA extends Thread{
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("A: " + i);
			
			//while(!Thread.currentThread().isInterrupted()) //si no pongo esto, por mas que haya un interrupt nadie comprueba si ha sido interrumpido.
				//Sin embargo, no lo necesitamos en esta ocasión porque sleep si compureba esta excepción. si no tuviera sleep o otro metodo que compruebe ese flag, si lo
				//pondría
			
			try{
				Thread.sleep(1000);
			} catch (InterruptedException e) { //manejar error por si sleep es interrumpido, por lo tanto tiene que detectar una interrupción
				return;
			}
			
		}
	}

}

// sleep
