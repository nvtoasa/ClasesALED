//elaborado durante clase 5 y 6 (mirar repositorio profesor)

package ordenacion;

import java.util.Arrays;
import java.util.Comparator;

public class Alumno implements Comparable<Alumno>{
	String nombre;
	double nota;
	
	
	public Alumno(String nombre, double nota) {
		this.nombre = nombre;
		this.nota = nota;
	}
	
	@Override
	public String toString(){
		return this.nombre;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {//misma referencia
			return true;
		}
		
		if(!(obj instanceof Alumno)) { //no es tipo alumno
			return false;
		}
		
		//return this.nombre = obj.nombre && this.nota == obj.nota; java no entiendo que obj es un alumno si o si por los parámetros del metodo
		Alumno o =(Alumno) obj;
		// return this.nombre == o.nombre && this.nota == o.nota; tampoco porque los strings son un tipo de referencia
		return this.nombre.equals(o.nombre) && this.nota == o.nota;
	}
	
	public static Alumno[] ordenar(Alumno[] arr, Comparator<Alumno> comparador) { //se añadio el argumento en intento 2
		for (int pasada = 0; pasada < arr.length; pasada++) {
			boolean changed = false;
			for (int i = 0; i < arr.length - 1 - pasada; i++) {
				if(comparador.compare(arr[i],arr[i+1])> 0) { /**
					*cojo la última posición, pero i+1 en el último término no existe en el array
					*por eso pongo arr.length -1 en el for (añadido después)
					*/
						Alumno tmp = arr[i];
						arr[i] = arr [1+i];
						arr[i+1] = tmp;
						changed = true;
				}
			}
			if (!changed) {
				System.out.println("Pasada nº:"+(pasada+1));
				break;
			}
			//System.out.println("Pasada nº:" + (pasada +1)); por que lo quita?
		}
		return arr;
	}	
	@Override
	public int compareTo(Alumno o) {
		//return Double.compare(this.nota,  o.nota); lo cambiamos tras lo añadido de comparator en main con ->
		int c = Double.compare(this.nota,o.nota);
		if(c != 0) {
			return c;
		} else {
			return this.nombre.compareTo(o.nombre);
		}
		
		
	}
		
	public static void main(String[] args) {
		//String a = "Miguel";
		//String c = "Carlos";
		
		//System.out.println(a.compareTo(c));
		//System.out.println(Double.compare(11.0,11.0, 0));
		
		Alumno ana = new Alumno("Ana", 9.0);
		Alumno carlos = new Alumno("Carlos", 8.75);
		Alumno alejandro = new Alumno ("Alejandro", 7.5);
		
		Alumno [] alumnos = {carlos, ana, alejandro};
		
		//System.out.println(ordenar(alumnos)); MAL, porque imprime la dirección del array
		//System.out.println(Arrays.toString (alumnos); vamos a usar
		
		//Intento 4: es lo más simple?
		Comparator<Alumno> porNombre = new ComparadorPorNombre();
		Arrays.sort(alumnos, porNombre);
		//System.out.println(Arrays.toString(alumnos));
		
		//Intento 1
		//ComparadorPorNombre porNombre = new ComparadorPorNombre();
		//System.out.println(Arrays.toString(ordenar(alumnos,porNombre)));
		
		//ComparadorPorNota porNota = new ComparadorPorNota();
		//System.out.println(Arrays.toString(ordenar(alumnos,porNota)));
		
		
		//Intento 2. por que decide usar comparator??
		//Comparator<Alumno> porNombre = new ComparadorPorNombre(); //por que puede cambiar a comparator? recuerda que en ordenar has añadido argumento comparator (eso también por que?? en vez de poner como argumento un ComparadorPorNombre
		//System.out.println(Arrays.toString(ordenar(alumnos,porNombre)));
		
		//Comparator<Alumno> porNota = new ComparadorPorNota();
		//System.out.println(Arrays.toString(ordenar(alumnos,porNota)));		
		
		
		//Intento 3
		//Comparator<Alumno>  porNombre2 = (a,b) -> a.nombre.compareTo(b.nombre); //la funcionalidad de que cuando yo pase esto es lo de después de la flecha.
		//funcion lambda que hace lo mismo que el comparador de linea 82, pero mucho más simple. ahora porNombre2 actua como comparador
		//igual que PorNombre. sin usar una clase aparte.		
	}
}
	

