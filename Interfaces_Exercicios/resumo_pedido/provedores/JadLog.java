package provedores;

import provedores.ProvedorFrete;

public class JadLog implements ProvedorFrete {

    @Override
    public Frete calcularFrete(double peso, double valor) {
        if(peso < 2000){
            valor = valor * 1.045;
        } else {
            valor = valor * 1.07;
        }
        return new Frete(valor, TipoProvedorFrete.JADLOG);
    }

    @Override
    public TipoProvedorFrete obterTipoProvedorFrete() {
        return TipoProvedorFrete.JADLOG;
    }
    
}
