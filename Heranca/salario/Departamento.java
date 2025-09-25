public class Departamento {

    private double valorMeta;
    private double valorAtingidoMeta;

    public Departamento(double valorMeta, double valorAtingidoMeta){
        this.valorMeta = valorMeta;
        this.valorAtingidoMeta = valorAtingidoMeta; 
    }

    public boolean alcancouMeta(){
        return valorAtingidoMeta >= valorMeta;
    }

    public double getValorMeta(){
        return this.valorMeta;
    }

    public double getValorAtingidoMeta(){
        return this.valorAtingidoMeta;
    }
    
}
