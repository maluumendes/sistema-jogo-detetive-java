package Model;

public class Suspeito extends Pessoa {
    private int id;
    private String alibi;
    private String relacaoComVitima;
    private boolean possuiAntecedentes;

    public Suspeito(int id, String nome, String ocupacao, int idade, String alibi, String relacaoComVitima, boolean possuiAntecedentes) {
        super(nome, ocupacao, idade);
        this.id = id;
        this.alibi = alibi;
        this.relacaoComVitima = relacaoComVitima;
        this.possuiAntecedentes = possuiAntecedentes;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getAlibi() { return alibi; }
    public void setAlibi(String alibi) { this.alibi = alibi; }

    public String getRelacaoComVitima() { return relacaoComVitima; }
    public void setRelacaoComVitima(String relacao) { this.relacaoComVitima = relacao; }

    public boolean isPossuiAntecedentes() { return possuiAntecedentes; }
    public void setPossuiAntecedentes(boolean antecedentes) { this.possuiAntecedentes = antecedentes; }

    @Override
    public String gerarResumoDetalhado() {
        return "Suspeito [ID: " + id + " | Nome: " + getNome() + " | Idade: " + getIdade() + 
               " | Ocupação: " + getOcupacao() + " | Álibi: " + alibi + 
               " | Relação com Vítima: " + relacaoComVitima + " | Antecedentes: " + possuiAntecedentes + "]";
    }
}
