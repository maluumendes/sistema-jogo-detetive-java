package model;

public class Interrogatorio {
    private int id;
    private int idCaso;
    private int idInvestigador;
    private int idSuspeito;
    private String data;
    private String depoimento;

    public Interrogatorio(int id, int idCaso, int idInvestigador, int idSuspeito, String data, String depoimento) {
        this.id = id;
        this.idCaso = idCaso;
        this.idInvestigador = idInvestigador;
        this.idSuspeito = idSuspeito;
        this.data = data;
        this.depoimento = depoimento;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getIdCaso() { return idCaso; }
    public void setIdCaso(int idCaso) { this.idCaso = idCaso; }
    public int getIdInvestigador() { return idInvestigador; }
    public void setIdInvestigador(int idInvestigador) { this.idInvestigador = idInvestigador; }
    public int getIdSuspeito() { return idSuspeito; }
    public void setIdSuspeito(int idSuspeito) { this.idSuspeito = idSuspeito; }
    public String getData() { return data; }
    public void setData(String data) { this.data = data; }
    public String getDepoimento() { return depoimento; }
    public void setDepoimento(String depoimento) { this.depoimento = depoimento; }

    @Override
    public String toString() {
        return id + ";" + idCaso + ";" + idInvestigador + ";" + idSuspeito + ";" + data + ";" + depoimento;
    }
}
