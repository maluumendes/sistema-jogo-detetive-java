package Model;

public class Pista {
    private int id;
    private String descricao;
    private String localEncontrada;

    public Pista(int id, String descricao, String localEncontrada) {
        this.id = id;
        this.descricao = descricao;
        this.localEncontrada = localEncontrada;
    }

    public int getId() { return id; }
    public String getDescricao() { return descricao; }
    public String getLocalEncontrada() { return localEncontrada; }

    public void setDescricao(String descricao) { this.descricao = descricao; }
    public void setLocalEncontrada(String localEncontrada) { this.localEncontrada = localEncontrada; }

    @Override
    public String toString() {
        return "ID: " + id + " | Descrição: " + descricao + " | Local: " + localEncontrada;
    }
}
