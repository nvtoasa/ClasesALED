package deadlock;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Banco banco = new Banco();
		Cuenta cuentaA = new Cuenta(1, 100);
		Cuenta empresa = new Cuenta(2, 500);		
		Cuenta cuentaB = new Cuenta(3, 150);
		
		Thread h1 = new HiloTransferencia(banco, cuentaA, empresa, 50);
		h1.start();
		Thread h2 = new HiloTransferencia(banco, cuentaB, empresa, 30);
		h2.start();
		
		h1.join();
		h2.join();
		
		System.out.println("Saldo de la empresa: " + empresa.saldo + "€");
	}
	
}