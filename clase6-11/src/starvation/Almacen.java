package starvation;

import java.util.LinkedList;
import java.util.Queue;

public class Almacen {

    private int rojas = 0;
    private int azules = 0;
    Queue<Thread> cola = new LinkedList<>(); //repasar queue y linkedlist
    
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
    	
    	cola.add(Thread.currentThread());
    	
        // TODO: esperar hasta tener AMBOS tipos de piezas.
    	while(cola.peek()!= Thread.currentThread() || rojas < necesariasRojas || azules < necesariasAzules) {//si no eres el que sale en la cola primero (cola.peek comprueba el primero) entonces te vas a dormir, no es tu turno.
    		wait(); //si se cumple la condición -> wait(), si al final hay piezas suficientes, se tiene que producir un notify y ya no se vuelve a entrar al while
    		//mientras no haya peizas suficientes, aunque se salga del wait, no avanza al volver a llegar a while
    	}
        // TODO: retirar las dos cantidades bajo el mismo monitor. Se ejecuta cuando se sale del while.
    	rojas -= necesariasRojas;
    	azules -= necesariasAzules;
    	//si llegaos aqui significa que eera el pedido que tocaba sacar
    	cola.remove(); //lo quitamos porque ese pedido ha salido con exito de la fabrica
    	notifyAll(); //despertar al resto para poder volver a comprobar cual es el siguiente en la cola, luego en el while se dormiran los que no les toque. sin esto no seria eficiente, pero... ¿funcionaría?
    }
}

//la  hebra del pedido grande tiene posibilidades de conseguir el cerrojo, lucha por él, pero el problema viene del diseño del algoritmo
//en la pracica nunca consigue las suficientes peizas rojas y azules, es un prbemas de fairness, no es porque a nivel de hebra
//no consiga el cerrojo -> starvation