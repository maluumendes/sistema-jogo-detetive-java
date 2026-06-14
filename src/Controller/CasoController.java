package Controller;

import Model.Caso;
import Model.Investigador;
import Model.Pista;
import Model.Suspeito;
import Persistence.CasoPersistencia;
import Util.LoggerSistema;

import java.util.ArrayList;

public class CasoController {

    private ArrayList<Caso> casos;
    private CasoPersistencia persistencia;

    public CasoController() {
        persistencia = new CasoPersistencia();
        casos = persistencia.carregar();

        if (casos == null) {
            casos = new ArrayList<>();
        }
    }

    public void validarId(int id) throws Exception {
        if (buscarCaso(id) != null) {
            throw new Exception("Já existe um caso com este ID.");
        }
    }

    public void adicionarCaso(int id, String titulo, String descricao, String localCrime, String dataCrime, String status, ArrayList<Investigador> investigadores) {

        Caso novoCaso = new Caso(id, titulo, descricao, localCrime, dataCrime, status, investigadores);
        casos.add(novoCaso);
        persistencia.salvar(casos);

        LoggerSistema.registrar("Caso cadastrado. ID: " + id + " | Título: " + titulo);
    }

    public ArrayList<Caso> listarCasos() {
        return casos;
    }

    public Caso buscarCaso(int id) {
        for (Caso caso : casos) {
            if (caso.getId() == id) {
                return caso;
            }
        }
        return null;
    }

    public boolean editarTitulo(int id, String novoTitulo) {
        Caso caso = buscarCaso(id);
        if (caso != null) {
            caso.setTitulo(novoTitulo);
            persistencia.salvar(casos);

            LoggerSistema.registrar("Título alterado do Caso ID " + id);
            return true;
        }
        return false;
    }

    public boolean editarDescricao(int id, String novaDescricao) {
        Caso caso = buscarCaso(id);

        if (caso != null) {
            caso.setDescricao(novaDescricao);
            persistencia.salvar(casos);

            LoggerSistema.registrar("Descrição alterada do Caso ID " + id);
            return true;
        }
        return false;
    }

    public boolean editarLocalCrime(int id, String novoLocal) {
        Caso caso = buscarCaso(id);

        if (caso != null) {
            caso.setLocalCrime(novoLocal);
            persistencia.salvar(casos);

            LoggerSistema.registrar("Local do crime alterado no Caso ID " + id);
            return true;
        }
        return false;
    }

    public boolean editarDataCrime(int id, String novaData) {
        Caso caso = buscarCaso(id);

        if (caso != null) {
            caso.setDataCrime(novaData);
            persistencia.salvar(casos);

            LoggerSistema.registrar("Data do crime alterada no Caso ID " + id);
            return true;
        }
        return false;
    }

    public boolean editarStatus(int id, String novoStatus) {
        Caso caso = buscarCaso(id);

        if (caso != null) {
            caso.setStatus(novoStatus);
            persistencia.salvar(casos);

            LoggerSistema.registrar("Status alterado no Caso ID " + id);
            return true;
        }
        return false;
    }

    public boolean removerCaso(int id) {
        Caso caso = buscarCaso(id);

        if (caso != null) {
            casos.remove(caso);
            persistencia.salvar(casos);

            LoggerSistema.registrar("Caso removido. ID: " + id);
            return true;
        }
        return false;
    }

    public boolean adicionarSuspeito(int idCaso, Suspeito suspeito) {
        Caso caso = buscarCaso(idCaso);

        if (caso != null) {
            caso.adicionarSuspeito(suspeito);
            persistencia.salvar(casos);

            LoggerSistema.registrar("Suspeito " + suspeito.getNome() + " vinculado ao Caso " + idCaso);
            return true;
        }
        return false;
    }

    public boolean adicionarInvestigador(int idCaso, Investigador investigador) {

        Caso caso = buscarCaso(idCaso);

        if (caso != null) {
            caso.adicionarInvestigador(investigador);
            persistencia.salvar(casos);

            LoggerSistema.registrar("Investigador " + investigador.getNome() + " vinculado ao Caso " + idCaso);
            return true;
        }
        return false;
    }

    public boolean removerInvestigador(int idCaso, int idInvestigador) {

        Caso caso = buscarCaso(idCaso);

        if (caso != null) {
            boolean removido = caso.removerInvestigador(idInvestigador);

            if (removido) {
                persistencia.salvar(casos);
                LoggerSistema.registrar("Investigador removido do Caso " + idCaso);
                return true;
            }
        }
        return false;
    }

    public boolean adicionarPista(int idCaso, Pista pista) {
        Caso caso = buscarCaso(idCaso);

        if (caso != null) {
            caso.adicionarPista(pista);
            persistencia.salvar(casos);

            LoggerSistema.registrar("Pista adicionada ao Caso " + idCaso);
            return true;
        }
        return false;
    }

    public Pista buscarPista(int idCaso, int idPista) {
        Caso caso = buscarCaso(idCaso);

        if (caso != null) {
            for (Pista pista : caso.getPistas()) {
                if (pista.getId() == idPista) {
                    return pista;
                }
            }
        }
        return null;
    }

    public boolean editarPista(int idCaso, int idPista, String novaDescricao) {
        Pista pista = buscarPista(idCaso, idPista);

        if (pista != null) {
            pista.setDescricao(novaDescricao);
            persistencia.salvar(casos);

            LoggerSistema.registrar("Pista editada. ID: " + idPista);
            return true;
        }
        return false;
    }

    public boolean removerPista(int idCaso, int idPista) {
        Caso caso = buscarCaso(idCaso);

        if (caso != null) {
            boolean removida = caso.removerPista(idPista);

            if (removida) {
                persistencia.salvar(casos);

                LoggerSistema.registrar("Pista removida. ID: " + idPista);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Caso> listarCasosAbertos() {

        ArrayList<Caso> lista = new ArrayList<>();

        for (Caso caso : casos) {
            if (caso.getStatus().equalsIgnoreCase("Aberto")) {
                lista.add(caso);
            }
        }
        return lista;
    }

    public void excluirArquivos() {
        persistencia.excluirArquivos();
    }

}