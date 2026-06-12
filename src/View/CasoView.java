package View;

import Controller.CasoController;
import Controller.InvestigadorController;
import Model.Caso;
import Model.Investigador;
import Util.InputHelper;
import java.util.ArrayList;

public class CasoView {
    private CasoController casoController;
    private InvestigadorController investigadorController;

    public CasoView(CasoController casoController, InvestigadorController investigadorController) {
        this.casoController = casoController;
        this.investigadorController = investigadorController;
    }

    public void cadastrarCaso() {
        if (investigadorController.listarInvestigadores().isEmpty()) {
            System.out.println("Cadastre um investigador antes de criar um caso.");
            return;
        }

        System.out.println("=== CADASTRO DE CASO ===\n");
        int id;
        while (true) {
            try {
                id = InputHelper.lerNumInt("> ID: ");
                casoController.validarId(id);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        String titulo = InputHelper.lerTexto("> Título: ");
        String descricao = InputHelper.lerTexto("> Descrição: ");
        String localCrime = InputHelper.lerTexto("> Local do Crime: ");
        String dataCrime = InputHelper.lerTexto("> Data do Crime: ");
        String status = InputHelper.lerTexto("> Status: ");

        ArrayList<Investigador> alocados = new ArrayList<>();
        System.out.println("\nInvestigadores disponíveis no departamento:");
        for (Investigador inv : investigadorController.listarInvestigadores()) {
            System.out.println("ID: " + inv.getId() + " - " + inv.getNome() + " (Ativos: " + inv.getCasosAtivosAtuais() + ")");
        }

        int idInv = InputHelper.lerNumInt("\nDigite o ID do investigador para vincular a este caso: ");
        Investigador selecionado = investigadorController.buscarInvestigador(idInv);

        if (selecionado != null && selecionado.podeAssumirNovoCaso()) {
            selecionado.alocarAoCaso();
            alocados.add(selecionado);
            casoController.adicionarCaso(id, titulo, descricao, localCrime, dataCrime, status, alocados);
            System.out.println("✓ Caso cadastrado e Investigador alocado com sucesso!");
        } else {
            System.out.println("❌ Falha: Investigador indisponível ou atingiu o limite de casos ativos.");
        }
    }

    public void listarCasos() {
        if (casoController.listarCaso().isEmpty()) {
            System.out.println("Nenhum caso cadastrado.");
            return;
        }
        for (Caso c : casoController.listarCaso()) {
            c.mostrarInfo();
        }
    }

    public void menuCasos() {
        int op;
        do {
            System.out.println("\n=========================");
            System.out.println("     MENU CASOS");
            System.out.println("=========================");
            System.out.println("1 - Cadastrar Caso");
            System.out.println("2 - Listar Casos");
            System.out.println("0 - Voltar");
            op = InputHelper.lerNumInt(">> Opção: ");

            switch (op) {
                case 1 -> cadastrarCaso();
                case 2 -> listarCasos();
            }
        } while (op != 0);
    }
}
