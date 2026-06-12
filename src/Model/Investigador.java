package Model;

public class Investigador extends Pessoa {
    private int id;
    private int limiteCasosSimultaneos;
    private int casosAtivosAtuais;
    private String metodoInvestigacao;
    private String itemDeInvestigacaoFavorito;

    public Investigador(int id, String nome, String ocupacao, int idade, int limiteCasosSimultaneos, int casosAtivosAtuais, String metodoInvestigacao, String itemDeInvestigacaoFavorito) {
        super(nome, ocupacao, idade);
        this.id = id;
        this.limiteCasosSimultaneos = limiteCasosSimultaneos;
        this.casosAtivosAtuais = casosAtivosAtuais;
        this.metodoInvestigacao = metodoInvestigacao;
        this.itemDeInvestigacaoFavorito = itemDeInvestigacaoFavorito;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getLimiteCasosSimultaneos() { return limiteCasosSimultaneos; }
    public void setLimiteCasosSimultaneos(int limite) { this.limiteCasosSimultaneos = limite; }

    public int getCasosAtivosAtuais() { return casosAtivosAtuais; }
    public void setCasosAtivosAtuais(int ativos) { this.casosAtivosAtuais = ativos; }

    public String getMetodoInvestigacao() { return metodoInvestigacao; }
    public void setMetodoInvestigacao(String metodo) { this.metodoInvestigacao = metodo; }

    public String getItemDeInvestigacaoFavorito() { return itemDeInvestigacaoFavorito; }
    public void setItemDeInvestigacaoFavorito(String item) { this.itemDeInvestigacaoFavorito = item; }

    public boolean podeAssumirNovoCaso() {
        return this.casosAtivosAtuais < this.limiteCasosSimultaneos;
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
        return "Investigador [ID: " + id + " | Nome: " + getNome() + " | Posto: " + getOcupacao() + 
               " | Idade: " + getIdade() + " | Casos Ativos: " + casosAtivosAtuais + "/" + limiteCasosSimultaneos + 
               " | Método: " + metodoInvestigacao + " | Item Favorito: " + itemDeInvestigacaoFavorito + "]";
    }

    @Override
    public String toString() {
        return getNome() + " (ID: " + id + ")";
    }
}
