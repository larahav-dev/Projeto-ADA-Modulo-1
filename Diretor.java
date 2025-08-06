import java.util.Date;
import java.util.ArrayList;

public class Diretor extends Pessoa {
    private ArrayList<String> filmesDirigidos;
        private String nomeDiretor;

    public Diretor(String nomediretor, Date idade, String nacionalidade, boolean genero) {
        // chama o construtor da superclasse Pessoa
        super(genero, idade, nacionalidade);
        this.filmesDirigidos = new ArrayList<>() ;
            this.nomeDiretor = nomediretor;
    }

    public String getNomeDiretor () {
        return nomeDiretor;

    }


    public ArrayList<String> getFilmesDirigidos() {
        return filmesDirigidos;
    }

    public void adicionarFilme(String nomeFilme) {
        if (!filmesDirigidos.contains(nomeFilme)) {
            filmesDirigidos.add(nomeFilme);
        }
    }

    @Override
    public void exibirInfo() {
        System.out.println("Diretor: " + nomeDiretor);
        System.out.println("Idade: " + idade);
        System.out.println("Nacionalidade: " + nacionalidade);
                System.out.println("Filmes dirigidos: " + filmesDirigidos);

        System.out.println("Filmes dirigidos: " + filmesDirigidos);
    }

    @Override
    public String toString() {
        return "Diretor: " + nomeDiretor + "\nFilmes dirigidos: " + filmesDirigidos + "\n";
    }

    @Override
    public boolean equals(Object obj) {
        //Verifica se é o mesmo objeto em memória
        if (this == obj) return true;
        if (!(obj instanceof Diretor)) return false;
        Diretor outro = (Diretor) obj;
        return nomeDiretor.equalsIgnoreCase(outro.nomeDiretor);
        //esse trecho serve para ignorar as diferensas entre maiuscula, e minuscula
    }

        // Gera o hash com base no nomeDiretor em letras minúsculas, no caso o hash faz a busca de objetos
    @Override
    public int hashCode() {
        return nomeDiretor.toLowerCase().hashCode();
    }
}
 