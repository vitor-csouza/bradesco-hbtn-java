import java.util.ArrayList;
import java.util.List;

public class ProcessadorVideo {

    private List<CanalNotificacao> canais;

    public ProcessadorVideo(){
        canais = new ArrayList<CanalNotificacao>();
    }

    public void registrarCanal(CanalNotificacao canal){
        canais.add(canal);
    }
    
    public void processar(Video video){

        for(CanalNotificacao canal : canais){
            Mensagem mensagem = new Mensagem(video.getArquivo() + " - " + video.getFormato(), TipoMensagem.LOG);
            canal.notificar(mensagem);
        }

    }
}
