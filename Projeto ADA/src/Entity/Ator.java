package Entity;

import java.time.LocalDate;
import java.util.Objects;

public class Ator extends Pessoa {

    // Construtor da subclasse chamando o construtor da superclasse Pessoa
    public Ator(String nome, boolean genero, LocalDate dataNascimento, String nacionalidade) {
        super(nome, genero, dataNascimento, nacionalidade);
    }

    @Override
    public void exibirInfo() {
        System.out.println("Ator: " + nome);
        System.out.println("Gênero: " + (genero ? "Masculino" : "Feminino"));
        System.out.println("Data de Nascimento: " + dataNascimento);
        System.out.println("Nacionalidade: " + nacionalidade);
        System.out.println("Idade: " + getIdadeAnos() + " anos");
    }

    @Override
    public String toString() {
        return String.format(
                "Ator{nome='%s', genero=%s, dataNascimento=%s, nacionalidade='%s'}",
                nome,
                genero ? "Masculino" : "Feminino",
                dataNascimento,
                nacionalidade
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ator)) return false;
        if (!super.equals(o)) return false; // Compara atributos de Pessoa
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode());
    }
}