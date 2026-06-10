package Controller;

import Model.Caso;
import Model.Investigador;
import Model.Pista;
import Model.Suspeito;
import Persistence.CasoPersistencia;

import java.util.ArrayList;

public class CasoController {

    private ArrayList<Caso> casos = new ArrayList<>();
    private CasoPersistencia persistencia = new CasoPersistencia();

    public void validarId(int id) throws Exception{

        if (buscarCaso(id) != null){
            throw new Exception("Já existe um caso com esse ID.");
        }
    }

    public void adicionarCaso(int id, String titulo, String descricao, String localCrime, String dataCrime, String status, ArrayList<Investigador> investigadores){
        casos.add(new Caso(id, titulo, descricao, localCrime, dataCrime, status, investigadores));

        persistencia.salvar(casos);
    }

    public ArrayList<Caso> listarCaso(){
        return casos;
    }

    public Caso buscarCaso(int id){

        for (Caso c : casos){
            if (c.getId() == id){
                return c;
            }
        }

        return null;
    }

    public boolean editarTitulo(int id, String novoTitulo){
        Caso c = buscarCaso(id);

        if (c != null){
            c.setTitulo(novoTitulo);
            persistencia.salvar(casos);
            return true;
        }
        return false;
    }

    public boolean editarDescricao(int id, String novaDesc){
        Caso c = buscarCaso(id);

        if (c != null){
            c.setDescricao(novaDesc);
            persistencia.salvar(casos);
            return true;
        }
        return false;
    }

    public boolean editarLocalCrime(int id, String novoLocal){
        Caso c = buscarCaso(id);

        if (c != null){
            c.setLocalCrime(novoLocal);
            persistencia.salvar(casos);
            return true;
        }
        return false;
    }

    public boolean editarDataCrime(int id, String novaData){
        Caso c = buscarCaso(id);

        if (c != null){
            c.setDataCrime(novaData);
            persistencia.salvar(casos);
            return true;
        }
        return false;
    }

    public boolean editarStatus(int id, String novoStatus){
        Caso c = buscarCaso(id);

        if (c != null){
            c.setStatus(novoStatus);
            persistencia.salvar(casos);
            return true;
        }
        return false;
    }

    public boolean removerCaso(int id){
        for (int i = 0; i < casos.size(); i++) {
            if (casos.get(i).getId() == id){
                casos.remove(i);
                persistencia.salvar(casos);
                return true;
            }
        }

        return false;
    }


}
