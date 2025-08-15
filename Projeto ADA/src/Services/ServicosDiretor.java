package Services;

import Entity.Diretor;
import java.util.*;

public class ServicosDiretor {

    private final List<Diretor> diretores; // lista compartilhada

    public ServicosDiretor(List<Diretor> diretores) {
        this.diretores = diretores;
    }

    public boolean cadastrarDiretor(Diretor diretor) {
        if (diretor == null) return false;

        if (diretores.stream().anyMatch(d -> d.equals(diretor))) {
            System.out.println("⚠ Diretor já cadastrado: " + diretor.getNome());
            return false;
        }

        diretores.add(diretor);
        return true;
    }

    public boolean cadastrarDiretor(Diretor diretor, String tituloFilme, ServicosFilme servicosFilme) {
        if (!cadastrarDiretor(diretor)) {
            return false;
        }

        if (tituloFilme != null && !tituloFilme.isBlank()) {
            servicosFilme.buscarPorTitulo(tituloFilme)
                    .ifPresentOrElse(
                            filme -> diretor.adicionarFilme(filme.getTitulo()),
                            () -> System.out.println("ℹ Filme '" + tituloFilme + "' não encontrado. Diretor cadastrado sem vínculo.")
                    );
        }

        return true;
    }

    public List<Diretor> listarDiretores() {
        return new ArrayList<>(diretores);
    }

    public Optional<Diretor> visualizarDiretorPorNome(String nome) {
        if (nome == null || nome.isBlank()) return Optional.empty();

        return diretores.stream()
                .filter(d -> d.getNome().equalsIgnoreCase(nome.trim()))
                .findFirst();
    }
}
