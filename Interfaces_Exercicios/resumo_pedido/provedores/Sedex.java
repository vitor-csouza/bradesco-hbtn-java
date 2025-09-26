package provedores;

import provedores.ProvedorFrete;
import provedores.TipoProvedorFrete;

public class Sedex implements ProvedorFrete {

    @Override
    public Frete calcularFrete(double peso, double valor) {
        if(peso < 1000){
            valor = valor * 0.05;
        } else {
            valor = valor * 0.1;
        }
        return new Frete(valor, TipoProvedorFrete.SEDEX);
    }
    
    @Override
    public TipoProvedorFrete obterTipoProvedorFrete() {
        return TipoProvedorFrete.SEDEX;
    }
}
