import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Pedido {
    private ArrayList<PedidoCookie> cookies;

    public Pedido() {
        this.cookies = new ArrayList<>();
    }

    public void adicionarPedidoCookie(PedidoCookie pedido) {
        if (pedido != null) {
            cookies.add(pedido);
        }
    }

    public int obterTotalCaixas() {
        int total = 0;
        for (PedidoCookie pc : cookies) {
            total += pc.getQuantidadeCaixas();
        }
        return total;
    }

    public int removerSabor(String sabor) {
        int removidas = 0;
        Iterator<PedidoCookie> it = cookies.iterator();
        while (it.hasNext()) {
            PedidoCookie pc = it.next();
            if (pc.getSabor().equals(sabor)) {
                removidas += pc.getQuantidadeCaixas();
                it.remove();
            }
        }
        return removidas;
    }
}
