package condicion.carrera;

//esta clase es solo para la funcionalidad, el punto de entrada para mi idea. la idea se ejecuta desde aquí. 

public class EjemploCarrera {
	
	public static void main(String [] args) throws InterruptedException { //me da igual, lo añado por java, yo se que nadie las va a parar
		
		Contador c = new Contador(); //creo contador, empieza en cero porque así lo he establecido en la clase
		Thread i1 = new Incrementador(c); //recibe el contador que acabamos de creer, para siempre trabajar sobr eel mismo contador
		Thread i2 = new Incrementador(c);
		
		i1.start();
		i2.start();
		
		//System.out.println(c.getValor()); //que me digan el valor
		//cada hebra hace for 10000 veces lo mismo: llamar a incrementar y aumentar 1. -> nos devuelve 200000?
		//NO!!! porque, por lo mismo de antes, que el main acaba antes.
		
		//i1.join();
		//i2.join();
		
		/**sigue sin funcionar. cada vez que ejecuto sale algo diferente. las hebras no estan sumando todos lo sincrementos que se debn sumar
		* si voy al contador. veo que llama incrementar. este hace valor ++. 
		*Cuando hago valor++ hace algo como int tmp = valor; -> leyendo el valor
		* tmp = tmp + 1 -> calcula nuevo valor
		* valor = tmp; -> actualizando el valor
		*conceptualmente hace eso. 
		*
		*he arrancado primero i1, digamos que i1 llama a incrementar y hace lo que acabamos de ver. recupera el valor 0
		* pero i2 ya esta fncionando, tambien lee 0. por lo tanto i1, calcula nuevo valor 1, pero i2 TAMBIÉN. no siempre es i1 primero o 
		* i2 primero eso cambia. ahora actualizan el valor. el valor era 0, y se queda en 1. dos operaciones de dos hebras diferentes
		* ha terminaod en una sola actualuzacuón del valor.
		* 
		* valor++ no es atómica. no es una sola operacion, son como tres operaciones. entonces se pueden intercalar. esto se le llama
		* condición de carrera.
		*/
		
		
	}
}

//tres hebras, porque el main es una hebra también

