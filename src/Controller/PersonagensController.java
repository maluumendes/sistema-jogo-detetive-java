package Controller;

import Model.Investigador;
import Model.Suspeito;
import Model.Caso;
import Persistence.PersonagensPersistence;
import View.PersonagensView;

import java.util.ArrayList;
import java.util.List;

public class PersonagensController {
    private List<Investigador> listaInvestigadores;
    private List<Suspeito> listaSuspeitos;
    private List<Caso> listaCasos;

    public PersonagensController() {
        this.listaInvestigadores = PersonagensPersistence.carregarInvestigadores();
        this.listaSuspeitos = PersonagensPersistence.carregarSuspeitos();
        this.listaCasos = new ArrayList<>();
    }

    public void processarOpcaoMenu(int opcao, PersonagensView view) {
        switch (opcao) {
            case 1 -> view.cadastrarInvestigador();
            case 2 -> view.cadastrarSuspeito();
            case 3 -> view.solicitarAberturaCaso();
            case 4 -> view.solicitarEncerramentoCaso();
            case 5 -> view.mostrarRelatorioGeral();
            case 0 -> System.out.println("Fechando arquivos do distrito policial...");
            default -> System.out.println("Opção inválida! Tente novamente.");
        }
    }

    public void cadastrarInvestigador(int id, String nome, String ocupacao, int idade, int limiteCasos, int casosAtuais, String metodo, String itemFavorito) {
        Investigador novoInvestigador = new Investigador(id, nome, ocupacao, idade, limiteCasos, casosAtuais, metodo, itemFavorito);
        listaInvestigadores.add(novoInvestigador);
        PersonagensPersistence.salvarInvestigadores(listaInvestigadores);
    }

    public void cadastrarSuspeito(int id, String nome, String ocupacao, int idade, String alibi, String relacao, boolean antecedentes) {
        Suspeito novoSuspeito = new Suspeito(id, nome, ocupacao, idade, alibi, relacao, antecedentes);
        listaSuspeitos.add(novoSuspeito);
        PersonagensPersistence.salvarSuspeitos(listaSuspeitos);
    }

    public boolean criarCaso(int idCaso, String titulo, Investigador investigador) {
        if (investigador != null && investigador.podeAssumirNovoCaso()) {
            investigador.alocarAoCaso();
            Caso novoCaso = new Caso(idCaso, titulo, investigador);
            listaCasos.add(novoCaso);
            PersonagensPersistence.salvarInvestigadores(listaInvestigadores);
            return true;
        }
        return false;
    }

    public boolean verificarEDesvincularPorId(int idDigitado) {
        for (Caso casoAtual : listaCasos) {
            if (casoAtual.getId() == idDigitado) {
                Investigador inv = casoAtual.getInvestigadorAlocado();
                if (inv != null) {
                    inv.desvincularDoCaso();
                }
                listaCasos.remove(casoAtual);
                PersonagensPersistence.salvarInvestigadores(listaInvestigadores);
                return true;
            }
        }
        return false;
    }

    public Investigador buscarInvestigadorPorId(int id) {
        for (Investigador inv : listaInvestigadores) {
            if (inv.getId() == id) {
                return inv;
            }
        }
        return null;
    }

    public Suspeito buscarSuspeitoPorId(int id) {
        for (Suspeito susp : listaSuspeitos) {
            if (susp.getId() == id) {
                return susp;
            }
        }
        return null;
    }

    public List<Investigador> getListaInvestigadores() { return listaInvestigadores; }
    public List<Suspeito> getListaSuspeitos() { return listaSuspeitos; }
    public List<Caso> getListaCasos() { return listaCasos; }
}
