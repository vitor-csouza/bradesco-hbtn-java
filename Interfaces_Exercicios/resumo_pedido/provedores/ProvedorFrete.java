package provedores;

import provedores.TipoProvedorFrete;

public interface ProvedorFrete {

    Frete calcularFrete(double peso, double valor);

    TipoProvedorFrete obterTipoProvedorFrete();
    
}
