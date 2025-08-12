package Services;

import Entity.Filme;

import java.util.ArrayList;
import java.util.List;

public class ServicosFilme {
    private List<Filme> filmes = new ArrayList<>();
    private List<Ator> atores = new ArrayList<>();
    private List<Diretor> diretores = new ArrayList<>();

    // Cadastrar ou associar um novo filme
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
        }

        List<Ator> elencoAssociado = new ArrayList<>();
        for (String nome : nomesAtores) {
            Ator ator = buscarOuCriarAtor(nome);
            elencoAssociado.add(ator);
        }

        Filme filme = new Filme(titulo, dataLancamento, classificacaoIndicativa, genero,
                orcamento, descricao, diretoresAssociados.get(0), elencoAssociado, diretoresAssociados);

        filmes.add(filme);
        System.out.println("Filme cadastrado com sucesso: " + titulo);
    }

    private Diretor buscarOuCriarDiretor(String nome) {
        for (Diretor d : diretores) {
            if (d.getNome().equalsIgnoreCase(nome)) {
                return d;
            }
        }
        Diretor novo = new Diretor(nome);
        diretores.add(novo);
        return novo;
    }

    private Ator buscarOuCriarAtor(String nome) {
        for (Ator a : atores) {
            if (a.getNome().equalsIgnoreCase(nome)) {
                return a;
            }
        }
        Ator novo = new Ator(nome);
        atores.add(novo);
        return novo;
    }

    public void visualizarFilmes() {
        if (filmes.isEmpty()) {
            System.out.println("Nenhum filme cadastrado.");
            return;
        }
        for (Filme filme : filmes) {
            System.out.println(filme);
        }
    }
}
