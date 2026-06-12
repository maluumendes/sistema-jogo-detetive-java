package Model;

public class Investigador extends Pessoa {
    private int id;
    private String cargo;
    private String departamento;
    private int limiteCasosSimultaneos;
    private int casosAtivosAtuais;
    private String metodoInvestigacao;
    private String itemDeInvestigacaoFavorito;

    public Investigador(int id, String nome, String cargo, String departamento) {
        super(nome, cargo, 35); 
        this.id = id;
        this.cargo = cargo;
        this.departamento = departamento;
        this.limiteCasosSimultaneos = 3;
        this.casosAtivosAtuais = 0;
        this.metodoInvestigacao = "Dedução Lógica";
        this.itemDeInvestigacaoFavorito = "Lupa";
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }

    public String getDepartamento() { return departamento; }
    public void setDepartamento(String departamento) { this.departamento = departamento; }

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
        return "Investigador [ID: " + id + " | Nome: " + getNome() + " | Cargo: " + cargo + 
               " | Dept: " + departamento + " | Casos Ativos: " + casosAtivosAtuais + "/" + limiteCasosSimultaneos + "]";
    }

    @Override
    public String toString() {
        return getNome() + " (ID: " + id + ")";
    }
}
