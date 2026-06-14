package Model;

import Interface.Exibivel;
import Interface.Investigavel;

import java.io.Serializable;
import java.util.ArrayList;

public class Caso implements Exibivel, Investigavel, Serializable {

    private static final long serialVersionUID = 1L;

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

        if(investigadores != null) {
            this.investigadores = investigadores;
        } else {
            this.investigadores = new ArrayList<>();
        }

        this.suspeitos = new ArrayList<>();
        this.pistas = new ArrayList<>();
    }

    public Caso(int id, String titulo, Investigador investigador) {

        this(
                id,
                titulo,
                "Sem descrição",
                "Não informado",
                "Não informada",
                "Aberto",
                new ArrayList<>()
        );

        if (investigador != null) {
            this.investigadores.add(investigador);
        }
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

    public ArrayList<Suspeito> getSuspeitos() {
        return suspeitos;
    }

    public ArrayList<Pista> getPistas() {
        return pistas;
    }

    public void adicionarInvestigador(Investigador investigador) {
        if (investigador != null) {
            investigadores.add(investigador);
        }
    }

    public boolean removerInvestigador(int idInvestigador) {
        for (int i = 0; i < investigadores.size(); i++) {
            if (investigadores.get(i).getId() == idInvestigador) {
                investigadores.remove(i);
                return true;
            }
        }
        return false;
    }

    public Investigador getInvestigadorAlocado() {
        if (!investigadores.isEmpty()) {
            return investigadores.get(0);
        }
        return null;
    }

    public void adicionarSuspeito(Suspeito suspeito) {
        if (suspeito != null) {
            suspeitos.add(suspeito);
        }
    }

    public boolean removerSuspeito(int idSuspeito) {
        for (int i = 0; i < suspeitos.size(); i++) {
            if (suspeitos.get(i).getId() == idSuspeito) {
                suspeitos.remove(i);
                return true;
            }
        }
        return false;
    }

    public void adicionarPista(Pista pista) {

        if (pista != null) {
            pistas.add(pista);
        }
    }

    public void adicionarPista(int id, String descricao, String localEncontrada) {
        pistas.add(new Pista(id, descricao, localEncontrada));
    }

    public boolean removerPista(int idPista) {
        for (int i = 0; i < pistas.size(); i++) {
            if (pistas.get(i).getId() == idPista) {
                pistas.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public String exibirResumo() {
        return "ID: " + id +
                " | Título: " + titulo +
                " | Status: " + status;
    }

    public void mostrarInfo() {
        System.out.println("\n==============================");
        System.out.println("CASO ID: " + id);
        System.out.println("Título: " + titulo);
        System.out.println("Descrição: " + descricao);
        System.out.println("Local do Crime: " + localCrime);
        System.out.println("Data do Crime: " + dataCrime);
        System.out.println("Status: " + status);

        System.out.println("\nInvestigadores:");
        if (investigadores.isEmpty()) {
            System.out.println("Nenhum investigador vinculado.");
        } else {
            for (Investigador i : investigadores) {
                System.out.println("- " + i);
            }
        }

        System.out.println("\nSuspeitos:");
        if (suspeitos.isEmpty()) {
            System.out.println("Nenhum suspeito vinculado.");
        } else {
            for (Suspeito s : suspeitos) {
                System.out.println("- " + s);
            }
        }

        System.out.println("\nPistas:");
        if (pistas.isEmpty()) {
            System.out.println("Nenhuma pista cadastrada.");
        } else {
            for (Pista p : pistas) {
                System.out.println("- " + p);
            }
        }
        System.out.println("==============================");
    }

    @Override
    public String gerarRelatorioInvestigacao() {

        return "Caso: " + titulo +
                "\nDescrição: " + descricao +
                "\nLocal: " + localCrime +
                "\nData: " + dataCrime +
                "\nStatus: " + status +
                "\nQuantidade de Suspeitos: " + suspeitos.size() +
                "\nQuantidade de Pistas: " + pistas.size();
    }

    @Override
    public String toString() {

        return exibirResumo();
    }
}