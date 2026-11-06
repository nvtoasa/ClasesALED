package starvation;

public class Almacen {

    private int rojas = 0;
    private int azules = 0;
    
    public void producirRoja() {
        rojas++;
        System.out.println("Producida pieza roja. Almacén actual: R="+rojas+" A="+azules);
        // TODO: Tras producir piezas rojas podrían salir más pedidos.
        notifyAll(); //se sale del wait(), en el while se comprobará si ya hay piezas suficientes.
    }

    public void producirAzul() {
        azules++;
        System.out.println("Producida pieza azul. Almacén actual: R="+rojas+" A="+azules);
        // TODO: Tras producir piezas azules podrían salir más pedidos.
        notifyAll();
    }

    public synchronized void prepararPedido(int necesariasRojas,
                                           int necesariasAzules) //cerrojo. se lucha por él. 
            throws InterruptedException {
    	
        // TODO: esperar hasta tener AMBOS tipos de piezas.
    	while(rojas < necesariasRojas || azules < necesariasAzules) {
    		wait(); //si se cumple la condición -> wait(), si al final hay piezas suficientes, se tiene que producir un notify y ya no se vuelve a entrar al while
    		//mientras no haya peizas suficientes, aunque se salga del wait, no avanza al volver a llegar a while
    	}
        // TODO: retirar las dos cantidades bajo el mismo monitor. Se ejecuta cuando se sale del while.
    	rojas -= necesariasRojas;
    	azules -= necesariasAzules;
    }
}

//la  hebra del pedido grande tiene posibilidades de conseguir el cerrojo, lucha por él, pero el problema viene del diseño del algoritmo
//en la pracica nunca consigue las suficientes peizas rojas y azules, es un prbemas de fairness, no es porque a nivel de hebra
//no consiga el cerrojo -> starvation