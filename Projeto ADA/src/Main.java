import Entity.Filme;
import Services.ServicosAtor;
import Services.ServicosDiretor;
import Services.ServicosFilme;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    private static final ServicosAtor servicosAtor = new ServicosAtor();
    private static final ServicosDiretor servicosDiretor = new ServicosDiretor();
    private static final ServicosFilme servicosFilme = new ServicosFilme();

    private static final DateTimeFormatter DATE_FMT = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== Catálogo de Filmes ====");
            System.out.println("1. Atores");
            System.out.println("2. Diretores");
            System.out.println("3. Filmes");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            String opcao = scanner.nextLine().trim();

            switch (opcao) {
                case "1": menuAtores(scanner);    break;
                case "2": menuDiretores(scanner); break;
                case "3": menuFilmes(scanner);    break;
                case "4":
                    System.out.println("Encerrando aplicação...");
                    return;
                default: System.out.println("Opção inválida.");
            }
        }
    }

    // ======= Menus =======
    private static void menuAtores(Scanner scanner) {
        while (true) {
            System.out.println("\n== Menu Atores ==");
            System.out.println("1. Listar atores");
            System.out.println("2. Voltar");
            String opcao = scanner.nextLine().trim();

            switch (opcao) {
                case "1": listarAtores(); break;
                case "2": return;
                default: System.out.println("Opção inválida.");
            }
        }
    }

    private static void menuDiretores(Scanner scanner) {
        while (true) {
            System.out.println("\n== Menu Diretores ==");
            System.out.println("1. Listar diretores");
            System.out.println("2. Voltar");
            String opcao = scanner.nextLine().trim();

            switch (opcao) {
                case "1": listarDiretores(); break;
                case "2": return;
                default: System.out.println("Opção inválida.");
            }
        }
    }

    private static void menuFilmes(Scanner scanner) {
        while (true) {
            System.out.println("\n== Menu Filmes ==");
            System.out.println("1. Cadastrar filme");
            System.out.println("2. Listar filmes");
            System.out.println("3. Visualizar filme");
            System.out.println("4. Voltar");
            String opcao = scanner.nextLine().trim();

            switch (opcao) {
                case "1": cadastrarFilme(scanner);   break;
                case "2": listarFilmes();             break;
                case "3": visualizarFilme(scanner);   break;
                case "4": return;
                default: System.out.println("Opção inválida.");
            }
        }
    }

    // ======= Atores/Diretores =======
    private static void listarAtores() {
        System.out.println("\n--- Lista de Atores ---");
        var lista = servicosAtor.listarAtores();
        if (lista.isEmpty()) System.out.println("Nenhum ator cadastrado.");
        else lista.forEach(System.out::println);
    }

    private static void listarDiretores() {
        System.out.println("\n--- Lista de Diretores ---");
        var lista = servicosDiretor.listarDiretores();
        if (lista.isEmpty()) System.out.println("Nenhum diretor cadastrado.");
        else lista.forEach(System.out::println);
    }

    // ======= Filmes =======
    private static void cadastrarFilme(Scanner scanner) {
        System.out.println("\n--- Cadastro de Filme ---");
        System.out.print("Título: ");
        String titulo = scanner.nextLine();

        LocalDate dataLancamento = lerData(scanner, "Data de Lançamento (dd/MM/yyyy): ");
        if (dataLancamento == null) return;

        System.out.print("Classificação Indicativa: ");
        String classificacao = scanner.nextLine();

        System.out.print("Gênero: ");
        String genero = scanner.nextLine();

        Double orcamento = lerDouble(scanner, "Orçamento (ex: 150000000): ");
        if (orcamento == null) return;

        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();

        System.out.print("Diretores (separados por vírgula): ");
        List<String> nomesDiretores = lerLista(scanner.nextLine());
        if (nomesDiretores.isEmpty()) {
            System.out.println("⚠ É necessário informar ao menos um diretor.");
            return;
        }

        System.out.print("Atores (separados por vírgula): ");
        List<String> nomesAtores = lerLista(scanner.nextLine());

        // Aqui delegamos para o ServicosFilme, que cuidará de pedir dados completos
        servicosFilme.cadastrarFilme(
                titulo,
                dataLancamento,
                classificacao,
                genero,
                orcamento,
                descricao,
                nomesDiretores,
                nomesAtores
        );
    }

    private static void listarFilmes() {
        System.out.println("\n--- Lista de Filmes ---");
        servicosFilme.visualizarFilmes();
    }

    private static void visualizarFilme(Scanner scanner) {
        System.out.print("Digite o título do filme: ");
        String titulo = scanner.nextLine();
        Optional<Filme> encontrado = servicosFilme.buscarPorTitulo(titulo);
        if (encontrado.isPresent()) System.out.println(encontrado.get());
        else System.out.println("Filme não encontrado.");
    }

    // ======= Helpers =======
    private static LocalDate lerData(Scanner scanner, String prompt) {
        System.out.print(prompt);
        try {
            return LocalDate.parse(scanner.nextLine(), DATE_FMT);
        } catch (Exception e) {
            System.out.println("Formato inválido.");
            return null;
        }
    }

    private static Double lerDouble(Scanner scanner, String prompt) {
        System.out.print(prompt);
        try {
            return Double.parseDouble(scanner.nextLine().replace(",", "."));
        } catch (Exception e) {
            System.out.println("Número inválido.");
            return null;
        }
    }

    private static List<String> lerLista(String linha) {
        List<String> lista = new ArrayList<>();
        if (linha == null || linha.isBlank()) return lista;
        for (String s : linha.split(",")) {
            String t = s.trim();
            if (!t.isEmpty()) lista.add(t);
        }
        return lista;
    }
}
