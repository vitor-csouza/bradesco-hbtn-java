class PersonagemGame {

    private int saudeAtual;
    private String nome;
    private String status;

    public void tomarDano(int quantidadeDeDano){
        int novaVida = saudeAtual - quantidadeDeDano;
        if(novaVida < 0) {
            novaVida = 0;
        }
        setSaudeAtual(novaVida);
    }

    public void receberCura(int quantidadeDeCura) {
        int novaVida = saudeAtual + quantidadeDeCura;
        if(novaVida > 100) {
            novaVida = 100;
        }
        setSaudeAtual(novaVida);
    }

    public int getSaudeAtual() {
        return this.saudeAtual;
    }

    public void setSaudeAtual(int saudeAtual) {
        this.saudeAtual = saudeAtual;

        if (this.saudeAtual > 0){
            this.status = "vivo";
        } else {
            this.status = "morto";
        }
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getStatus() {
        return this.status;
    }
}