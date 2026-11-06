package deadlock;

public class Banco {

	public void transferir(Cuenta origen, Cuenta destino, int cantidad) {
		synchronized(origen) {
			synchronized(destino){
			//Cuenta A y cuenta B usan distintas referecnias -> distinto cerrojo -> condicion carrera.
			//Se soluciona el problema de que CuentaC -> F que no tiene que esperar. Pero vuelve a aparecer el problema de antes.
			//más explicado en cuaderno.
				
			//si meto un synchronized dentro de otro.. puede surgir un problema tipico. si a la vez que se hace H1 la empresa esta devlvindo a
			// la cuenta A (H4). Puede ocurrir que H1 cosigue el cerrojo de origen (cuentaA), H4 consigue el cerrojo de origen
		    // tambien (en H4 empresa es origen y H1 destino). ahora cada uno intenta coger el de destino. H1 intenta destino.
			// el destino es empresa, pero ya esta cogido, lo tiene H1. no puede, entonces espera a que se libere. H4 más de lo mismo, intenta
			//coger destino, que es CuentaA, y no puede. Las dos se quedan esperando, indefinidamente. no hay situacion que lo
			// resuelva. esto se conoce como deadlock. Las dos esperan un recurso que no llega.
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
}

//condición de carrera explicado en cuaderno y la razón del cerrojo
