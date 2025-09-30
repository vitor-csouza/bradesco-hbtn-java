import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Estoque {

    private List<Produto> produtos;
    private String filename;
    private int proximoId = 1;

    public Estoque(String filename) {
        this.filename = filename.trim();
        this.produtos = mapearProdutos(this.filename);
        for (Produto p : produtos) {
            if (p.getId() >= proximoId) proximoId = p.getId() + 1;
        }
    }

    public void adicionarProduto(String nome, int quantidade, double preco) {
        Produto novo = new Produto(proximoId++, nome, quantidade, preco);
        produtos.add(novo);
        salvarProdutos();
    }
    
    public void excluirProduto(int id) {
        produtos.removeIf(p -> p.getId() == id);
        salvarProdutos();
    }

    public void atualizarQuantidade(int idAtualizar, int novaQuantidade) {
        for (Produto p : produtos) {
            if (p.getId() == idAtualizar) {
                p.setQuantidade(novaQuantidade);
                break;
            }
        }
        salvarProdutos();
    }

    public void exibirEstoque() {
        for (Produto p : produtos) {
            System.out.println(p.toString());
        }
    }

    private List<Produto> mapearProdutos(String fileName) {
        List<Produto> produtos = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader reader = null;
    
        try {
            fileReader = new FileReader(fileName);
            reader = new BufferedReader(fileReader);
    
            String linha;
            while ((linha = reader.readLine()) != null) {
                if (linha.trim().isEmpty()) continue;
    
                String[] partes = linha.split(",");
                if (partes.length < 4) continue;
    
                int id = Integer.parseInt(partes[0].trim());
                String nome = partes[1].trim();
                if (nome.isEmpty() || nome.matches("\\d+")) continue;
    
                int quantidade = Integer.parseInt(partes[2].trim());
                double preco = Double.parseDouble(partes[3].trim());
    
                produtos.add(new Produto(id, nome, quantidade, preco));
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        } finally {
            if (reader != null) {
                try { reader.close(); } catch (IOException ignored) {}
            }
            if (fileReader != null) {
                try { fileReader.close(); } catch (IOException ignored) {}
            }
        }
        return produtos;
    }

    private String[] obterDadosProdutoCsv(String linha) {
        String[] p = linha.split(",");
        for (int i = 0; i < p.length; i++) p[i] = p[i].trim();
        return p;
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
