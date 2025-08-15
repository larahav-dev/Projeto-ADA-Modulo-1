    package Service;

import Entity.Diretor;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class ServicosDiretor {

    private final Set<Diretor> diretores = new HashSet<>();

    
    public boolean cadastrarDiretor(Diretor diretor) {
        if (diretor == null || diretor.getNomeDiretor() == null || diretor.getNomeDiretor().isBlank()) {
            throw new IllegalArgumentException("Nome do diretor inválido.");
        }

        boolean adicionado = diretores.add(diretor);
        if (adicionado) {
            System.out.println("✅ Diretor cadastrado com sucesso: " + diretor.getNomeDiretor());
        } else {
            System.out.println("⚠️ Diretor já está cadastrado: " + diretor.getNomeDiretor());
        }
        return adicionado;
    }

    // Verificar se existe pelo nome
    public boolean existeDiretor(String nome) {
        return diretores.stream()
                .anyMatch(d -> d.getNomeDiretor().equalsIgnoreCase(nome));
    }

    // Buscar diretor pelo nome
    public Optional<Diretor> buscarDiretor(String nome) {
        return diretores.stream()
                .filter(d -> d.getNomeDiretor().equalsIgnoreCase(nome))
                .findFirst();
    }

    // Listar todos os diretores
    public Set<Diretor> listarDiretores() {
        return Set.copyOf(diretores);
    }
}
 