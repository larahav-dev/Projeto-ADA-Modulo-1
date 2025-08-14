package Entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Diretor extends Pessoa {

    private final List<String> filmesDirigidos;

    public Diretor(String nome, boolean genero, LocalDate dataNascimento, String nacionalidade) {
        super(nome, genero, dataNascimento, nacionalidade);
        this.filmesDirigidos = new ArrayList<>();
    }

    public List<String> getFilmesDirigidos() {
        return new ArrayList<>(filmesDirigidos);
    }

    public void adicionarFilme(String nomeFilme) {
        if (nomeFilme != null && !nomeFilme.isBlank() && !filmesDirigidos.contains(nomeFilme)) {
            filmesDirigidos.add(nomeFilme);
        }
    }

    @Override
    public void exibirInfo() {
        System.out.println("Diretor: " + nome);
        System.out.println("Gênero: " + (genero ? "Masculino" : "Feminino"));
        System.out.println("Data de Nascimento: " + (dataNascimento != null ? dataNascimento : "Não informada"));
        System.out.println("Idade: " + getIdadeAnos().map(i -> i + " anos").orElse("Não informada"));
        System.out.println("Nacionalidade: " + nacionalidade);
        System.out.println("Filmes dirigidos: " + (filmesDirigidos.isEmpty() ? "Nenhum" : filmesDirigidos));
    }

    @Override
    public String toString() {
        String dataStr = (dataNascimento != null) ? dataNascimento.toString() : "Não informada";
        return String.format(
                "Diretor{nome='%s', genero=%s, dataNascimento=%s, nacionalidade='%s', filmesDirigidos=%s}",
                nome,
                genero ? "Masculino" : "Feminino",
                dataStr,
                nacionalidade,
                filmesDirigidos.isEmpty() ? "Nenhum" : filmesDirigidos
        );
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Diretor)) return false;
        if (!super.equals(obj)) return false;
        Diretor outro = (Diretor) obj;
        return Objects.equals(filmesDirigidos, outro.filmesDirigidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), filmesDirigidos);
    }
}

