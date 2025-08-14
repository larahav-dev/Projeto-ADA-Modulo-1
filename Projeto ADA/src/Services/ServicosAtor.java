package Services;

import Entity.Ator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ServicosAtor {

    // Lista interna de atores
    private final List<Ator> atores = new ArrayList<>();

    /**
     * Cadastra um novo ator, prevenindo duplicatas pelo equals().
     * @param ator instância de Ator a ser cadastrada
     * @return true se o cadastro foi bem-sucedido, false se for nulo ou duplicado
     */
    public boolean cadastrarAtor(Ator ator) {
        if (ator == null) {
            System.out.println("❌ Ator inválido.");
            return false;
        }

        // Evita duplicatas
        if (atores.stream().anyMatch(a -> a.equals(ator))) {
            System.out.println("⚠ Ator já cadastrado: " + ator.getNome());
            return false;
        }

        atores.add(ator);
        return true;
    }

    /**
     * Retorna uma cópia da lista de atores para exibição no menu.
     */
    public List<Ator> listarAtores() {
        return new ArrayList<>(atores); // cópia defensiva
    }

    /**
     * Busca um ator pelo nome (ignora maiúsculas/minúsculas e espaços extras)
     * @param nome nome do ator a buscar
     * @return Optional contendo o ator encontrado, ou vazio se não existir
     */
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
