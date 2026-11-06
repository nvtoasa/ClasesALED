package livelock;

public class Herramienta {

    private boolean libre = true;

    public synchronized boolean coger() {
        if (!libre) {
            return false;
        }
        libre = false;
        return true;
    }

    public synchronized void soltar() {
        libre = true;
    }
}
