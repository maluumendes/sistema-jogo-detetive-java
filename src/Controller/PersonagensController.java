package Controller;

import View.PersonagensView;
import Model.Investigador;
import Model.Suspeito;

import java.util.ArrayList;
import java.util.List;

public class PersonagensController {
    private List<Investigador> listaInvestigadores = new ArrayList<>();
    private List<Suspeito> listaSuspeitos = new ArrayList<>();
    private List<Caso> listaCasos = new ArrayList<>();

    public void processarOpcaoMenu(int opcao, PersonagensView view) {
        switch (opcao) {
            case 1:
                view.cadastrarInvestigador();
                break;
            case 2:
                view.cadastrarSuspeito();
                break;
            case 3:
                view.solicitarAberturaCaso();
                break;
            case 4:
                view.solicitarEncerramentoCaso();
                break;
            case 5:
                view.mostrarRelatorioGeral();
                break;
            case 0:
                System.out.println("Fechando arquivos do distrito policial...");
                break;
            default:
                System.out.println("Opção inválida! Tente novamente.");
        }
    }

    public void cadastrarInvestigador(String nome, String ocupacao, int idade, int limiteCasos, int casosAtuais, String metodo, String itemFavorito) {
        Investigador novoInvestigador = new Investigador(nome, ocupacao, idade, limiteCasos, casosAtuais, metodo, itemFavorito);
        listaInvestigadores.add(novoInvestigador);
    }

    public void cadastrarSuspeito(String nome, String ocupacao, int idade, String alibi, String relacao, boolean antecedentes) {
        Suspeito novoSuspeito = new Suspeito(nome, ocupacao, idade, alibi, relacao, antecedentes);
        listaSuspeitos.add(novoSuspeito);
    }

    public boolean criarCaso(int idCaso, String titulo, Investigador investigador) {
        if (investigador != null && investigador.podeAssumirNovoCaso()) {
            investigador.alocarAoCaso();
            Caso novoCaso = new Caso(idCaso, titulo, investigador);
            listaCasos.add(novoCaso);
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
                return true;
            }
        }
        return false;
    }

    public Investigador buscarInvestigadorPorNome(String nome) {
        for (Investigador inv : listaInvestigadores) {
            if (inv.getNome().equalsIgnoreCase(nome)) {
                return inv;
            }
        }
        return null;
    }

    public List<Investigador> getListaInvestigadores() {
        return listaInvestigadores;
    }

    public List<Suspeito> getListaSuspeitos() {
        return listaSuspeitos;
    }
}
