package executors;

//Hacemos lo de CalculoSecuencial con hebras

public class HebraCalculo extends Thread{

	private int lo;
	private int hi;
	private int res;
	
	@Override
	public void run() {
		res = CalculoSecuencial.calculo (lo,hi); //se puede llamar a la función porque está en el mismo paquete
		/**int res = 0;
		*for (int i = lo; i < hi; i++) {
		*	res += i*i;
		*}
		*return res;
		*/
	}
	
	public int getRes() {
		return res;
	}
	
}
