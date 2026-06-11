package Controller;

import Model.Investigador;
import Persistence.InvestigadorPersistencia;

import java.util.ArrayList;

public class InvestigadorController {

    private ArrayList<Investigador> investigadores = new ArrayList<>();

    private InvestigadorPersistencia persistencia =
            new InvestigadorPersistencia();

    public void validarId(int id) throws Exception{

        if(buscarInvestigador(id) != null){
            throw new Exception("Já existe investigador com esse ID.");
        }
    }

    public void cadastrarInvestigador(
            int id,
            String nome,
            String cargo,
            String departamento){

        investigadores.add(
                new Investigador(
                        id,
                        nome,
                        cargo,
                        departamento
                )
        );

        persistencia.salvar(investigadores);
    }

    public ArrayList<Investigador> listarInvestigadores(){
        return investigadores;
    }

    public Investigador buscarInvestigador(int id){

        for(Investigador i : investigadores){

            if(i.getId() == id){
                return i;
            }
        }

        return null;
    }

    public boolean editarNome(int id, String novoNome){

        Investigador i = buscarInvestigador(id);

        if(i != null){
            i.setNome(novoNome);
            persistencia.salvar(investigadores);
            return true;
        }

        return false;
    }

    public boolean editarCargo(int id, String novoCargo){

        Investigador i = buscarInvestigador(id);

        if(i != null){
            i.setCargo(novoCargo);
            persistencia.salvar(investigadores);
            return true;
        }

        return false;
    }

    public boolean editarDepartamento(int id,
                                      String novoDepartamento){

        Investigador i = buscarInvestigador(id);

        if(i != null){
            i.setDepartamento(novoDepartamento);
            persistencia.salvar(investigadores);
            return true;
        }

        return false;
    }

    public boolean removerInvestigador(int id){

        for(int i = 0; i < investigadores.size(); i++){

            if(investigadores.get(i).getId() == id){

                investigadores.remove(i);

                persistencia.salvar(investigadores);

                return true;
            }
        }

        return false;
    }
}
