public class Consumidor extends Thread {
    private final Fila fila;

    public Consumidor(Fila fila, String nome) {
        super(nome);
        this.fila = fila;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int item = fila.retirar();
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
