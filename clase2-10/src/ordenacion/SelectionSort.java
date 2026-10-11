package ordenacion;

//Esto es un linear search
/** Pasos:
 * 1. Buscar la carta más pequeña.
 * 2. Cambiamos por la que encontramos
 * 3. Repetimos
 */

public class SelectionSort {
	public static int[] ordenar(int[] arr) {
		for (int pos = 0; pos < arr.length;pos++) {
			int posMin = pos;
			
			for (int i = pos + 1; i < arr.length; i++) { /**O(n^2) en el caso peor.
			*en el caso mejor (todos ordenados) es igual, porque hago los mismo pasos
			*aunque ya esté ordenados, los cambio por el mismo, queda igual. no hay break, 
			*no hay return, mi algortimo hace las misma iteraciones por lo tanto es la 
			*misma complejidad O(n^2) desde pos +1 porque ya lo había ordenado en el 
			*anterior for. repito sobre las ordenadas, cuando yo quiero repetir sobre 
			*las que faltan por ordenar.
			*/
			
				if(arr[i] < arr[posMin]) { /**estoy buscando la menor, entra si he 
				*encontrado una carta que es menor que arr[posMin], mi anterior mínimo
				*/
					posMin = i;
					
				}
			}
			/** Quiero hacer un swap. Necesito una variable auxiliar para guardar la posición
			 *  Cambio el de pos por el de posMin
			 */
			int tmp = arr[pos];
			arr[pos] = arr[posMin];
			arr[posMin] = tmp;
		}
		
		return arr;
	}
	
	public static void main(String[] args) {
		System.out.println(ordenar(new int[] {6,2,4,9,-10}));
	}

}
