package infrastructure;

import java.util.HashMap;
import java.util.Map;

import domain.Pedido;

public class PedidoRepository {

    private final Map<String, Pedido> pedidos = new HashMap<>();

    public void salvar(Pedido pedido) {
        // salva ou atualiza o pedido no "banco" em memória
        pedidos.put(pedido.getId(), pedido);
    }

    public Pedido buscarPorId(String id) {
        // busca o pedido pelo id ou retorna null se não existir
        return pedidos.get(id);
    }
}
