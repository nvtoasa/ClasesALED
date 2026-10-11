package examen1;

public class Float {
	
	public static void main(String[] args) {
		/**int acumulado = 0;
		*
		*float[] arr = {2.5f, 3.5f}; // si pones . lo considera double, no float, tienes que poner f
		*
		*for (int i = 0; i < arr.length; i++) {
		*	acumulado += arr[i]; /**
		*	*he establecido int acumulado, entonces para sumar, coge 2 en vez de 2.5, porque 2.5 no es int
		*
		*}
		*System.out.println(acumulado);
		*/
		
		float acumulado = 0;
		
		float[] arr = {2.5f, 3.5f}; // si pones . lo considera double, no float, tienes que poner f
		
		for (int i = 0; i < arr.length; i++) {
			acumulado += arr[i];		
		}
		System.out.println(acumulado);
	}
}
