package Model;

public class Investigador extends Pessoa{

    private int limiteCasosSimultaneos;
    private int casosAtivosAtuais;
    private String metodoInvestigacao;
    private String itemDeInvestigacaoFavorito;

    public Investigador(String nome, String ocupacao, int idade, int limiteCasosSimultaneos, int casosAtivosAtuais, String metodoInvestigacao, String itemDeInvestigacaoFavorito ) {
        super(nome, ocupacao, idade);
        this.limiteCasosSimultaneos = limiteCasosSimultaneos;
        this.casosAtivosAtuais = 0;
        this.metodoInvestigacao = metodoInvestigacao;
        this.itemDeInvestigacaoFavorito = itemDeInvestigacaoFavorito;
    }

    public boolean podeAssumirNovoCaso() {
        if (this.casosAtivosAtuais < this.limiteCasosSimultaneos) {
            return true;
        } else {
            return false;
        }
    }

    public void alocarAoCaso() {
        if (podeAssumirNovoCaso()) {
            this.casosAtivosAtuais++;
        }
    }

    public void desvincularDoCaso() {
        if (this.casosAtivosAtuais > 0) {
            this.casosAtivosAtuais--;
        }
    }

    @Override
    public String gerarResumoDetalhado() {
        return "Investigador{" +
                "Nome: '" + getNome() + '\'' +
                ", Idade: " + getIdade() +
                ", Ocupação: '" + getOcupacao() + '\'' +
                ", Limite de Casos: " + limiteCasosSimultaneos +
                ", Casos Ativos: " + casosAtivosAtuais +
                ", Método: '" + metodoInvestigacao + '\'' +
                ", Item Favorito: '" + itemDeInvestigacaoFavorito + '\'' +
                '}';
    }

    public String getItemDeInvestigacaoFavorito() {
        return itemDeInvestigacaoFavorito;
    }

    public void setItemDeInvestigacaoFavorito(String itemDeInvestigacaoFavorito) {
        this.itemDeInvestigacaoFavorito = itemDeInvestigacaoFavorito;
    }

    public String getMetodoInvestigacao() {
        return metodoInvestigacao;
    }

    public void setMetodoInvestigacao(String metodoInvestigacao) {
        this.metodoInvestigacao = metodoInvestigacao;
    }

    public int getCasosAtivosAtuais() {
        return casosAtivosAtuais;
    }

    public void setCasosAtivosAtuais(int casosAtivosAtuais) {
        this.casosAtivosAtuais = casosAtivosAtuais;
    }

    public int getLimiteCasosSimultaneos() {
        return limiteCasosSimultaneos;
    }

    public void setLimiteCasosSimultaneos(int limiteCasosSimultaneos) {
        this.limiteCasosSimultaneos = limiteCasosSimultaneos;
    }
}
