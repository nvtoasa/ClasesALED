package executors;

public class Calculadora {
	
	public static void main(String [] args) {
		// Thread a = new HebraCalculo();
		HebraCalculo a = new HebraCalculo();
		a.start();
		
		System.out.println(a.getRes()); //no funciona porque no hay getRes para clase Thread (linea 6)
	}

}
