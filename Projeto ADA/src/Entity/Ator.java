package Entity;

import java.time.LocalDate;
import java.util.Objects;

public class Ator {

    private String nome;
    private LocalDate dataNascimento;
    private String nacionalidade;

    public Ator(String nome, LocalDate dataNascimento, String nacionalidade) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.nacionalidade = nacionalidade;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    // Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    @Override
    public String toString() {
        return "Ator: " +
                "nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", nacionalidade='" + nacionalidade + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ator ator = (Ator) o;
        return Objects.equals(nome, ator.nome) && Objects.equals(dataNascimento, ator.dataNascimento) && Objects.equals(nacionalidade, ator.nacionalidade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, dataNascimento, nacionalidade);
    }
}
