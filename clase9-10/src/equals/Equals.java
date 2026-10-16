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
		
		//System.out.println(s1 == s2);
		
		//se crea una especie de pool de strings para ir reutilizando??
		
		Integer i1 = 1000;
		Integer i2 = 1000;
		
		
		//se puede hacer también, pero desfasado: integer es tipo referencia, debería apuntar a dos objetos diferentes?
		//Crea dos referencias?
		/**Integer i1 = new Integer(1);
		*Integer i2 = new Integer (1);
		*
		System.out.println(i1 == i2); 
		*/
		//con 1 linea 34 funciona funciona! si creas integer de valor 1000 no! esto es porque lo han adaptado
		//para valores pequeños pero no valores más grandes
		
		//Alumno
		Alumno a1 = new Alumno("Ana", 9.0);
		Alumno a2 = new Alumno("Ana", 9.0);
		
		// Para comprobar que son iguales, en clase Alumno se sobreescribe equals.
		
		System.out.println(a3 == a1);
		
		Alumno a3 = a1;
		Alumno a4 = new Alumno("Ana", 8.99);
		
		System.out.println(a3 == a1);
		System.out.println(a3.equales(a1));
		System.out.println(a1.equals("Ana")); false //porque "Ana" es tipo str y no object
		System.out.println(a1.equals(null));
		
		//List -> ArrayList
		List<Alumno> alumnos = new ArrayList<>();
		alumnos.add(a1);
		System.out.println(alumnos.contains(a4));
		
		//Set -> HashSet
		Set <Alumno> alumnosSet = new HashSet<>();
		alumnoSet.add(a1);
		System.class.out.println(alumnosSet.contains(a2));
	}
	
}
