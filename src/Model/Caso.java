package Model;

import java.util.ArrayList;

public class Caso {
    private int id;
    private String titulo;
    private String descricao;
    private String localCrime;
    private String dataCrime;
    private String status;

    private ArrayList<Investigador> investigadores;
    private ArrayList<Suspeito> suspeitos;
    private ArrayList<Pista> pistas;

    public Caso(int id, String titulo, String descricao, String localCrime, String dataCrime, String status, ArrayList<Investigador> investigadores) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.localCrime = localCrime;
        this.dataCrime = dataCrime;
        this.status = status;
        this.investigadores = investigadores;
        this.suspeitos = new ArrayList<>();
        this.pistas = new ArrayList<>();
    }

    // Construtor alternativo para compatibilidade dinâmica de vínculos simples
    public Caso(int id, String titulo, Investigador investigador) {
        this(id, titulo, "Sem descrição.", "Não informado.", "Não informada.", "Aberto", new ArrayList<>());
        if (investigador != null) {
            this.investigadores.add(investigador);
        }
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getLocalCrime() { return localCrime; }
    public void setLocalCrime(String localCrime) { this.localCrime = localCrime; }

    public String getDataCrime() { return dataCrime; }
    public void setDataCrime(String dataCrime) { this.dataCrime = dataCrime; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public ArrayList<Investigador> getInvestigadores() { return investigadores; }
    public void adicionarInvestigador(Investigador investigador) { investigadores.add(investigador); }

    public ArrayList<Suspeito> getSuspeitos() { return suspeitos; }
    public void adicionarSuspeito(Suspeito suspeito) { suspeitos.add(suspeito); }

    public ArrayList<Pista> getPistas() { return pistas; }
    public void adicionarPista(Pista pista) { pistas.add(pista); }

    public void mostrarInfo() {
        System.out.println("\n=====================");
        System.out.println("CASO ID: " + id);
        System.out.println("Título: " + titulo);
        System.out.println("Descrição: " + descricao);
        System.out.println("Local do Crime: " + localCrime);
        System.out.println("Data do Crime: " + dataCrime);
        System.out.println("Status: " + status);
        System.out.println("Investigadores alocados: " + investigadores);
    }
}
