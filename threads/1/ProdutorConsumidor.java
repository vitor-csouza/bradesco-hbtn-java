public class ProdutorConsumidor {
    public static void main(String[] args) throws InterruptedException {
        Buffer buffer = new Buffer();

        // Criar as threads
        Thread produtor = new Produtor(buffer);
        Thread consumidor = new Consumidor(buffer);

        // Iniciar as threads
        produtor.start();
        consumidor.start();

        // (opcional mas recomendado) Aguardar ambas terminarem
        produtor.join();
        consumidor.join();
    }
}
