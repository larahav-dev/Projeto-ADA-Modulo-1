package Services;

import Entity.Diretor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ServicosDiretor {

    private final List<Diretor> diretores = new ArrayList<>();

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
