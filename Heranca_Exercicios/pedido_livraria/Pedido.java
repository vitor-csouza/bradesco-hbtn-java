public class Pedido {

    private double percentualDesconto;
    private ItemPedido[] itens;

    public Pedido(double percentualDesconto, ItemPedido[] itens) {
        this.itens = itens;
    }

    public double calcularTotal(){
        double soma = 0;
        for(ItemPedido item : itens) {
            soma += item.getQuantidade() * item.getProduto().obterPrecoLiquido();
        }
        return soma * (1.0 - percentualDesconto / 100.0);
    }
    
}
