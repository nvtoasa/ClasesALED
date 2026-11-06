package starvation;

public class Pedido extends Thread {

    private final Almacen almacen;
    private final int rojas;
    private final int azules;
    private final boolean repetir;

    public Pedido(String nombre, Almacen almacen,
                  int rojas, int azules, boolean repetir) {
        super(nombre);
        this.almacen = almacen;
        this.rojas = rojas;
        this.azules = azules;
        this.repetir = repetir;
    }

    @Override
    public void run() {
        try {
            do {
                System.out.println(getName() + " necesita "
                        + rojas + " rojas y " + azules + " azules");
            	almacen.prepararPedido(rojas, azules);
                System.out.println(getName() + " preparado");
            } while (repetir);

        } catch (InterruptedException e) {
            // Terminar
        }
    }
}