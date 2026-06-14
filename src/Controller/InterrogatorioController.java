package Controller;

import Model.Interrogatorio;
import Persistence.InterrogatorioPersistencia;
import Util.LoggerSistema;

import java.util.ArrayList;

public class InterrogatorioController {

    private ArrayList<Interrogatorio> interrogatorios;
    private InterrogatorioPersistencia persistencia;

    public InterrogatorioController() {
        persistencia = new InterrogatorioPersistencia();
        interrogatorios = persistencia.carregar();

        if (interrogatorios == null) {
            interrogatorios = new ArrayList<>();
        }

        LoggerSistema.registrar("Interrogatórios carregados.");
    }

    public void validarId(int id) throws Exception {
        if (buscarInterrogatorio(id) != null) {
            throw new Exception("Já existe um interrogatório com esse ID.");
        }
    }

    public void cadastrarInterrogatorio(int id, int idCaso, int idInvestigador, int idSuspeito, String data, String depoimento) {

        Interrogatorio interrogatorio = new Interrogatorio(id, idCaso, idInvestigador, idSuspeito, data, depoimento);
        interrogatorios.add(interrogatorio);
        persistencia.salvar(interrogatorios);

        LoggerSistema.registrar("Interrogatório cadastrado. ID: " + id);
    }

    public ArrayList<Interrogatorio> listarInterrogatorios() {
        return interrogatorios;
    }

    public Interrogatorio buscarInterrogatorio(int id) {

        for (Interrogatorio i : interrogatorios) {
            if (i.getId() == id) {
                return i;
            }
        }
        return null;
    }

    public boolean editarData(int id, String novaData) {

        Interrogatorio interrogatorio = buscarInterrogatorio(id);

        if (interrogatorio != null) {
            interrogatorio.setData(novaData);
            persistencia.salvar(interrogatorios);

            LoggerSistema.registrar("Data alterada no interrogatório " + id);
            return true;
        }
        return false;
    }

    public boolean editarDepoimento(int id, String novoDepoimento) {

        Interrogatorio interrogatorio = buscarInterrogatorio(id);

        if (interrogatorio != null) {
            interrogatorio.setDepoimento(novoDepoimento);
            persistencia.salvar(interrogatorios);

            LoggerSistema.registrar("Depoimento alterado no interrogatório " + id);
            return true;
        }
        return false;
    }

    public boolean removerInterrogatorio(int id) {

        for (int i = 0; i < interrogatorios.size(); i++) {

            if (interrogatorios.get(i).getId() == id) {
                interrogatorios.remove(i);
                persistencia.salvar(interrogatorios);

                LoggerSistema.registrar("Interrogatório removido. ID: " + id);
                return true;
            }
        }
        return false;
    }


    public void excluirArquivos() {
        persistencia.excluirArquivos();
    }
}