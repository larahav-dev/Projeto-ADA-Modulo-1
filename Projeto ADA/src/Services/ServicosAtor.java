package Services;

import Entity.Ator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ServicosAtor {

    private final List<Ator> atores; // lista compartilhada

    public ServicosAtor(List<Ator> atores) {
        this.atores = atores;
    }

    public boolean cadastrarAtor(Ator ator) {
        if (ator == null) {
            System.out.println("❌ Ator inválido.");
            return false;
        }

        if (atores.stream().anyMatch(a -> a.equals(ator))) {
            System.out.println("⚠ Ator já cadastrado: " + ator.getNome());
            return false;
        }

        atores.add(ator);
        return true;
    }

    public List<Ator> listarAtores() {
        return new ArrayList<>(atores); // cópia defensiva
    }

    public Optional<Ator> visualizarAtorPorNome(String nome) {
        if (nome == null || nome.isBlank()) {
            System.out.println("❌ Nome inválido.");
            return Optional.empty();
        }

        return atores.stream()
                .filter(a -> a.getNome().equalsIgnoreCase(nome.trim()))
                .findFirst();
    }
}