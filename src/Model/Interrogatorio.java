package Model;

import Interface.Exibivel;

import java.io.Serializable;

public class Interrogatorio implements Exibivel, Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private int idCaso;
    private int idInvestigador;
    private int idSuspeito;
    private String data;
    private String depoimento;

    public Interrogatorio(
            int id,
            int idCaso,
            int idInvestigador,
            int idSuspeito,
            String data,
            String depoimento) {

        this.id = id;
        this.idCaso = idCaso;
        this.idInvestigador = idInvestigador;
        this.idSuspeito = idSuspeito;
        this.data = data;
        this.depoimento = depoimento;
    }

    public int getId() {
        return id;
    }

    public int getIdCaso() {
        return idCaso;
    }

    public int getIdInvestigador() {
        return idInvestigador;
    }

    public int getIdSuspeito() {
        return idSuspeito;
    }

    public String getData() {
        return data;
    }

    public String getDepoimento() {
        return depoimento;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdCaso(int idCaso) {
        this.idCaso = idCaso;
    }

    public void setIdInvestigador(int idInvestigador) {
        this.idInvestigador = idInvestigador;
    }

    public void setIdSuspeito(int idSuspeito) {
        this.idSuspeito = idSuspeito;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setDepoimento(String depoimento) {
        this.depoimento = depoimento;
    }

    @Override
    public String exibirResumo() {

        return "ID: " + id +
                " | Caso: " + idCaso +
                " | Data: " + data;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                " | Caso: " + idCaso +
                " | Investigador: " + idInvestigador +
                " | Suspeito: " + idSuspeito;
    }
}