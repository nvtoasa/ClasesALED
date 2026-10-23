package executors;

public class Calculadora {
	
	public static void main(String [] args) throws InterruptedException {
		// Thread a = new HebraCalculo();
		HebraCalculo a = new HebraCalculo(4,5);
		HebraCalculo b = new HebraCalculo(5,7);
		//dos hebras para que cada una haga un trozo de la tarea. sino, no se gana mucho. lo uedo hacer porque mi calculo es conmutativo
		
		a.start();
		b.start();
		
		a.join();
		b.join();
		
		
		//System.out.println(a.getRes()); //no funciona porque no hay getRes para clase Thread (linea 6) -> uso HebraCalculo
		//mi hebra main continua, no da tiempo a calcular, main 'gana' y se imprime 0. hago join!
		System.out.println(a.getRes() + b.getRes());
		
	}

}
