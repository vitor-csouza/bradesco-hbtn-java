public class Empregado {

    protected double salarioFixo;

    public Empregado(double salarioFixo){
        this.salarioFixo = salarioFixo;
    }

    public double calcularBonus(Departamento departamento){
        double bonusPorcentagemSalario = 0.1;
        boolean foiMetaAtingida = departamento.alcancouMeta();
        if (foiMetaAtingida) {
            return salarioFixo * bonusPorcentagemSalario;
        }
        return 0;
    }

    public double calcularSalarioTotal(Departamento departamento){
        return salarioFixo + calcularBonus(departamento);
    }

    public double getSalarioFixo(){
        return this.salarioFixo;
    }
    
}
