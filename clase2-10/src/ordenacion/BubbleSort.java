package ordenacion;

import java.util.Arrays;
//import java.util.Iterator;??

public class BubbleSort {
	
	public static int[] ordenar(int[] arr) {
		//Empujamos la carta hacia el final
		boolean changed = false;
		for(int pasada = 0; pasada < arr.length; pasada++) { 
			for (int i = 0; i < arr.length - 1- pasada; i++) { /**'- pasada' para reducir complejidad?
		*pero sigue siendo la misma para el caso peor y el mejor
		*por eso se añade lo de break bajo la condición de si no hay cambio (otro comentario).
		*establecemos boolean changed para ello.
		*/
				if(arr[i] > arr[i+1]) { /**
				*cojo la última posición, pero i+1 en el último término no existe en el array
				*por eso pongo arr.length -1 en el for (añadido después)
				*/
					int tmp = arr[i];
					arr[i] = arr [1+i];
					arr[i+1] = tmp;
					changed = true;
				}
			}
				/** if (si no hay cambio){
				 * break
				 * }
				 */
			if (!changed) {
				System.out.println("Pasada nº:" + (pasada+1));
				break;
			}
			System.out.println("Pasada nº:"+ (pasada + 1)); //si changed == false a la primera, hace break, se sale, y no imprime nada
		}
		
		return arr;
	}
	public static void main(String[] args) {
	System.out.println(Arrays.toString(ordenar(new int[] {6,2,4,9,-10})));
	}
}

/** ahora sí, en esta versión se ha conseguido O(n^2) en el peor caso pero
 * es O(n) en el mejor caso
 */
