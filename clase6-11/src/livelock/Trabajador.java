package livelock;

public class Trabajador extends Thread {

    private final Herramienta primera;
    private final Herramienta segunda;

    public Trabajador(String nombre, Herramienta primera,
                      Herramienta segunda) {
        super(nombre);
        this.primera = primera;
        this.segunda = segunda;
    }

    @Override
    public void run() {
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

    public static void main(String[] args) {
        Herramienta martillo = new Herramienta();
        Herramienta destornillador = new Herramienta();

        Trabajador h1 = new Trabajador("H1", martillo, destornillador);
        Trabajador h2 = new Trabajador("H2", destornillador, martillo);

        h1.start();
        h2.start();
    }
}
