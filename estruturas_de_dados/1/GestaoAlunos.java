import java.util.ArrayList;
import java.util.List;

public class GestaoAlunos {

    private final List<Aluno> alunos = new ArrayList<>();

    public void adicionarAluno(String nome, int idade) {
        alunos.add(new Aluno(nome, idade));
    }

    public boolean excluirAluno(String nome) {
        int idx = indexByName(nome);
        if (idx >= 0) {
            Aluno removido = alunos.remove(idx);
            return true;
        }
        return false;
    }

    public Aluno buscarAluno(String nome) {
        int idx = indexByName(nome);
        if (idx >= 0) {
            Aluno a = alunos.get(idx);
            return a;
        }
        return null;
    }

    public void listarAlunos() {
        if (alunos.isEmpty()) {
            return;
        }
        for (Aluno aluno : alunos) {
            System.out.println(aluno);
        }
    }

    private int indexByName(String nome) {
        if (nome == null) return -1;
        String alvo = nome.trim().toLowerCase();
        for (int i = 0; i < alunos.size(); i++) {
            if (alunos.get(i).getNome().trim().toLowerCase().equals(alvo)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        GestaoAlunos app = new GestaoAlunos();

        app.adicionarAluno("Ana", 20);
        app.adicionarAluno("Bruno", 22);
        app.adicionarAluno("Carla", 19);

        app.listarAlunos();

        app.buscarAluno("Bruno");
        app.excluirAluno("Ana");
        app.excluirAluno("Zelda");
        app.buscarAluno("Ana");
        app.listarAlunos();
    }
}
