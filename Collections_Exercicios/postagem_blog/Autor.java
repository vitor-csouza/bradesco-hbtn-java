public class Autor implements Comparable<Autor> {
    private final String nome;
    private final String sobrenome;

    public Autor(String nome, String sobrenome) {
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    public String getNome() { return nome; }
    public String getSobrenome() { return sobrenome; }

    @Override
    public String toString() {
        return nome + " " + sobrenome;
    }

    @Override
    public int compareTo(Autor o) {
        int c = this.sobrenome.compareToIgnoreCase(o.sobrenome);
        if (c != 0) return c;
        return this.nome.compareToIgnoreCase(o.nome);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Autor)) return false;
        Autor other = (Autor) obj;
        return nome.equals(other.nome) && sobrenome.equals(other.sobrenome);
    }

    @Override
    public int hashCode() {
        int r = 17;
        r = 31 * r + nome.hashCode();
        r = 31 * r + sobrenome.hashCode();
        return r;
    }
}
