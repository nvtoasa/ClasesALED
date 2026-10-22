package condicion.carrera;

public class Contador {
	
	private int valor = 0; //contador comienza en cero, private para proteger lo que guardamos dentor del contador
	// para que nadie pueda alterar su valor. ahora ¿como lo incremento? 
	
	public synchronized void incrementar() { //cerrojo sobre TODO el método incrementar - >synchronized. Ya funciona!
		valor++; //región crítica -> aplicar exclusión mutua. tenemos que excluir mutuamente una hebra de la otra de mi acceso a esta
		//región crítica. no puede entrar a valor ++ hasta que la otra hebra no haya terminado. ¿como consigo que espere?
		// vamos a ver los cerrojos. cuaderno
	}

	public int getValor() {
		return this.valor;
	}
}

//creo hebras que intentan acceder a su valor -> incrementador
