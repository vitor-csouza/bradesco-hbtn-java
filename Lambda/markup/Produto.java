import java.util.function.Consumer;
import java.util.function.Supplier;

public class Produto {

    private String nome;
    private double preco;
    private double percentualMarkup = 10;
    Supplier<Double> precoComMarkup = () -> preco + (preco*percentualMarkup)/100;
    Consumer<Double> atualizarMarkup = (novoPercentual) -> this.percentualMarkup = novoPercentual;

    public Produto(double preco, String nome) {
        this.preco = preco;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }
    
}
