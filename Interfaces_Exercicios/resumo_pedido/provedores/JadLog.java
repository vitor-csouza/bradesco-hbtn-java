package provedores;

public class JadLog implements ProvedorFrete {

    @Override
    public Frete calcularFrete(double peso, double valor) {
        if(peso < 2000){
            valor = valor * 0.045;
        } else {
            valor = valor * 0.07;
        }
        return new Frete(valor, TipoProvedorFrete.JADLOG);
    }

    @Override
    public TipoProvedorFrete obterTipoProvedorFrete() {
        return TipoProvedorFrete.JADLOG;
    }
    
}
