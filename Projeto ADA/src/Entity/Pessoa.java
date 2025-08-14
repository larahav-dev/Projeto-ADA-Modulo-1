package Entity;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;
import java.util.Optional;

public abstract class Pessoa {

    protected String nome;
    protected boolean genero;            // true = Masculino, false = Feminino
    protected LocalDate dataNascimento;  // pode ser nula (opcional)
    protected String nacionalidade;

    public Pessoa(String nome, boolean genero, LocalDate dataNascimento, String nacionalidade) {
        this.nome = Objects.requireNonNull(nome, "nome não pode ser nulo").trim();
        this.genero = genero;
        this.dataNascimento = dataNascimento; // opcional
        this.nacionalidade = Objects.requireNonNull(nacionalidade, "nacionalidade não pode ser nula").trim();
    }

    public String getNome() { return nome; }
    public boolean isMasculino() { return genero; }
    public LocalDate getDataNascimento() { return dataNascimento; }
    public String getNacionalidade() { return nacionalidade; }

    // Retorna a idade se houver data; caso contrário, Optional.empty()
    public Optional<Integer> getIdadeAnos() {
        if (dataNascimento == null) return Optional.empty();
        return Optional.of(Period.between(dataNascimento, LocalDate.now()).getYears());
    }

    public void setNome(String nome) { this.nome = Objects.requireNonNull(nome).trim(); }
    public void setGenero(boolean genero) { this.genero = genero; }
    public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento; } // agora aceita null
    public void setNacionalidade(String nacionalidade) { this.nacionalidade = Objects.requireNonNull(nacionalidade).trim(); }

    public abstract void exibirInfo();

    @Override
    public String toString() {
        String dataStr = (dataNascimento != null) ? dataNascimento.toString() : "Não informada";
        return "Nome: " + nome +
                ", Gênero: " + (genero ? "Masculino" : "Feminino") +
                ", Data de Nascimento: " + dataStr +
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
