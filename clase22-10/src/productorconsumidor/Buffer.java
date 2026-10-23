package productorconsumidor;

public class Buffer {
	
	private int dato = -1; //lo que guarda mi buffer. UN SOLO dato. establecemos que -1 significa que no hay dato
	
	//2 condiciones: guardar cuando esté vacío, sacar cuando este lleno
	private boolean lleno = false; //al ppio mi buffer está vacío
	
	//Hebra productora -> P
	public synchronized void guardar(int dato) { //sin el if, se sobreescribe. synchronized para que dejar que cada hebra termine de guardar/sacar, una hebra no entra al método mientras haya otra dentra
		
		while(lleno) {
			//Dormir/parar. cuando sale de este if, es que le toca guardar
			try{
				Thread.sleep(500); 
			} catch (InterruptedException e) {
				return;
			}
		} //cuando sale guarda lo que tiene que guardar
		
			this.dato = dato;
			this.lleno = true;
			System.out.println("Guardado valor: " + dato);

	}
	//Hebra consumidora -> C
	
	public synchronized int sacar() { // ahora quiero que saque solo si puede sacar -> si no está lleno toca dormir
		while(!lleno) {
			//Dormir/ parar
			try {
				Thread.sleep(500);
			} catch(InterruptedException e) {
					return -1;
				}
			} //duerme hasta que pueda sacarlo
		
			this.lleno = false;
			System.out.println("Sacado valor: " + dato);
			return dato;
			
	}

}

//sin synchronized, imagina que entra P a guardar, cambia a true, entonces C puede entrar a sacar. Entonces se puede imprimir 
//primero Sacado valor, y luego Guardado valor porque llega antes al println. se me están interclaando los prints, pero
//no es una condición de carrera. Lo que pasa es que se imprime primero el número sacado, cuando lo primero que se hace es
//guardar el valor para después sacarlo

//para una condición de carrera. C y P cada uno intenta entrar en su método. C intenta entrar en sacar (con dato = 0 y lleno = true)
//puede entrar en el if, y pone lleno = false, intenta scaar el valor. Pero mientras tanto P intenta entrar en guardar. lleno false
//porque C lo ha actualizaod entonces puede entrar. al entrar pone dato = 1 y lleno = true. Pero ahora mi hebra consumidora tiene
//que hacer el print del dato -> imprime Valor sacado: 1. Parece que intenta sacar el valor 1, pero tendría que haber imprimido 1
//es como si hubiera desaparecido el 0 -> condición de carrera!