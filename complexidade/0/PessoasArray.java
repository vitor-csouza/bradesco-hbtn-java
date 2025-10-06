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

    public void pesquisaTempoConstante(int id){
        if (id < 0 || id >= nomes.length) {
            throw new IllegalArgumentException(
                String.format(new java.util.Locale("pt","BR"),
                              "O array de nomes possui :%d nomes.", nomes.length)
            );
        }
        System.out.printf("Nome pesquisado é %s que está na posição %d%n", nomes[id], id);
    }

    public void buscaLinear(String nome){
        System.out.println("Procurando pelo nome: "+ nome);
        boolean encontrado = false;
        for(int i=0;i<nomes.length;i++){
            System.out.println("Passando pelo indice:"+i);
            encontrado = nomes[i] == nome;
            if(encontrado){
                System.out.printf("Nome pesquisado é %s que está na posição %d", nome, i);
            } else {
                throw new IllegalArgumentException(String.format(new java.util.Locale("pt","BR"), "O nome %s não se encontra no array de nomes", nome));
            }
        }

    }
}