package controller;

import model.Interrogatorio;
import repository.InterrogatorioDAO;
import java.util.List;

public class InterrogatorioController {
    private InterrogatorioDAO dao;
    private List<Interrogatorio> interrogatorios;

    public InterrogatorioController() {
        this.dao = new InterrogatorioDAO();
        this.interrogatorios = dao.listarTodos();
    }

    public void registrarInterrogatorio(int idCaso, int idInvestigador, int idSuspeito, String data,
            String depoimento) {
        int proximoId = interrogatorios.isEmpty() ? 1 : interrogatorios.get(interrogatorios.size() - 1).getId() + 1;
        Interrogatorio novo = new Interrogatorio(proximoId, idCaso, idInvestigador, idSuspeito, data, depoimento);
        interrogatorios.add(novo);
        dao.salvarTodos(interrogatorios);
    }

    public List<Interrogatorio> listarInterrogatorios() {
        return interrogatorios;
    }

    public boolean editarInterrogatorio(int id, int novoCaso, int novoInvestigador, int novoSuspeito, String novaData,
            String novoDepoimento) {
        for (Interrogatorio i : interrogatorios) {
            if (i.getId() == id) {
                i.setIdCaso(novoCaso);
                i.setIdInvestigador(novoInvestigador);
                i.setIdSuspeito(novoSuspeito);
                i.setData(novaData);
                i.setDepoimento(novoDepoimento);
                dao.salvarTodos(interrogatorios);
                return true;
            }
        }
        return false;
    }

    public boolean excluirInterrogatorio(int id) {
        for (Interrogatorio i : interrogatorios) {
            if (i.getId() == id) {
                interrogatorios.remove(i);
                dao.salvarTodos(interrogatorios);
                return true;
            }
        }
        return false;
    }
}