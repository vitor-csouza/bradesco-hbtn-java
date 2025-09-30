import java.io.*;
import java.util.*;

public class Estoque {

    private List<Produto> produtos;
    private String filename;
    private int proximoId = 1;

    public Estoque(String filename){
        this.filename = filename.trim();
        this.produtos = mapearProdutos(this.filename);
        for (Produto p : produtos) if (p.getId() >= proximoId) proximoId = p.getId() + 1;
    }

    public void adicionarProduto(String nome, int quantidade, double preco){
        if (!nomeValido(nome)) return;
        Produto novo = new Produto(proximoId++, nome.trim(), quantidade, preco);
        produtos.add(novo);
        salvarProdutos();
    }
    
    public void excluirProduto(int id){
        produtos.removeIf(p -> p.getId() == id);
        salvarProdutos();
    }

    public void exibirEstoque(){
        for (Produto p : produtos) {
            System.out.printf("ID: %d, Nome: %s, Quantidade: %d, Preço: %s%n",
                p.getId(), p.getNome(), p.getQuantidade(), String.valueOf(p.getPreco()));
        }
    }

    public void atualizarQuantidade(int idAtualizar, int novaQuantidade){
        for (Produto p : produtos) {
            if (p.getId() == idAtualizar) {
                p.setQuantidade(novaQuantidade);
                break;
            }
        }
        salvarProdutos();
    }

    private boolean nomeValido(String nome) {
        if (nome == null) return false;
        String n = nome.trim();
        if (n.length() < 2) return false;
        if (n.matches("\\d+")) return false;
        return true;
    }

    private List<Produto> mapearProdutos(String fileName) {
        List<Produto> lista = new ArrayList<>();
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);
            String linha;
            while ((linha = br.readLine()) != null) {
                if (linha.trim().isEmpty()) continue;
                String[] partes = linha.split(",");
                if (partes.length < 4) continue;

                int id = Integer.parseInt(partes[0].trim());
                String nome = partes[1].trim();
                if (!nomeValido(nome)) continue;

                int quantidade = Integer.parseInt(partes[2].trim());
                double preco = Double.parseDouble(partes[3].trim());
                lista.add(new Produto(id, nome, quantidade, preco));
            }
        } catch (FileNotFoundException e) {
            // arquivo pode não existir ainda
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        } finally {
            if (br != null) try { br.close(); } catch (IOException ignored) {}
            if (fr != null) try { fr.close(); } catch (IOException ignored) {}
        }
        return lista;
    }

    private void salvarProdutos() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (Produto p : produtos) {
                bw.write(p.getId() + "," + p.getNome() + "," + p.getQuantidade() + "," + p.getPreco());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar o arquivo: " + e.getMessage());
        }
    }
}
