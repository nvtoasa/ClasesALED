package deadlock;

public class Banco {

	public void transferir(Cuenta origen, Cuenta destino, int cantidad) {
		
		//Tratando de solucionar deadlock que produce synchronized (destino)
		Cuenta primera;
		Cuenta segunda;
		
		//Establecemos un orden, un consenso. primero va una transferencia, luego otra
		if (origen.id < destino.id) {
			primera = origen;
			segunda = destino;
		} else {
			primera = destino;
			segunda = origen;
		}
		
		synchronized(primera) {
			synchronized(segunda){ //soluciona el problema de que H1 y H2 se esperen entre sí, porque si tienen el mismo destino (misma referencia)				
		}
		//ahora en segundo (synchronized(segundo)) no hay nadie luchando por el cerrojo, solo uno, (segun el orden que hemos establecido), asi que
		//se soluciona el deadlock.
		//al entrar en synchronized (primera) hay una lucha de tranferencias entre H1 y H2, luego al luchar por el segundo no hay lucha, solo va el 
		// el que consiguió el de primero. en este caso hemos establecido que el primero va a ser el de H1 porque su origen.id (cuenta A) es más pequeño
		//que su destino (empresa), coge valor de primera.
		//en H1->H4: primera = origen (Cuenta A). segunda = destino (empresa)
		//en H4->H1: primera = destino (Cuenta A). seguunda  origen (empresa).
		
		if (origen.saldo >= cantidad) {
			origen.saldo -= cantidad;
			destino.saldo += cantidad;
		}
		else {
			System.out.println("Saldo insuficiente en la cuenta. Operación cancelada");
		}
		}
	}
}

//condición de carrera explicado en cuaderno y la razón del cerrojo
