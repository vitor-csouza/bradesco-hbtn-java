public class Gerente extends Empregado {


    public Gerente(double salarioFixo) {
        super(salarioFixo);
    }


    @Override
    public double calcularBonus(Departamento departamento){
        double bonusPorcentagemSalario = 0.2;
        double bonusPorcentagemMetasAtingidas = 0.01;
        double bonusMetasAtingidas = 0;
        boolean foiMetaAtingida = departamento.alcancouMeta();
        if (foiMetaAtingida) {
            bonusMetasAtingidas = (departamento.getValorAtingidoMeta() - departamento.getValorMeta())*bonusPorcentagemMetasAtingidas;
            return salarioFixo * bonusPorcentagemSalario + bonusMetasAtingidas;
        }
        return 0;
    }
    
}
