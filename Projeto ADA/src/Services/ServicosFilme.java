package Services;

import Entity.Ator;
import Entity.Diretor;
import Entity.Filme;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ServicosFilme {

    private final List<Filme> filmes = new ArrayList<>();
    private final List<Ator> atores = new ArrayList<>();
    private final List<Diretor> diretores = new ArrayList<>();

    private final Scanner scanner = new Scanner(System.in);

    public void cadastrarFilme(String titulo,
                               LocalDate dataLancamento,
                               String classificacaoIndicativa,
                               String genero,
                               double orcamento,
                               String descricao,
                               List<String> nomesDiretores,
                               List<String> nomesAtores) {

        List<Diretor> diretoresAssociados = new ArrayList<>();
        for (String nome : nomesDiretores) {
            Diretor diretor = buscarOuCriarDiretor(nome);
            diretoresAssociados.add(diretor);
            diretor.adicionarFilme(titulo);
        }

        List<Ator> elencoAssociado = new ArrayList<>();
        for (String nome : nomesAtores) {
            Ator ator = buscarOuCriarAtor(nome);
            elencoAssociado.add(ator);
        }

        Filme filme = new Filme(
                titulo,
                dataLancamento,
                classificacaoIndicativa,
                genero,
                orcamento,
                descricao,
                diretoresAssociados.get(0), // diretor principal
                elencoAssociado,
                diretoresAssociados
        );

        filmes.add(filme);
        System.out.println("✅ Filme cadastrado com sucesso: " + titulo);
    }

    private Diretor buscarOuCriarDiretor(String nome) {
        Optional<Diretor> existente = diretores.stream()
                .filter(d -> d.getNome().equalsIgnoreCase(nome))
                .findFirst();

        if (existente.isPresent()) return existente.get();

        System.out.println("\n🔹 Diretor '" + nome + "' não encontrado. Vamos cadastrá-lo!");
        boolean genero = lerGenero("Gênero (M/F): ");
        LocalDate nascimento = lerDataOpcional("Data de Nascimento (dd/MM/yyyy) [opcional]: ");
        System.out.print("Nacionalidade: ");
        String nacionalidade = scanner.nextLine();

        Diretor novo = new Diretor(nome, genero, nascimento, nacionalidade);
        diretores.add(novo);
        return novo;
    }

    private Ator buscarOuCriarAtor(String nome) {
        Optional<Ator> existente = atores.stream()
                .filter(a -> a.getNome().equalsIgnoreCase(nome))
                .findFirst();

        if (existente.isPresent()) return existente.get();

        System.out.println("\n🔹 Ator '" + nome + "' não encontrado. Vamos cadastrá-lo!");
        boolean genero = lerGenero("Gênero (M/F): ");
        LocalDate nascimento = lerDataOpcional("Data de Nascimento (dd/MM/yyyy) [opcional]: ");
        System.out.print("Nacionalidade: ");
        String nacionalidade = scanner.nextLine();

        Ator novo = new Ator(nome, genero, nascimento, nacionalidade);
        atores.add(novo);
        return novo;
    }

    // ===== Helpers para leitura =====
    private LocalDate lerDataOpcional(String prompt) {
        System.out.print(prompt);
        String data = scanner.nextLine().trim();
        if (data.isEmpty()) return null;
        try {
            return LocalDate.parse(data, java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        } catch (Exception e) {
            System.out.println("⚠ Data inválida. Mantendo sem data.");
            return null;
        }
    }

    private boolean lerGenero(String prompt) {
        while (true) {
            System.out.print(prompt);
            String g = scanner.nextLine().trim().toUpperCase();
            if (g.equals("M")) return true;
            if (g.equals("F")) return false;
            System.out.println("Digite apenas M ou F.");
        }
    }

    public void visualizarFilmes() {
        if (filmes.isEmpty()) {
            System.out.println("Nenhum filme cadastrado.");
            return;
        }
        filmes.forEach(System.out::println);
    }

    public Optional<Filme> buscarPorTitulo(String titulo) {
        return filmes.stream()
                .filter(f -> f.getTitulo().equalsIgnoreCase(titulo))
                .findFirst();
    }
}
