package ordenacion;

import java.util.Comparator;

public class ComparadorPorNota implements Comparator<Alumno> {
	@Override
	public int compare(Alumno o1, Alumno o2) {
		return Double.compare(o1.nota,o2.nota); /**
		*
		*diferente del compareTo. el compareTo
		* solo tenía un parámetro porque pertenecia
		* a una clase que se podia comparar con otra. 
		* pero esta clase es un comparador digamos genérico
		*/
	}

}

//buscar como solucionar