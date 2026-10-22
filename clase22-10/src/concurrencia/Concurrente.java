package concurrencia;

//creamos hebras para tareaA y tareaB

public class Concurrente {

	public static void main(String[] args) throws InterruptedException{
		Runnable tareaA = new TareaA();
		Runnable tareaB = new TareaB();
		
		Thread a = new Thread(tareaA);
		Thread b = new Thread(tareaB);
		
		a.start();
		b.start();
		
		//a.interrupt();
		//b.interrupt();
		
		//System.out.println("Trabajo terminado"); pero aparece primero trabajo terminaod en la consola y no al final!! en cuaderno
		
		//Thread.sleep(10000); //llamo metodo de esa clase -> static, en vez de try y catch usamos throw. esto es muy cutre, solo estoy hacinedo que espere un tiempo.
		//quiero que sea justo cuando termina las hebras.
		//System.out.println("Trabajo terminado");
		
		a.join(); //espero a que a termine
		b.join(); //espero a que b termine
		System.out.println("Trabajo terminado");
	}
}

// no llamo run, creo start, creo la hebra y ya internamente llama a run