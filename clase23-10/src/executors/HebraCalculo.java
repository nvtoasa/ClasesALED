package executors;

//Hacemos lo de CalculoSecuencial con hebras

public class HebraCalculo extends Thread{

	private int lo;
	private int hi;
	private int res;
	
	public HebraCalculo(int lo, int hi) {
		this.lo = lo;
		this.hi = hi;
	}
	
	@Override
	public void run() {
		//res = CalculoSecuencial.calculo (lo,hi); //se puede llamar a la función porque está en el mismo paquete
		res = 0;
		for (int i = lo; i < hi; i++) {
			res += i*i;
		}
		
	}
	
	public int getRes() {
		return res;
	}
	
}
