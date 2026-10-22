package condicion.carrera;

public class Contador {
	
	private int valor = 0; //contador comienza en cero, private para proteger lo que guardamos dentor del contador
	// para que nadie pueda alterar su valor. ahora ¿como lo incremento? 
	
	public void incrementar(Object cerrojo) { 
		//pero si no quiero que todo tenga cerrojo, si por ejemplo tengo al ppio un calculo costoso que no quiero 
		//con cerrojo
		
		//Cálculo costoso
		
		synchronized(cerrojo) { 
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

//EN ESTA VERSIÓN NO FUNCIONA, se crean dos cerrojos?
