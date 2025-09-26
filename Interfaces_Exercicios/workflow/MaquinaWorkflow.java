import java.util.List;

import atividades.Atividade;

public class MaquinaWorkflow {

    public void executar(Workflow workflow){
        List<Atividade> atividades = workflow.getAtividades();
        for(Atividade atividade : atividades){
            atividade.executar();
        }
    }
    
}
