import provedores.ProvedorFrete;
import provedores.TipoProvedorFrete;

public class ProcessadorPedido {
    
    private ProvedorFrete provedorFrete;

    public ProcessadorPedido(ProvedorFrete provedorFrete){
        this.provedorFrete = provedorFrete;
    }

    public void processar(Pedido pedido){
        double total = provedorFrete.calcularFrete(pedido.getTotal(), pedido.getPeso());
        TipoProvedorFrete tipoProvedorFrete;
        Frete frete = new Frete(total, tipoProvedorFrete);
        pedido.setFrete(frete);

    }
}
