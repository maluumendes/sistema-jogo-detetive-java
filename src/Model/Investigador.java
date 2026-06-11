package Model;

public class Investigador {

    private int id;
    private String nome;
    private String cargo;
    private String departamento;

    public Investigador(int id, String nome, String cargo, String departamento) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
        this.departamento = departamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }


    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public void mostrarInfo() {
        System.out.println("\n==================");
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("Cargo: " + cargo);
        System.out.println("Departamento: " + departamento);
    }

    @Override
    public String toString() {
        return nome;
    }
}
