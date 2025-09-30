import java.util.HashMap;
import java.util.Map;


public class GerenciamentoDeContatos {
    private Map<String, Contato> contatos;


    // Construtor
    public GerenciamentoDeContatos() {
        contatos = new HashMap<>();
    }


    // Adiciona um novo contato
    public void adicionarContato(String nome, String telefone, String email) {
        if (contatos.containsKey(nome)) {
            System.out.printf("Erro: Contato com nome %s já existe!%n", nome);
            return;
        }

        Contato contato = new Contato();
        contato.adicionarEmail(email);
        contato.adicionarTelefone(telefone);
        contatos.put(nome, contato);
        System.out.printf("Contato %s adicionado com sucesso!%n", nome);
    }


    // Exibe todos os contatos (ordenado por nome, case-insensitive)
    public void exibirContatos() {
        if (contatos.isEmpty()) {
            System.out.println("Nenhum contato cadastrado.");
            return;
        }
        contatos.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(String.CASE_INSENSITIVE_ORDER))
                .forEach(e -> {
                    System.out.printf("Nome: %s%n", e.getKey());
                    e.getValue().exibirContato();
                    System.out.println("-------------------------------");
                });
    }


    // Busca um contato pelo nome
    public void buscarContato(String nome) {
        Contato contato = contatos.get(nome);
        if (contato == null) {
            System.out.printf("Contato %s não encontrado.%n", nome);
        } else {
            System.out.printf("Contato encontrado: %s%n", nome);
            contato.exibirContato();
        }
    }


    // Remove um contato pelo nome
    public void removerContato(String nome) {
        if (contatos.remove(nome) != null) {
            System.out.printf("Contato %s removido com sucesso!%n", nome);
        } else {
            System.out.printf("Contato %s não encontrado.%n", nome);
        }
    }


    public static void main(String[] args) {
        GerenciamentoDeContatos gestao = new GerenciamentoDeContatos();


        // Adicionando contatos
        gestao.adicionarContato("Carlos", "1234-5678", "carlos@email.com");
        gestao.adicionarContato("Maria", "8765-4321", "maria@email.com");
        gestao.adicionarContato("Ana", "1122-3344", "ana@email.com");
        gestao.adicionarContato("Carlos", "1234-5678", "carlos@email.com"); // Tentando duplicar


        // Exibindo todos os contatos
        System.out.println("\nExibindo todos os contatos:");
        gestao.exibirContatos();


        // Buscando um contato
        System.out.println("\nBuscando contato 'Maria':");
        gestao.buscarContato("Maria");


        // Removendo um contato
        System.out.println("\nRemovendo contato 'Carlos':");
        gestao.removerContato("Carlos");


        // Tentando remover um contato inexistente
        System.out.println("\nTentando remover contato 'João' que não existe:");
        gestao.removerContato("João");


        // Exibindo todos os contatos após remoções
        System.out.println("\nExibindo todos os contatos após remoções:");
        gestao.exibirContatos();
    }
}