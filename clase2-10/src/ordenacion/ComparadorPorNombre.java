package ordenacion;
import java.util.Comparator;

public class ComparadorPorNombre implements Comparator<Alumno> {
	@Override
	public int compare(Alumno o1, Alumno o2) {
		return o1.nombre.compareTo(o2.nombre); /**
		*
		*diferente del compareTo. el compareTo
		* solo tenía un parámetro porque pertenecia
		* a una clase que se podia comparar con otra. 
		* pero esta clase es un comparador digamos genérico
		*/
	}

}
