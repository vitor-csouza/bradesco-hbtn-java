import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Blog {
    private final List<Post> postagens;

    public Blog() {
        this.postagens = new ArrayList<>();
    }

    public void adicionarPostagem(Post postagem) {
        if (postagem != null) {
            postagens.add(postagem);
        }
    }

    public Set<String> obterTodosAutores() {
        Set<String> autores = new TreeSet<>();
        for (Post p : postagens) {
            if (p.getAutor() != null) {
                autores.add(p.getAutor());
            }
        }
        return autores;
    }

    public Map<String, Integer> obterContagemPorCategoria() {
        Map<String, Integer> contagem = new TreeMap<>();
        for (Post p : postagens) {
            String cat = p.getCategoria();
            if (cat != null) {
                contagem.put(cat, contagem.getOrDefault(cat, 0) + 1);
            }
        }
        return contagem;
    }
}
