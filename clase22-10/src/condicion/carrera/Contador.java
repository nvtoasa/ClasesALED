package condicion.carrera;

public class Contador {
	
	private int valor = 0; //contador comienza en cero, private para proteger lo que guardamos dentor del contador
	// para que nadie pueda alterar su valor. ahora ¿como lo incremento? 
	
	public void incrementar() { 
		//pero si no quiero que todo tenga cerrojo, si por ejemplo tengo al ppio un calculo costoso que no quiero 
		//con cerrojo
		
		//Cálculo costoso
		
		synchronized(this) { //mis hebras tienen que usar el mismo cerrojo (que es un OBJETO, una instancia) sino es como dos puertas, dos llaves
			// en main vemos que tengo un solo contador, y que las hebras usan el mismo contador, la misma instancia
			//pongo this para indicar este contador. peor si no se cumple que usamos el mismo contador?
			valor++; 
		}
		
		valor++; //región crítica -> aplicar exclusión mutua. tenemos que excluir mutuamente una hebra de la otra de mi acceso a esta
		//región crítica. no puede entrar a valor ++ hasta que la otra hebra no haya terminado. ¿como consigo que espere?
		// vamos a ver los cerrojos. cuaderno
	}

	public int getValor() {
		return this.valor;
	}
}

//creo hebras que intentan acceder a su valor -> incrementador
