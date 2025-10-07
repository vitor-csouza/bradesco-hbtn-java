import java.util.*;

public class Blog {
    private List<Post> postagens;

    public Blog() {
        this.postagens = new ArrayList<>();
    }

    public void adicionarPostagem(Post postagem) {
        for (Post p : postagens) {
            if (p.getAutor().equals(postagem.getAutor())
                    && p.getTitulo().equals(postagem.getTitulo())) {
                throw new IllegalArgumentException("Postagem jah existente");
            }
        }
        postagens.add(postagem);
    }

    public Set<Autor> obterTodosAutores() {
        Set<Autor> autores = new TreeSet<>();
        for (Post p : postagens) {
            autores.add(p.getAutor());
        }
        return autores;
    }

    public Map<Categorias, Integer> obterContagemPorCategoria() {
        Map<Categorias, Integer> mapa = new HashMap<>();
        for (Post p : postagens) {
            mapa.merge(p.getCategoria(), 1, Integer::sum);
        }
        return mapa;
    }

    public Set<Post> obterPostsPorAutor(Autor autor) {
        Set<Post> res = new TreeSet<>();
        for (Post p : postagens) {
            if (p.getAutor().equals(autor)) {
                res.add(p);
            }
        }
        return res;
    }

    public Set<Post> obterPostsPorCategoria(Categorias categoria) {
        Set<Post> res = new TreeSet<>();
        for (Post p : postagens) {
            if (p.getCategoria() == categoria) {
                res.add(p);
            }
        }
        return res;
    }

    public Map<Categorias, Set<Post>> obterTodosPostsPorCategorias() {
        Map<Categorias, Set<Post>> res = new HashMap<>();
        for (Post p : postagens) {
            res.computeIfAbsent(p.getCategoria(), k -> new TreeSet<>()).add(p);
        }
        return res;
    }

    public Map<Autor, Set<Post>> obterTodosPostsPorAutor() {
        Map<Autor, Set<Post>> res = new HashMap<>();
        for (Post p : postagens) {
            res.computeIfAbsent(p.getAutor(), k -> new TreeSet<>()).add(p);
        }
        return res;
    }
}
