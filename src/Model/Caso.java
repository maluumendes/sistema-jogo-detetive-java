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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLocalCrime() {
        return localCrime;
    }

    public void setLocalCrime(String localCrime) {
        this.localCrime = localCrime;
    }

    public String getDataCrime() {
        return dataCrime;
    }

    public void setDataCrime(String dataCrime) {
        this.dataCrime = dataCrime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<Investigador> getInvestigadores() {
        return investigadores;
    }

    public void adicionarInvestigador(Investigador investigador){
        investigadores.add(investigador);
    }

    public ArrayList<Suspeito> getSuspeitos() {
        return suspeitos;
    }

    public void adicionarSuspeito(Suspeito suspeito){
        suspeitos.add(suspeito);
    }

    public ArrayList<Pista> getPistas() {
        return pistas;
    }

    public void adicionarPista(Pista pista){
        pistas.add(pista);
    }

    public void mostrarInfo(){
        System.out.println("\n=====================");
        System.out.println("CASO ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Descrição: " + getDescricao());
        System.out.println("Local do Crime: " + getLocalCrime());
        System.out.println("Data do Crime: " + getDataCrime());
        System.out.println("Status: " + getStatus());
        System.out.println("Investigadores: " + getInvestigadores());

        if (getSuspeitos().isEmpty()){
            System.out.println("Suspeitos: Não há suspeitos nesse caso!");
        } else {
            System.out.println("Suspeitos: " + getSuspeitos());
        }

        if (getPistas().isEmpty()){
            System.out.println("Pistas: Não há pistas nesse caso!");
        } else {
            System.out.println("Pistas: " + getPistas());
        }
    }
}
