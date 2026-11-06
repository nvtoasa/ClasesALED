package deadlock;

public class Banco {

	public void transferir(Cuenta origen, Cuenta destino, int cantidad) { //synchronized es como un this...
		//uso una misma instancia de bancco para las hebras, y asi cuando las hebras intenten hacer la transferencia en banco.trnasferir, ambas hebras
		//intentan conseguir el MISMO cerrojo, no dos diferentes.
		//si solo tengo una instancia de banco y el cerrojo solo se hace sobre es this, todas mis operaciones de banco se paran
		//entonces si a la vez en mi banco llega una peticion de cuentaC a otro banco, no esta liberado, no se puede tranferir hasta que el
		//otro termine. el synchronized me genera otro probema...
		synchronized(origen) { //cambiamos el cerrojo
			//Cuenta A y cuenta B usan distintas referecnias -> distinto cerrojo -> condicion carrera.
			//Se soluciona el problema de que CuentaC -> F que no tiene que esperar. Pero vuelve a aparecer el problema de antes.
			//más explicado en cuaderno.
		}
		if (origen.saldo >= cantidad) {
			origen.saldo -= cantidad;
			destino.saldo += cantidad;
		}
		else {
			System.out.println("Saldo insuficiente en la cuenta. Operación cancelada");
		}
	}
}

//condición de carrera explicado en cuaderno y la razón del cerrojo
