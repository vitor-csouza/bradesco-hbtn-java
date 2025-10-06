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

    public void buscaLinear(String nome){
        System.out.printf("Procurando pelo nome: \"%s\"%n", nome);
        boolean encontrado = false;
    
        for (int i = 0; i < nomes.length; i++) {
            System.out.printf("Passando pelo indice:%d%n", i);
            if (nomes[i].equals(nome)) {
                System.out.printf("Nome pesquisado é %s que está na posição %d%n", nomes[i], i);
                encontrado = true;
            }
        }
    
        if (!encontrado) {
            throw new IllegalArgumentException(
                String.format("O nome %s não se encontra no array de nomes", nome)
            );
        }
    }
}