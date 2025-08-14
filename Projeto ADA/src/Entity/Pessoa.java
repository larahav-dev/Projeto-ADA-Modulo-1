package Entity;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

// Classe abstrata base para Ator, Diretor, etc.
public abstract class Pessoa {

    // Atributos comuns
    protected String nome;
    protected boolean genero;            // true = Masculino, false = Feminino
    protected LocalDate dataNascimento;
    protected String nacionalidade;

    // Construtor
    public Pessoa(String nome, boolean genero, LocalDate dataNascimento, String nacionalidade) {
        this.nome = Objects.requireNonNull(nome, "nome não pode ser nulo").trim();
        this.genero = genero;
        this.dataNascimento = Objects.requireNonNull(dataNascimento, "dataNascimento não pode ser nula");
        this.nacionalidade = Objects.requireNonNull(nacionalidade, "nacionalidade não pode ser nula").trim();
    }

    // Getters
    public String getNome() {
        return nome;
    }

    // isMasculino() retorna true se o gênero for masculino.
    public boolean isMasculino() {
        return genero;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    // Conveniência: Calcula automaticamente a idade com base na data de nascimento. Usa Period para considerar anos completos.
    public int getIdadeAnos() {
        return Period.between(dataNascimento, LocalDate.now()).getYears();
    }

    // Setters
    public void setNome(String nome) {
        this.nome = Objects.requireNonNull(nome).trim();
    }

    public void setGenero(boolean genero) {
        this.genero = genero;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = Objects.requireNonNull(dataNascimento);
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = Objects.requireNonNull(nacionalidade).trim();
    }

    // Método que as subclasses precisam implementar
    public abstract void exibirInfo();

    @Override
    public String toString() {
        return "Nome: " + nome +
                ", Gênero: " + (genero ? "Masculino" : "Feminino") +
                ", Data de Nascimento: " + dataNascimento +
                ", Nacionalidade: " + nacionalidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pessoa)) return false;
        Pessoa pessoa = (Pessoa) o;
        return genero == pessoa.genero &&
                Objects.equals(nome, pessoa.nome) &&
                Objects.equals(dataNascimento, pessoa.dataNascimento) &&
                Objects.equals(nacionalidade, pessoa.nacionalidade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, genero, dataNascimento, nacionalidade);
    }
}
