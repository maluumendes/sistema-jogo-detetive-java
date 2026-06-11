package Model;

public class Suspeito extends Pessoa{
    private String alibi;
    private String relacaoComVitima;
    private boolean possuiAntecendentes;

    public Suspeito(String nome, String ocupacao, int idade, String alibi, String relacaoComVitima, boolean possuiAntecendentes) {
        super(nome, ocupacao, idade);
        this.alibi = alibi;
        this.relacaoComVitima = relacaoComVitima;
        this.possuiAntecendentes = possuiAntecendentes;
    }

    @Override
    public String gerarResumoDetalhado() {
        return "Supeito{" +
                "Nome: '" + getNome() + '\'' +
                ", Idade: " + getIdade() +
                ", Ocupação: '" + getOcupacao() + '\'' +
                ", Alibi: " + alibi + '\'' +
                ", Relação com a vítima: " + relacaoComVitima +
                ", Possui antecedentes?: '" + possuiAntecendentes + '\'' +
                '}';
    }

    public String getAlibi() {
        return alibi;
    }

    public void setAlibi(String alibi) {
        this.alibi = alibi;
    }

    public String getRelacaoComVitima() {
        return relacaoComVitima;
    }

    public void setRelacaoComVitima(String relacaoComVitima) {
        this.relacaoComVitima = relacaoComVitima;
    }

    public boolean getPossuiAntecendentes() {
        return possuiAntecendentes;
    }

    public void setPossuiAntecendentes(boolean possuiAntecendentes) {
        this.possuiAntecendentes = possuiAntecendentes;
    }
}
