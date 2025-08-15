package Entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Filme {
    private String titulo;
    private String classificacaoIndicativa;
    private String genero;
    private LocalDate dataLancamento;
    private String duracao;
    private double orcamento;
    private String descricao;
    private List<Diretor> diretores;
    private List<Ator> elenco;
    private static final DateTimeFormatter FORMATO_DATA =
            DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Filme(String titulo,
                 LocalDate dataLancamento,
                 String classificacaoIndicativa,
                 String genero,
                 double orcamento,
                 String descricao,
                 Diretor diretorPrincipal,
                 List<Ator> elenco,
                 List<Diretor> diretores) {
        this.titulo = titulo;
        this.dataLancamento = dataLancamento;
        this.classificacaoIndicativa = classificacaoIndicativa;
        this.genero = genero;
        this.orcamento = orcamento;
        this.descricao = descricao;
        this.diretores = diretores;
        this.elenco = elenco;
    }

    public String getTitulo() {
        return titulo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("🎬 Filme: ").append(titulo)
                .append(String.format("%n📅 Lançamento: %s", dataLancamento.format(FORMATO_DATA)))
                .append(String.format("%n🎞️ Gênero: %s", genero))
                .append(String.format("%n🔞 Classificação: %s", classificacaoIndicativa))
                .append(String.format("%n💰 Orçamento: R$ %.2f", orcamento))
                .append(String.format("%n📝 Descrição: %s", descricao));

        sb.append(String.format("%n🎬 Diretores:"));
        for (Diretor diretor : diretores) {
            sb.append(String.format("%n  - %s", diretor.getNome()));
        }

        sb.append(String.format("%n🎭 Elenco:"));
        for (Ator ator : elenco) {
            sb.append(String.format("%n  - %s", ator.getNome()));
        }

        return sb.toString();
    }
}
