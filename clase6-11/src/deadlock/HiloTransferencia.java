package deadlock;

public class HiloTransferencia extends Thread {

	Banco banco;
	Cuenta origen;
	Cuenta destino;
	int cantidad;
	
	public HiloTransferencia(Banco banco, Cuenta origen, Cuenta destino, int cantidad) {
		this.banco = banco;
		this.origen = origen;
		this.destino = destino;
		this.cantidad = cantidad;
	}
	
	@Override
	public void run() {
		banco.transferir(origen, destino, cantidad);
		System.out.println("Transferencia completada. Enviado " + cantidad + "€");
	}
	
}