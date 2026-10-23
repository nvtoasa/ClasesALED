package executors;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class CalculadoraExecutor {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		//TareaExecutor t = new TareaExecutor(4,7); dividimos en dos tareas (antes era solo esta)
		TareaExecutor t1 = new TareaExecutor(4,5);
		TareaExecutor t2 = new TareaExecutor(5,7);
		
		ExecutorService executor = Executors.newFixedThreadPool(3); //executorservice es una interfaz. esta funcion nos ahorra todo
		//el proceso de arrancar las hebras, en este caso 3 (lo de start y eso), aunque en este caso no son necesarias pues solo toma una tarea.
		
		//Future<Integer> futuro = executor.submit(t); //t es la tarea que quiero que se ejecute. futuro, lo que cuando haga la tarea, me devolverá. esto contendrá mi resultado
		
		//ahora dos tareas
		
		Future<Integer> futuro1 = executor.submit(t1);
		Future<Integer> futuro2 = executor.submit(t2);
		Integer res1 = futuro1.get();
		Integer res2 = futuro2.get();
		
		//Integer res = futuro.get(); // Espera a que acabe la tarea (solo hay una). Es parecido a un join, solo que además también te devuelve el resultado de la tarea.
		//System.out.println(res); cuando había una sola tarea
		
		System.out.println(res1 + res2);
		
		
		//si lo dejo así, no ha terminado la tarea. porque ExecutorService espera a recibir más atareas. tengo que indicar que 
		//no hay más tareas
		
		executor.shutdown();
		
		//si ahora mandara otra tarea, ya no la ejecutaría.
	}

}

//InterruptedException ocurre en la hebra, ExecutioException en la tarea