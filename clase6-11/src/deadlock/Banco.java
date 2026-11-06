package deadlock;

public class Banco {

	public synchronized void transferir(Cuenta origen, Cuenta destino, int cantidad) {
		if (origen.saldo >= cantidad) {
			origen.saldo -= cantidad;
			destino.saldo += cantidad;
		}
		else {
			System.out.println("Saldo insuficiente en");
		}
	}
}

//condición de carrera explicado en cuaderno y la razón del cerrojo
