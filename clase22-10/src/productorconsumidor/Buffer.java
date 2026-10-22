package productorconsumidor;

public class Buffer {
	
	private int dato = -1; //lo que guarda mi buffer. UN SOLO dato. establecemos que -1 significa que no hay dato
	
	//2 condiciones: guardar cuando esté vacío, sacar cuando este lleno
	private boolean lleno = false; //al ppio mi buffer está vacío
	
	public boolean guardar(int dato) { //sin el if, se sobreescribe. synchronized para que dejar que cada hebra termine de guardar/sacar
		if(!lleno) {
			this.dato = dato;
			this.lleno = true;
			System.out.println("Guardado valor: " + dato);
			return true; //ha conseguido guardar
		}
		return false; //no consigue guardar
	}
	
	public synchronized int sacar() { // tengo que comprobar si hay algo guardado
		if(lleno) {
			this.lleno = false;
			System.out.println("Sacado valor: " + dato);
			return dato;
		}
		return -1; //devuelvo el valor 'no válido', pero no me interesan que aparezcan y se impriman -> tengo que volver a pedir
	}

}
