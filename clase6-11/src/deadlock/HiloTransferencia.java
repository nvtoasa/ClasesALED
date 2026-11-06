package deadlock;

public class HiloTransferencia extends Thread {
	Banco banco;
	Cuenta origen;
	Cuenta destino;
	int cantidad;
}
