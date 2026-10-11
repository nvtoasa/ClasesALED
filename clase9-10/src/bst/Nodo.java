package bst;

public class Nodo {

	int valor; //cada nodo guarda un valor
	//cómo paso de uno a otro? como hago que esteén conectados? dentro de un
	//nodo tengo que tener una referencia a otro nodo
	Nodo izquierda;
	Nodo derecha;
	
	//también necesito el constructor. si no lo defino me da un constructor predeterminado?
	public Nodo(int valor) {
		this.valor = valor;
	}
	
	
}
