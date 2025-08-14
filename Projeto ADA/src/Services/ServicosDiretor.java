package Services;

import Entity.Diretor;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ServicosDiretor {

    private final List<Diretor> diretores = new ArrayList<>();

    /**
     * Cadastro simples de diretor (sem filme vinculado).
     */
    public boolean cadastrarDiretor(Diretor diretor) {
        if (diretor == null) return false;

        // Evita duplicatas
        if (diretores.stream().anyMatch(d -> d.equals(diretor))) {
            System.out.println("⚠ Diretor já cadastrado: " + diretor.getNome());
            return false;
        }

        diretores.add(diretor);
        return true;
    }

    /**
     * Cadastro com possível vínculo de filme.
     * Se o títuloFilme for nulo ou não existir no catálogo, apenas cadastra o diretor.
     */
    public boolean cadastrarDiretor(Diretor diretor, String tituloFilme, ServicosFilme servicosFilme) {
        if (!cadastrarDiretor(diretor)) {
            return false; // já cadastrado ou inválido
        }

        if (tituloFilme != null && !tituloFilme.isBlank()) {
            servicosFilme.buscarFilmePorTitulo(tituloFilme)
                    .ifPresentOrElse(
                            filme -> diretor.adicionarFilme(filme.getTitulo()),
                            () -> System.out.println("ℹ Filme '" + tituloFilme + "' não encontrado. Diretor cadastrado sem vínculo.")
                    );
        }

        return true;
    }

    public List<Diretor> listarDiretores() {
        return new ArrayList<>(diretores); // cópia defensiva
    }

    public Optional<Diretor> visualizarDiretorPorNome(String nome) {
        if (nome == null || nome.isBlank()) return Optional.empty();

        return diretores.stream()
                .filter(d -> d.getNome().equalsIgnoreCase(nome.trim()))
                .findFirst();
    }
}
