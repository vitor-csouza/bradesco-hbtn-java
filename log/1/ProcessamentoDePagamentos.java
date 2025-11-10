import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class ProcessamentoDePagamentos {

    private static final Logger logger = LoggerFactory.getLogger(ProcessamentoDePagamentos.class);

    public static void main(String[] args) {
        Random random = new Random();
        int totalPagamentos = 5;

        for (int i = 1; i <= totalPagamentos; i++) {
            logger.info("Iniciando o processamento do pagamento {}", i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                logger.error("Thread interrompida durante o processamento do pagamento {}", i);
                return;
            }

            int estado = random.nextInt(3);
            if (estado == 0) {
                logger.info("Pagamento {} processado com sucesso.", i);
            } else if (estado == 1) {
                logger.error("Erro ao processar o pagamento {}: Falha na transação.", i);
            } else {
                logger.warn("Pagamento {} está pendente. Aguardando confirmação.", i);
            }
        }

        logger.info("Processamento de pagamentos concluído.");
    }
}
