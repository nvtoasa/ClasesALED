package starvation;

public class MainLego {

    public static void main(String[] args) throws InterruptedException {

        Almacen almacen = new Almacen();

        // Pedido grande y pedido pequeño recurrente
        Pedido p1 = new Pedido("P1", almacen, 40, 10, false);
        Pedido p2 = new Pedido("P2", almacen, 2, 1, true);

        // Productor
        Thread productor = new Thread(() -> { //en vez de crear una clase, le digo a la hebra directamente lo que hacer
            try {
                while (true) {
                    almacen.producirRoja();
                    almacen.producirRoja();
                    almacen.producirAzul();
                    Thread.sleep(200);
                }
            } catch (InterruptedException e) {
                // Terminar
            }
        });

        p1.start();
        p2.start();
        productor.start();

        // Observar durante 5 segundos
        Thread.sleep(5000);

        System.out.println("¿P1 sigue esperando? " + p1.isAlive());

        productor.interrupt();
        p1.interrupt();
        p2.interrupt();

        productor.join();
        p1.join();
        p2.join();

        System.out.println("Fin");
    }
}