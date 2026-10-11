package equals;

public class Equals {

	public static void main(String[] args) {
		int a = 5;
		int b = 5;
		
		//System.out.println( 5 == 5); // se puede usar == cuando son primitivos
		//char / double / float /long...
		
		/**String s1 = new String("Hola");
		*String s2 = new String("Hola");
		*
		*System.out.println(s1.equals(s2));
		*/
		
		String s1 = "Hola";
		String s2 = "Hola";
		
		System.out.println(s1 == s2);
		
		//se crea una especie de pool de strings para ir reutilizando??
		
		/**Integer i1 = 1;
		*Integer i2 = 1;
		*/
		
		//se puede hacer también, pero desfasado: integer es tipo referencia, debería apuntar a dos objetos diferentes?
		//Crea dos referencias?
		Integer i1 = new Integer(1);
		Integer i2 = new Integer (1);
		
		System.out.println(i1 == i2); 
		
		//con 1 funciona! si creas integer de valor 1000 no! esto es porque lo han adaptado
		//para valores pequeños pero no valores más grandes
	}
	
}
