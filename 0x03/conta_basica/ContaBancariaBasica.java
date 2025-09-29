import exceptions.OperacaoInvalidaException;

public class ContaBancariaBasica {

    private String numeracao;
    private double saldo;
    private double taxaJurosAnual;

    public ContaBancariaBasica(String numeracao, double taxaJurosAnual) {
        this.numeracao = numeracao;
        this.taxaJurosAnual = taxaJurosAnual;
        this.saldo = 0.0;
    }

    public void depositar(double valor) throws OperacaoInvalidaException {
        if (valor <= 0) {
            throw new OperacaoInvalidaException("Valor para deposito deve ser maior que 0");
        }
        saldo += valor;
    }

    public void sacar(double valor) throws OperacaoInvalidaException {
        if (valor <= 0) {
            throw new OperacaoInvalidaException("Valor de saque deve ser maior que 0");
        }
        if (valor > saldo) {
            throw new OperacaoInvalidaException("Valor de saque deve ser menor que o saldo atual");
        }
        saldo -= valor;
    }

    public double calcularTarifaMensal() {
        double taxaFixa = 10.0;
        double dezPorCento = Math.max(0.0, saldo * 0.10); // 0% se saldo negativo
        return Math.min(taxaFixa, dezPorCento);
    }

    public double calcularJurosMensal() {
        if (saldo < 0) return 0.0;
        double taxaMensal = (taxaJurosAnual / 12.0) / 100.0; // nominal a.m.
        return saldo * taxaMensal;
    }

    public void aplicarAtualizacaoMensal() {
        saldo = saldo - calcularTarifaMensal() + calcularJurosMensal();
    }

    // Getters
    public String getNumeracao() { return numeracao; }
    public double getSaldo() { return saldo; }
    public double getTaxaJurosAnual() { return taxaJurosAnual; }
}
