package Entity;

import java.time.LocalDate;
import java.util.Objects;

public class Ator extends Pessoa {

    public Ator(String nome, boolean genero, LocalDate dataNascimento, String nacionalidade) {
        super(nome, genero, dataNascimento, nacionalidade);
    }

    @Override
    public void exibirInfo() {
        System.out.println("Ator: " + nome);
        System.out.println("Gênero: " + (genero ? "Masculino" : "Feminino"));
        System.out.println("Data de Nascimento: " + (dataNascimento != null ? dataNascimento : "Não informada"));
        System.out.println("Nacionalidade: " + nacionalidade);
        System.out.println("Idade: " + getIdadeAnos().map(i -> i + " anos").orElse("Não informada"));
    }

    @Override
    public String toString() {
        String dataStr = (dataNascimento != null) ? dataNascimento.toString() : "Não informada";
        return String.format(
                "Ator{nome='%s', genero=%s, dataNascimento=%s, nacionalidade='%s'}",
                nome,
                genero ? "Masculino" : "Feminino",
                dataStr,
                nacionalidade
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ator)) return false;
        if (!super.equals(o)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode());
    }
}
