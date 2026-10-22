package condicion.carrera;

public class Contador {
	
	private int valor = 0; //contador comienza en cero, private para proteger lo que guardamos dentor del contador
	// para que nadie pueda alterar su valor. ahora ¿como lo incremento? 
	
	public void incrementar() {
		valor++;
	}

	public int getValor() {
		return this.valor;
	}
}

//creo hebras que intentan acceder a su valor -> incrementador
