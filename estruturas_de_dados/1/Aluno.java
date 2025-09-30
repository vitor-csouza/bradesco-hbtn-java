public class Aluno {

    private String nome;
    private int idade;

    public Aluno(String nome, int idade) {
        setNome(nome);
        setIdade(idade);
    }

    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public int getIdade() {
        return idade;
    }
    
    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s - Idade: %d", this.nome, this.idade);
    }
    
}
