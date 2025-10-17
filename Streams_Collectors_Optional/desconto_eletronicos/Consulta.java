import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Consulta {

    public static List<Produto> obterLivrosDoPedido(Pedido pedido) {
        return pedido.getProdutos()
                     .stream()
                     .filter(produto -> produto.getCategoria() == CategoriaProduto.LIVRO)
                     .collect(Collectors.toList());
    }

    public static Produto obterProdutoMaiorPreco(List<Produto> produtos) {
    return produtos.stream()
                    .sorted(Comparator.comparing(Produto::getPreco).reversed())
                    .findFirst()
                    .orElse(null);
    }

    public static List<Produto> obterProdutosPorPrecoMinimo(List<Produto> produtos, double precoMinimo) {
        if (produtos == null) return List.of();
        return produtos.stream()
                       .filter(p -> p.getPreco() >= precoMinimo)
                       .collect(Collectors.toList());
    }

    public static List<Pedido> obterPedidosComEletronicos(List<Pedido> pedidos) {
        if (pedidos == null) return List.of();

        return pedidos.stream()
                .filter(pedido -> pedido.getProdutos() != null &&
                        pedido.getProdutos().stream()
                            .anyMatch(produto -> produto.getCategoria() == CategoriaProduto.ELETRONICO))
                .collect(Collectors.toList());
    }

    public static List<Produto> aplicar15PorcentoDescontoEletronicos(List<Produto> produtos) {
        if (produtos == null) return List.of();
        return produtos.stream()
                .map(p -> {
                    if (p.getCategoria() == CategoriaProduto.ELETRONICO) {
                        p.setPreco(p.getPreco() * 0.85);
                    }
                    return p;
                })
                .collect(Collectors.toList());
    }
}
