package bst;

public class BST {
	//acceder o guardar valores, contains, recorrerlos y darlos de un orden u otra,...
	//multiples aplicaciones
	
	Nodo raiz;
	
	/**public static void main(String[] args) {
		*BST bst = new BST();
		*bst.raiz = new Nodo(7);
		*bst.raiz.izquierda.derecha; //cuandoo accedo a la ziquierda, accedo a otro nodo. tiene esto sentido? no
		* //necesitamos una forma repetitiva genérica que nos permita localizar lo que queramos.
	*/
	
	//guardar. void porque no retorna nada. almaceno valores
	public void guardar(int valor) {
		/**if(raiz.valor == valor) { //al principio raiz no ha inicializado, todavía no tiene valor (null)
		*	
		}*/
		
		if(raiz == null) { //compruebo que es null
			raiz = new Nodo(valor); //inicializo raiz
			return; 
			}
		
		//una especie de puntero que me indique donde estoy. mi puntero apunta a un nodo
		
		Nodo actual = raiz;
		
		while(actual != null) { /**sigo haciendo esto hasta que ?? */
			
		//de alguna forma comparo los nodos		
			if(valor == actual.valor) {
				return; //nada que hacer, he terminado
			} else if (valor < actual.valor) {
				//sé que está a la izquierda si se cumple
				if(actual.izquierda == null) { //( si lo es es la posición donde va a ir el número)
				actual.izquierda = new Nodo(valor); //creo nodo en esa posición (que es la izquierda del nodo anterior)
				return;
				}
				actual = actual.izquierda;
			} else {
				//está a la derecha
				if (actual.derecha == null) { //lugar donde va
					actual.derecha = new Nodo(valor);
					return;
				}
				actual = actual.derecha; //ahora me encontraré en el nodo a la derecha del anterior
			}
			
			//ahora pongo todo dentro de un while, para no hacer esto solo con el primer nodo
		}
	}
	
	//contains
	
	public boolean contains(int valor) {
		if(raiz == null) {
			return false;
		}
		Nodo actual = raiz;
		
		while(actual !=null) {
			if(valor == actual.valor) {
				return true;
			}else if (valor < actual.valor) {
				//sé que está a la izquierda si se cumple
				if(actual.izquierda == null) { //( si lo es es la posición donde esta el número)
				return false;
				}
				actual = actual.izquierda;
			} else {
				//está a la derecha
				if (actual.derecha == null) { //lugar donde esta
					return false;
				}
				actual = actual.derecha; //ahora me encontraré en el nodo a la derecha del anterior
			}
			
			//ahora pongo todo dentro de un while, para no hacer esto solo con el primer nodo
			//java no sabe que es lo que hay dnntro del if, entonces es como si no devuelves nada
			//pone
		}
		return false;
	}
		
	
	
	//main
}


