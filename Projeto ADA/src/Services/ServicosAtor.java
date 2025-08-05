package Services;

import Entity.Ator;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ServicosAtor {

    private final List<Ator> atores = new ArrayList<>();

    public boolean cadastrarAtor(Ator ator) {
        if (ator == null) {
            return false;
        }
        return this.atores.add(ator);
    }

    public List<Ator> listarAtores() {
        return new ArrayList<>(this.atores);
    }

    public Optional<Ator> visualizarAtorPorNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            return Optional.empty();
        }

        for (Ator ator : atores) {
            if (ator.getNome().equalsIgnoreCase(nome.trim())) {
                return Optional.of(ator);
            }
        }
        return Optional.empty();
    }
}
