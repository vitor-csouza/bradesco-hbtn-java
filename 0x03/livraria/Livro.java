import exceptions.AutorInvalidoException;
import exceptions.LivroInvalidoException;

public class Livro {

    private String titulo;
    private String autor;
    private double preco;

    public Livro(String titulo, String autor, double preco) {
        this.titulo = titulo;
        this.autor = autor;
        this.preco = preco;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public double getPreco() {
        return preco;
    }

    public void setTitulo(String titulo) throws LivroInvalidoException {
        if (titulo.length() < 3) {
            throw new LivroInvalidoException("Título não pode ser vazio");
        }
        this.titulo = titulo;
    }
    
    public void setAutor(String autor) throws AutorInvalidoException {
        String[] nomes = autor.split(" ");
        if (nomes.length < 2) {
            throw new AutorInvalidoException("Nome de autor invalido");
        }
        this.autor = autor;
    }
    
    public void setPreco(double preco) throws LivroInvalidoException {
        if (preco < 0) {
            throw new LivroInvalidoException("Preco de livro invalido");
        }
        this.preco = preco;
    }
    
}
