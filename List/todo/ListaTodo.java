import java.util.ArrayList;
import java.util.List;

public class ListaTodo {
    private final List<Tarefa> tarefas;

    public ListaTodo() {
        this.tarefas = new ArrayList<>();
    }

    public void adicionarTarefa(Tarefa tarefa) {
        if (tarefa == null) return;
        int id = tarefa.getIdentificador();
        for (Tarefa t : tarefas) {
            if (t.getIdentificador() == id) {
                throw new IllegalArgumentException(
                    "Tarefa com identificador " + id + " ja existente na lista"
                );
            }
        }
        tarefas.add(tarefa);
    }

    public boolean marcarTarefaFeita(int identificador) {
        for (Tarefa t : tarefas) {
            if (t.getIdentificador() == identificador) {
                t.setEstahFeita(true);
                return true;
            }
        }
        return false;
    }

    public boolean desfazerTarefa(int identificador) {
        for (Tarefa t : tarefas) {
            if (t.getIdentificador() == identificador) {
                t.setEstahFeita(false);
                return true;
            }
        }
        return false;
    }

    public void desfazerTodas() {
        for (Tarefa t : tarefas) {
            t.setEstahFeita(false);
        }
    }

    public void fazerTodas() {
        for (Tarefa t : tarefas) {
            t.setEstahFeita(true);
        }
    }

    public void listarTarefas() {
        for (Tarefa t : tarefas) {
            String marcador = t.isEstahFeita() ? "X" : " ";
            System.out.printf("[%s]  Id: %d - Descricao: %s%n",
                    marcador, t.getIdentificador(), t.getDescricao());
        }
    }
}
