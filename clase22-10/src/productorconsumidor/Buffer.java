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
				wait(); //mando a mi hebra a parar, no es dormir. la paro hasta que yo le pide despertarla. el wait libera al cerrojo, eso significa que como P está parada, 
				//ahora C es la ÚNICA que puede coger el cerrojo, y entra a sacar. aquí pone lleno= flase, imprime y notify() ->
				//como solo hay otra hebra, java elige, pero no tiene mucho donde elegir, levanta a P. esto no significa que coge el cerrojo autmáticamente
				//no se lo asegura, sino que lucha por él. hasta que C no salga de sacar, no hay cerrojo. cuando termina sale de sacar
				//libera el cerrojo, y luchan por el cerrojo. Podemos tener otra vez que C lo consigue: lleno = false, entra al while y para. libera el cerrojo
				//por lo que P toma el cerrojo, comprueba lleno, sale de while, guarda dato, lleno = true notify -> 'despierta' a C y vuelven a luchar
				//por el cerrojo.
			} catch (InterruptedException e) {
				return;
			}
		} //cuando sale guarda lo que tiene que guardar
		
			this.dato = dato;
			this.lleno = true;
			System.out.println("Guardado valor: " + dato);
			notify(); //despierta a una hebra, pero no se cual (en este caso a la otra, porque solo hay 2, pero si hay más es otra cosa)

	}
	//Hebra consumidora -> C
	
	public synchronized int sacar() { // ahora quiero que saque solo si puede sacar -> si no está lleno toca dormir
		while(!lleno) {
			//Dormir/ parar
			try {
				wait(); //wait libera al cerrojo. 
			} catch(InterruptedException e) {
					return -1;
				}
			} //duerme hasta que pueda sacarlo
		
			this.lleno = false;
			System.out.println("Sacado valor: " + dato);
			notify(); //despertar a wait(). lo pongo en el otro método porque en P no está avanzando, está parado, solo C puede despertarla
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

//no funciona porque al guardar dato = 0, lleno = true, imprime guardado valor : 0. termina, libera el cerrojo (porque ha terminado guardar)
//C y P vuelven a intentar conseguir el cerrojo. lleno = true, dato = 0. si P vuelve a conseguir el cerrojo -> ahora lleno= true
//entra en el while y se va a dormir, pasan los 500 ms, vuelve a comprobar lleno, sigue estando lleno, no se cambia lleno, esto es por el
//synchronised, mi hebra C no puede entrar en sacar, y es lo único que puede liberarme -> mis hebras no pueden avanzar. INTERBLOQUEO