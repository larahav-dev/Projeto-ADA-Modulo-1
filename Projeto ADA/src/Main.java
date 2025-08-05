import Entity.Ator;
import Services.ServicosAtor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    private static final ServicosAtor servicosAtor = new ServicosAtor();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== Catálogo de Filmes ====");
            System.out.println("1. Atores");
            System.out.println("2. Diretores");
            System.out.println("3. Roterista");
            System.out.println("4. Filmes");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            String opcao = scanner.nextLine().trim();

            switch (opcao) {
                case "1": menuAtores(scanner);    break;
                case "2": menuDiretores(scanner); break;
                case "3": menuRoteirista(scanner);    break;
                case "4": menuFilmes(scanner);    break;
                case "5":
                    System.out.println("Encerrando aplicação...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
    // Métodos de Menu.

    private static void menuAtores(Scanner scanner) {
        while (true) {
            System.out.println("\n== Menu Atores ==");
            System.out.println("1. Cadastrar ator");
            System.out.println("2. Listar atores");
            System.out.println("3. Visualizar ator");
            System.out.println("4. Voltar");
            System.out.print("Opção: ");
            String opcao = scanner.nextLine().trim();

            switch (opcao) {
                case "1": cadastrarAtor(scanner);   break;
                case "2": listarAtores();           break;
                case "3": visualizarAtor(scanner);  break;
                case "4": return;
                default: System.out.println("Opção inválida.");
            }
        }
    }

    // Métodos para Atores

    private static void cadastrarAtor(Scanner scanner) {
        System.out.println("\n--- Cadastro de Ator ---");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Data de Nascimento (dd/MM/yyyy): ");
        String dataStr = scanner.nextLine();
        LocalDate dataNascimento;
        try {
            dataNascimento = LocalDate.parse(dataStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        } catch (Exception e) {
            System.out.println("Formato de data inválido. Cadastro cancelado.");
            return;
        }

        System.out.print("Nacionalidade: ");
        String nacionalidade = scanner.nextLine();

        Ator novoAtor = new Ator(nome, dataNascimento, nacionalidade);
        if (servicosAtor.cadastrarAtor(novoAtor)) {
            System.out.println("Ator cadastrado com sucesso!");
        } else {
            System.out.println("Erro ao cadastrar o ator.");
        }
    }

    private static void listarAtores() {
        System.out.println("\n--- Lista de Atores ---");
        List<Ator> atores = servicosAtor.listarAtores();

        if (atores.isEmpty()) {
            System.out.println("Nenhum ator cadastrado.");
        } else {
            for (Ator ator : atores) {
                System.out.println(ator);
            }
        }
    }

    private static void visualizarAtor(Scanner scanner) {
        System.out.println("\n--- Visualizar Ator ---");
        System.out.print("Digite o nome do ator: ");
        String nomeBusca = scanner.nextLine();

        Optional<Ator> atorEncontrado = servicosAtor.visualizarAtorPorNome(nomeBusca);

        if (atorEncontrado.isPresent()) {
            System.out.println(atorEncontrado.get());
        } else {
            System.out.println("Ator '" + nomeBusca + "' não encontrado.");
        }
    }

    // Métodos de Menu Diretores
    private static void menuDiretores(Scanner scanner) {
        while (true) {
            System.out.println("\n== Menu Diretores ==");
            System.out.println("1. Cadastrar diretor");
            System.out.println("2. Listar diretores");
            System.out.println("3. Visualizar diretor");
            System.out.println("4. Voltar");
            System.out.print("Opção: ");
            String opcao = scanner.nextLine().trim();

            switch (opcao) {
                case "1": cadastrarDiretor(scanner);   break;
                case "2": listarDiretores();           break;
                case "3": visualizarDiretor(scanner);  break;
                case "4": return;
                default: System.out.println("Opção inválida.");
            }
        }
    }

    // Métodos de Menu Roteirista
    private static void menuRoteirista(Scanner scanner) {
        while (true) {
            System.out.println("\n== Menu Atores ==");
            System.out.println("1. Cadastrar roteirista");
            System.out.println("2. Listar roteirista");
            System.out.println("3. Visualizar roteirista");
            System.out.println("4. Voltar");
            System.out.print("Opção: ");
            String opcao = scanner.nextLine().trim();

            switch (opcao) {
                case "1": cadastrarRoteirista(scanner);   break;
                case "2": listarRoteirista();           break;
                case "3": visualizarRoteirista(scanner);  break;
                case "4": return;
                default: System.out.println("Opção inválida.");
            }
        }
    }

    // Métodos de Menu Filmes
    private static void menuFilmes(Scanner scanner) {
        while (true) {
            System.out.println("\n== Menu Filmes ==");
            System.out.println("1. Cadastrar filme");
            System.out.println("2. Listar filmes");
            System.out.println("3. Visualizar filme");
            System.out.println("4. Voltar");
            System.out.print("Opção: ");
            String opcao = scanner.nextLine().trim();

            switch (opcao) {
                case "1": cadastrarFilme(scanner);    break;
                case "2": listarFilmes();              break;
                case "3": visualizarFilme(scanner);    break;
                case "4": return;
                default: System.out.println("Opção inválida.");
            }
        }
    }

    private static void cadastrarDiretor(Scanner scanner) {
        System.out.println("Funcionalidade de cadastrar diretor ainda não implementada.");
    }
    private static void listarDiretores() {
        System.out.println("Funcionalidade de listar diretores ainda não implementada.");
    }
    private static void visualizarDiretor(Scanner scanner) {
        System.out.println("Funcionalidade de visualizar diretor ainda não implementada.");
    }
    private static void cadastrarRoteirista(Scanner scanner) {
        System.out.println("Funcionalidade de cadastrar roteirista ainda não implementada.");
    }
    private static void listarRoteirista() {
        System.out.println("Funcionalidade de listar roteirista ainda não implementada.");
    }
    private static void visualizarRoteirista(Scanner scanner) {
        System.out.println("Funcionalidade de visualizar roteirista ainda não implementada.");
    }
    private static void cadastrarFilme(Scanner scanner) {
        System.out.println("Funcionalidade de cadastrar filme ainda não implementada.");
    }
    private static void listarFilmes() {
        System.out.println("Funcionalidade de listar filmes ainda não implementada.");
    }
    private static void visualizarFilme(Scanner scanner) {
        System.out.println("Funcionalidade de visualizar filme ainda não implementada.");
    }
}