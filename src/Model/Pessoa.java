package Model;

public abstract class Pessoa {
    private String nome;
    private int idade;
    private String ocupacao;

    public Pessoa(String nome, String ocupacao, int idade) {
        this.nome = nome;
        this.ocupacao = ocupacao;
        this.idade = idade;
    }

    public abstract String gerarResumoDetalhado();

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    
    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }
    
    public String getOcupacao() { return ocupacao; }
    public void setOcupacao(String ocupacao) { this.ocupacao = ocupacao; }
}
