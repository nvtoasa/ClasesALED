package starvation;

public class Almacen {

    private int rojas = 0;
    private int azules = 0;
    
    public void producirRoja() {
        rojas++;
        System.out.println("Producida pieza roja. Almacén actual: R="+rojas+" A="+azules);
        // TODO: Tras producir piezas rojas podrían salir más pedidos.
        notifyAll(); //se sale del wait()
    }

    public void producirAzul() {
        azules++;
        System.out.println("Producida pieza azul. Almacén actual: R="+rojas+" A="+azules);
        // TODO: Tras producir piezas azules podrían salir más pedidos.
    }

    public synchronized void prepararPedido(int necesariasRojas,
                                           int necesariasAzules)
            throws InterruptedException {
    	
        // TODO: esperar hasta tener AMBOS tipos de piezas.
    	while(rojas < necesariasRojas || azules < necesariasAzules) {
    		wait();
    	}
        // TODO: retirar las dos cantidades bajo el mismo monitor. Se ejecuta cuando se sale del while.
    	rojas -= necesariasRojas;
    	azules -= necesariasAzules;
    }
}