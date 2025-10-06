public class PessoasArray {

    private String[] nomes;

    public PessoasArray() {
        nomes =new String[]{"Amanda", "Beatriz", "Carlos","Daniela","Eduardo",
                "Fabio","Gustavo", "Hingrid","Isabela","Joao","Leise","Maria",
                "Norberto","Otavio","Paulo", "Quirino","Renata","Sabata",
                "Tais","Umberto","Vanessa","Xavier"};
    }

    public String[] getNomes() {
        return nomes;
    }

    public void setNomes(String[] nomes) {
        this.nomes = nomes;
    }

    public void buscaBinaria(String nome){
        System.out.printf("Procurando o nome: \"%s\"%n", nome);
    
        int ini = 0, fim = nomes.length - 1;
    
        while (ini <= fim) {
            int meio = (ini + fim) / 2;
            System.out.printf("Passando pelo indice: %d%n", meio);
    
            int cmp = nome.compareTo(nomes[meio]);
            if (cmp == 0) {
                System.out.printf("Nome %s encontrado na posição %d%n", nome, meio);
                return;
            } else if (cmp > 0) {
                ini = meio + 1;
            } else {
                fim = meio - 1;
            }
        }
    
        throw new IllegalArgumentException(
            String.format("O nome %s não se encontra no array de nomes", nome)
        );
    }
}