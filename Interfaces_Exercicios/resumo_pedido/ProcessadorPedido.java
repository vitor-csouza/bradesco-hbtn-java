import provedores.Frete;
import provedores.ProvedorFrete;
import provedores.TipoProvedorFrete;

public class ProcessadorPedido {
    
    private ProvedorFrete provedorFrete;

    public ProcessadorPedido(ProvedorFrete provedorFrete){
        this.provedorFrete = provedorFrete;
    }

    public void processar(Pedido pedido){
        Frete frete = provedorFrete.calcularFrete(pedido.getPeso(), pedido.getTotal());
        TipoProvedorFrete tipoProvedorFrete;
        pedido.setFrete(frete);

    }
}
