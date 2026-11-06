package livelock;

public class Trabajador extends Thread {

    private final Herramienta primera;
    private final Herramienta segunda;
    private Object cerrojo;

    public Trabajador(String nombre, Herramienta primera,
                      Herramienta segunda, Object Cerrojo) {
        super(nombre);
        this.primera = primera;
        this.segunda = segunda;
        this.cerrojo = Cerrojo;
    }

    @Override
    public void run() {
    	synchronized(cerrojo) { //se resuleve el problema, pero no están haciendo a la vez, si no que un trabajador espera al otro. Esta es una manera de solucionarlo.
    		//ahora lo consiguen ambos trabajdores en el primer intento.
        	try {
                for (int intento = 1; intento <= 10; intento++) {
                	System.out.println(getName() + ": intento " + intento);
                    if (primera.coger()) {
                        boolean tengoSegunda = false;
                        try {
                            Thread.sleep(150); // Tiempo en coger la segunda herramienta.
                            tengoSegunda = segunda.coger();

                            if (tengoSegunda) {
                                System.out.println(getName() + ": PIEZA MONTADA");
                                return;
                            }

                            System.out.println(getName() + ": cede y reintenta " + intento);
                            // Para un livelock real, tendría que ocurrir de forma indefinida en el tiempo...
                        } finally {
                            if (tengoSegunda) {
                                segunda.soltar();
                            }
                            primera.soltar();
                        }
                    }

                    Thread.sleep(150);
                }
                System.out.println(getName() + ": sin pieza tras 10 intentos");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
    	}
    }

    public static void main(String[] args) {
        Herramienta martillo = new Herramienta();
        Herramienta destornillador = new Herramienta();
        Object cerrojo = new Object();

        Trabajador h1 = new Trabajador("H1", martillo, destornillador, cerrojo);
        Trabajador h2 = new Trabajador("H2", destornillador, martillo, cerrojo);

        h1.start();
        h2.start();
    }
}

//comprueba si te falta código

//livelock: es como cuando estas caminando y te encuentras a alguien de frente, y entonces tu va para la derecha y el tambien
//y entonces te vas para la izquierda y el tambien, y asi os estais bloquando mutuamente
//nuestro caso: dos herramientas: martillo y destornllador. mis trbajaaodres intentan coger uno de los dos.
//HERRAMIENTA
//pueda estar libre o no
//la herramienta. un trbaajador (hebra) ntenta coger la herramienta, synchronized para no condicion de carrera (y no mchacar valores, de que este ocupado y luego el otro antes lo haya ledio como libre)
//primero consulta si esta libre, si no esta libre devuelve que no la puedo coger. si esta libre avisa de que no esta lbre ya. con soltar
//suelta la herramienta que tiene cogida, primero comprueba que haya algo
//TRABAJADOR
//10 intentos trtaa de fabricar algo, si no lo consigue para. si consgiue cogr la primera herramienta sigue adelante. si no se duerme y lo vuelve a intentar en el 2o inetento.
//si lo ha conseguido intentara conseguir la segunda. primero no la tiene, tiene que esperar 150ms para coger las egunda. true si la consgue coger
//si la consigue geniall ya puedes construir, monta la pieza.
//si no la consigue, suelta la herramienta para ver si el otro trabajdor la puede coger (como moverme en la calle intentanto dar espacio para pasar)
//en el finally se ejecuta antes del return. o si hay alguna excepcion. suelta las herrameintas

//uno coge una pieza, intenta coger la segunda... no puede por que tiene la otra, dice esperate que yo suelto la mia para que puedas terminar tu pieza, pero
//el otro tambien la suelta... un bucle. -> LIVELOCK. no quiere decir que no se vaya a conseguir, pero va a ver varios intentos, a vces en el segundo otras en el tercero... 
//y si en este caso pasamos el decimo, no hay piezas
