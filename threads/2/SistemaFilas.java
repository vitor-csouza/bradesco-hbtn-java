public class SistemaFilas {
    public static void main(String[] args) throws InterruptedException {
        Fila fila = new Fila(10);
        Thread p1 = new Produtor(fila, "Produtor-1");
        Thread p2 = new Produtor(fila, "Produtor-2");
        Thread c1 = new Consumidor(fila, "Consumidor-1");
        Thread c2 = new Consumidor(fila, "Consumidor-2");

        p1.start();
        p2.start();
        c1.start();
        c2.start();

        Thread.sleep(20000);

        System.exit(0);
    }
}
