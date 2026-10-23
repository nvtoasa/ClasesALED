package executors;

//vemos como hacer CalculoSecuencial con nueva interfaz: Callable

import java.util.concurrent.Callable;

public class TareaExecutor implements Callable<Integer>{
	
	private int lo;
	private int hi;
	
	public TareaExecutor(int lo, int hi) {
		this.lo = lo;
		this.hi = hi;
	}
	
	@Override
	public Integer call() throws Exception{
		int res = 0;
		for (int i = lo; i < hi; i++) {
			res += i*i;
		}
		return res;
	}

}
