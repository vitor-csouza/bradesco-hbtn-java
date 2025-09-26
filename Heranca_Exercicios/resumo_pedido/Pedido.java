public class Pedido {

    private double percentualDesconto;
    private ItemPedido[] itens;

    public Pedido(double percentualDesconto, ItemPedido[] itens) {
        this.itens = itens;
        this.percentualDesconto = percentualDesconto;
    }

    public double calcularTotal(){
        double soma = 0;
        double desconto = 0;
        for(ItemPedido item : itens) {
            soma += item.getQuantidade() * item.getProduto().obterPrecoLiquido();
        }
        desconto = (100 - percentualDesconto)/100;
        return soma * desconto;
    }

    public void apresentarResumoPedido() {
        double soma = 0.0;
    
        System.out.println("------- RESUMO PEDIDO -------");
        for (ItemPedido item : itens) {
            double preco = item.getProduto().obterPrecoLiquido();
            double total = preco * item.getQuantidade();
    
            System.out.printf(java.util.Locale.forLanguageTag("pt-BR"),
                "Tipo: %s  Titulo: %s  Preco: %.2f  Quant: %d  Total: %.2f%n",
                item.getProduto().getClass().getSimpleName(),
                item.getProduto().getTitulo(),
                preco,
                item.getQuantidade(),
                total
            );
    
            soma += total;
        }
    
        double valorDesconto = soma * (percentualDesconto / 100.0);
        String SEP = "----------------------------";

        System.out.println(SEP);
        System.out.printf("DESCONTO: %.2f%n", valorDesconto);
        System.out.println(SEP);
        System.out.printf("TOTAL PRODUTOS: %.2f%n", soma);
        System.out.println(SEP);
        System.out.printf("TOTAL PEDIDO: %.2f%n", calcularTotal());
        System.out.println(SEP);
    }
    
}
