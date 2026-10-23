package executors;

public class CalculoSecuencial {
	/** 
	 * Calcula la suma de los cuadrados de los numeros entre un intervalo.
	 * Por ejemplo, para eintervalo [4,7] el resultado sería: 
	 * 4*4 + 5*5 + 6*6 = 77
	 * @param lo rango inferior del calculo (incluido)
	 * @param hi rango superior del calculo (no inlcuido)
	 * @return resultado de calcular de la suma de cuadrados del intervalo
	 */
	
	public static int calculo(int lo, int hi) {
		int res = 0;
		for (int i = lo; i < hi; i++) {
			res += i*i;
		}
		return res;
	}
	
	public static void main(String [] args) {
		System.out.println(calculo(4,7));
	}
}
