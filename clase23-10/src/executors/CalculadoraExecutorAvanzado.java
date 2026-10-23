package executors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class CalculadoraExecutorAvanzado {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		int start = 0;
		int end = 101;
		int tareaSize = 20;
		
		List<TareaExecutor> tareas = new ArrayList<>();
		
		for(int i = start; i <= end; i+=tareaSize) { //incremento según el tamaño que quiero que tenga cada tarea
			
			if(i+tareaSize <= end) {
				TareaExecutor t = new TareaExecutor(i, i + tareaSize); //va desde i hasta, en este caso, 20 valores despues
				tareas.add(t);
			} else {
				TareaExecutor t = new TareaExecutor(i,end);
				tareas.add(t);
			}
		}
		
		ExecutorService executor = Executors.newFixedThreadPool(3); 
		
		List<Future<Integer>> futuros = new ArrayList<>();
		
		for(TareaExecutor t: tareas) {
			futuros.add(executor.submit(t));
		}
		
		int res = 0;
		
		for( Future<Integer> f: futuros) {
			res += f.get();
		}
		
		System.out.println(res);

		executor.shutdown(); //para que pare ejecución
		
		//si ahora mandara otra tarea, ya no la ejecutaría.
	}

}

//InterruptedException ocurre en la hebra, ExecutioException en la tarea