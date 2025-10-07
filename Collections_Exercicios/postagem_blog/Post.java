public class Post implements Comparable<Post> {
    private final Autor autor;
    private final String titulo;
    private final String corpo;
    private final Categorias categoria;

    public Post(Autor autor, String titulo, String corpo, Categorias categoria) {
        this.autor = autor;
        this.titulo = titulo;
        this.corpo = corpo;
        this.categoria = categoria;
    }

    public Autor getAutor() { return autor; }
    public String getTitulo() { return titulo; }
    public String getCorpo() { return corpo; }
    public Categorias getCategoria() { return categoria; }

    @Override
    public String toString() {
        return titulo;
    }

    @Override
    public int compareTo(Post o) {
        int c = this.titulo.compareToIgnoreCase(o.titulo);
        if (c != 0) return c;
        return this.autor.compareTo(o.autor);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Post)) return false;
        Post other = (Post) obj;
        return this.titulo.equals(other.titulo) && this.autor.equals(other.autor);
    }

    @Override
    public int hashCode() {
        int r = 17;
        r = 31 * r + titulo.hashCode();
        r = 31 * r + autor.hashCode();
        return r;
    }
}
