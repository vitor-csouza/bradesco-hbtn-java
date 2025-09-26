import java.util.ArrayList;
import java.util.List;

import atividades.Atividade;

public class Workflow {

    private List<Atividade> atividades;

    public Workflow(){
        this.atividades = new ArrayList<Atividade>();
    }

    public void registrarAtividade(Atividade atividade){
        atividades.add(atividade);
    }

    public List<Atividade> getAtividades() {
        return atividades;
    } 
    
}
