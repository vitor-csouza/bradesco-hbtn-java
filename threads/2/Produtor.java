import java.util.Random;

public class Produtor extends Thread {
    private final Fila fila;
    private final Random random = new Random();

    public Produtor(Fila fila, String nome) {
        super(nome);
        this.fila = fila;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int valor = random.nextInt(100) + 1;
                fila.adicionar(valor);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
