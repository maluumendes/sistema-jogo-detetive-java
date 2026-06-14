package View;

import Controller.CasoController;
import Controller.InvestigadorController;
import Controller.SuspeitoController;
import Model.Caso;
import Model.Investigador;
import Model.Pista;
import Model.Suspeito;
import Util.InputHelper;

import java.util.ArrayList;

public class CasoView {

    private CasoController controller;
    private InvestigadorController investigadorController;
    private SuspeitoController suspeitoController;

    public CasoView() {
        controller = new CasoController();
        investigadorController = new InvestigadorController();
        suspeitoController = new SuspeitoController();
    }

    public void menu() {

        int opcao;

        do {

            System.out.println("\n========== MENU CASOS ==========");
            System.out.println("1 - Cadastrar Caso");
            System.out.println("2 - Listar Casos");
            System.out.println("3 - Buscar Caso");
            System.out.println("4 - Editar Caso");
            System.out.println("5 - Remover Caso");
            System.out.println("6 - Vincular Investigador");
            System.out.println("7 - Vincular Suspeito");
            System.out.println("8 - Adicionar Pista");
            System.out.println("9 - Editar Pista");
            System.out.println("10 - Remover Pista");
            System.out.println("11 - Mostrar Relatório");
            System.out.println("0 - Voltar");

            opcao = InputHelper.lerInt("Opção: ");

            switch (opcao) {

                case 1:
                    cadastrarCaso();
                    break;

                case 2:
                    listarCasos();
                    break;

                case 3:
                    buscarCaso();
                    break;

                case 4:
                    editarCaso();
                    break;

                case 5:
                    removerCaso();
                    break;

                case 6:
                    vincularInvestigador();
                    break;

                case 7:
                    vincularSuspeito();
                    break;

                case 8:
                    adicionarPista();
                    break;

                case 9:
                    editarPista();
                    break;

                case 10:
                    removerPista();
                    break;

                case 11:
                    gerarRelatorio();
                    break;

                case 0:
                    System.out.println("Voltando...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }

    private void cadastrarCaso() {

        try {

            int id = InputHelper.lerInt("ID do caso: ");

            controller.validarId(id);

            String titulo = InputHelper.lerString("Título: ");
            String descricao = InputHelper.lerString("Descrição: ");
            String local = InputHelper.lerString("Local do crime: ");
            String data = InputHelper.lerString("Data do crime: ");
            String status = InputHelper.lerString("Status: ");

            controller.adicionarCaso(
                    id,
                    titulo,
                    descricao,
                    local,
                    data,
                    status,
                    new ArrayList<>()
            );

            System.out.println("Caso cadastrado com sucesso.");

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }

    private void listarCasos() {

        ArrayList<Caso> casos = controller.listarCasos();

        if (casos.isEmpty()) {
            System.out.println("Nenhum caso cadastrado.");
            return;
        }

        for (Caso caso : casos) {
            System.out.println(caso.exibirResumo());
        }
    }

    private void buscarCaso() {

        int id = InputHelper.lerInt("ID do caso: ");

        Caso caso = controller.buscarCaso(id);

        if (caso != null) {
            caso.mostrarInfo();
        } else {
            System.out.println("Caso não encontrado.");
        }
    }

    private void editarCaso() {

        int id = InputHelper.lerInt("ID do caso: ");

        System.out.println("\n1 - Título");
        System.out.println("2 - Descrição");
        System.out.println("3 - Local");
        System.out.println("4 - Data");
        System.out.println("5 - Status");

        int op = InputHelper.lerInt("Campo: ");

        boolean sucesso = false;

        switch (op) {

            case 1:
                sucesso = controller.editarTitulo(id, InputHelper.lerString("Novo título: "));
                break;

            case 2:
                sucesso = controller.editarDescricao(id, InputHelper.lerString("Nova descrição: "));
                break;

            case 3:
                sucesso = controller.editarLocalCrime(id, InputHelper.lerString("Novo local: "));
                break;

            case 4:
                sucesso = controller.editarDataCrime(id, InputHelper.lerString("Nova data: "));
                break;

            case 5:
                sucesso = controller.editarStatus(id, InputHelper.lerString("Novo status: "));
                break;
        }

        if (sucesso) {
            System.out.println("Caso atualizado.");
        } else {
            System.out.println("Caso não encontrado.");
        }
    }

    private void removerCaso() {

        int id = InputHelper.lerInt("ID do caso: ");

        if (controller.removerCaso(id)) {
            System.out.println("Caso removido.");
        } else {
            System.out.println("Caso não encontrado.");
        }
    }

    private void vincularInvestigador() {

        int idCaso = InputHelper.lerInt("ID do caso: ");
        int idInvestigador = InputHelper.lerInt("ID do investigador: ");

        Investigador investigador = investigadorController.buscarInvestigador(idInvestigador);

        if (investigador == null) {
            System.out.println("Investigador não encontrado.");
            return;
        }

        if (controller.adicionarInvestigador(idCaso, investigador)) {

            investigador.alocarAoCaso();

            System.out.println("Investigador vinculado.");

        } else {

            System.out.println("Caso não encontrado.");
        }
    }

    private void vincularSuspeito() {

        int idCaso = InputHelper.lerInt("ID do caso: ");
        int idSuspeito = InputHelper.lerInt("ID do suspeito: ");

        Suspeito suspeito = suspeitoController.buscarSuspeito(idSuspeito);

        if (suspeito == null) {
            System.out.println("Suspeito não encontrado.");
            return;
        }

        if (controller.adicionarSuspeito(idCaso, suspeito)) {
            System.out.println("Suspeito vinculado.");
        } else {
            System.out.println("Caso não encontrado.");
        }
    }

    private void adicionarPista() {

        int idCaso = InputHelper.lerInt("ID do caso: ");
        int idPista = InputHelper.lerInt("ID da pista: ");

        String descricao = InputHelper.lerString("Descrição: ");
        String local = InputHelper.lerString("Local encontrada: ");

        Pista pista = new Pista(idPista, descricao, local);

        if (controller.adicionarPista(idCaso, pista)) {
            System.out.println("Pista adicionada.");
        } else {
            System.out.println("Caso não encontrado.");
        }
    }

    private void editarPista() {

        int idCaso = InputHelper.lerInt("ID do caso: ");
        int idPista = InputHelper.lerInt("ID da pista: ");

        String descricao = InputHelper.lerString("Nova descrição: ");

        if (controller.editarPista(idCaso, idPista, descricao)) {
            System.out.println("Pista atualizada.");
        } else {
            System.out.println("Pista não encontrada.");
        }
    }

    private void removerPista() {

        int idCaso = InputHelper.lerInt("ID do caso: ");
        int idPista = InputHelper.lerInt("ID da pista: ");

        if (controller.removerPista(idCaso, idPista)) {
            System.out.println("Pista removida.");
        } else {
            System.out.println("Pista não encontrada.");
        }
    }

    private void gerarRelatorio() {

        int id = InputHelper.lerInt("ID do caso: ");

        Caso caso = controller.buscarCaso(id);

        if (caso != null) {
            System.out.println("\n" + caso.gerarRelatorioInvestigacao());
        } else {
            System.out.println("Caso não encontrado.");
        }
    }
}