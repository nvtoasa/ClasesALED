package ordenacion;

import java.util.Arrays;

public class Merge {
	
	public static int[] merge(int[] arr1, int[] arr2) {
		int[] res = new int[arr1.length + arr2.length];
		
		int pos1 = 0;
		int pos2 = 0; //un puntero para cada array
		
		int posRes =  0; //puntero para el array resultante
		
		while(pos1 < arr1.length && pos2 < arr2.length) {
			if(arr1[pos1]<= arr2[pos2]){//en array 1 donde apunte pos1
				res[posRes] = arr1[pos1];
				pos1++;//como ya se ha añadido, seguimos
				posRes++;//no quiero volver a machacar el
				//mismo valor del res. si resulta que no es menor que el de arr2,
				//el que quiero meter a res es el de arr 2 -> usamos else
			}else {
				res[posRes] = arr2[pos2];
				pos2++;
				posRes++;
				/**funciona? se puede producir un error, si el arr1 (o al revés) siempre es más pequeño voy vaciando arr1 (o arr2)
				 * yo sigo dentro del while, intentara acceder a una posición que ya no existe en el array
				 * para evitar ese problema, nunca debo salir de los arrays. para eso modifico linea 13
				 * que antes era while(posRes < res.length). pero en algun momento pos1 < arr1.length && pos2 < arr2.length
				 * se deja de cumplir la condición cuando se termina de vaciar el array, si una lista en mas larga que otra
				 * me faltará comparar cuando se acabe el array más pequeño con valores del más grande. surge otro
				 * problema, falta uno por recorrer, ¿cual?
				 */
			}
		}
		
		/**solo falta uno por recorrer... ¿cual? conn esto se soluciona el problema. 
		*se mete en el while del que no se ha completado, porque solo se cumple ese while
		*/
		while (pos1 < arr1.length) {
			res[posRes]= arr1[pos1];
			pos1++;
			posRes++;
		}
		
		while (pos2 < arr2.length) {
			res[posRes]= arr2[pos2];
			pos2++;
			posRes++;
		}
		
		return res;
	}
	
	public static int[] dividirPrimeraMitad(int[] arr) {
		int[] res = new int[arr.length/2]; //solo puede contener la mitad de arr que se va a dividir	
		
		for(int i = 0; i < arr.length/2;i++) {
			res[i]=arr[i];
		}
		return res;
	}
	
	public static int[] dividirSegundaMitad(int[] arr) {
		int[] res = new int[arr.length - (arr.length/2)]; //solo puede contener la mitad de arr que se va a dividir
		//por si es impar se le resta la mitad asi se completa con la otra mitad???
		
		int posRes = 0; //porque no tengo claro de donde a donde va
		
		for(int i = arr.length/2; i < arr.length; i++) {
			res[posRes] = arr[i];
			posRes++;
		}
		return res;
	}
	
	public static int[] mergeSort(int[] arr) {
		if(arr.length <=1) { //compruebo si he terminado CASO BASE
			return arr;
		}
		
		//metodo que divide a la mitad? tengo que inventar un metodo, si no se divide a la mitad
		//nunca se cumple arr.length <= 1 -> dividirPrimeraMitad
		int [] izq = dividirPrimeraMitad(arr);
		int[] dch = dividirSegundaMitad(arr);
		izq = mergeSort(izq);
		dch = mergeSort(dch);
		
		//se convierte en lo que me viene por la derecha/izquierda ya ordenado, porque
		//hay recursividad, seguirá metiendose hasta que no se pueda dividir más
		//llamo al metodo de merge para que vaya mezcle primero los elementos de 1 lista, luego al volver
		//al de 2 términos, luego al de 4, ... hasta que haga merge sobre las dos primera mitades que se
		//hicieron. cuando se cumple arr.length <= 1 sale del método porque llega a un return.
		return merge(izq,dch);
		
		
	}

	public static void main(String[] args) {
		//System.out.println(Arrays.toString(merge(new int[] {1,3,6,8}, new int[] {2,4,5,7})));
		System.out.println(Arrays.toString(mergeSort(new int[] {5,2,4,3,6,1,9,7})));
	}
}
