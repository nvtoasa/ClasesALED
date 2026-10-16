package equals;

import java.util.HashMap;
import java.util.Map;

public class EjemploHashMap {
	public static void main(String[] args) {
		Map<String, Double> notas = new HashMap<>();
		notas.put("Ana", 9.0);
		notas.put("Carlos", 9.0);
		notas.put("Lucía", 7.5);
		
		System.out.println(notas);
		
		//Actualizar
		notas.put("Ana", 9.5);
		System.out.println(notas);
		
		//Recuperar valores
		System.out.println("Nota de Ana: " + notas.get("Ana"));
		System.out.println(notas.get("Pedro"));
		
		// Comprobar si existen claves
		System.out.println(notas.containsKey("Pedro"));
		
		//Eliminar
		notas.remove("Lucía");
		System.out.println(notas);
		
		//Tamaño
		System.out.println(notas.size());
		
		for (String nombre : notas.keySet()) {
			System.out.println("Nombre: " + nombre + "; Nota: " + nota);
		}
	}

}
