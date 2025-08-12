import java.util.Scanner;

public class Main {
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
}