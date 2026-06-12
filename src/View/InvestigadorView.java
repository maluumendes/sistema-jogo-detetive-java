package View;

import Controller.InvestigadorController;
import Model.Investigador;
import Util.InputHelper;

public class InvestigadorView {
    private InvestigadorController controller;

    public InvestigadorView(InvestigadorController controller) {
        this.controller = controller;
    }

    public void cadastrarInvestigador() {
        System.out.println("\n=== CADASTRO DE INVESTIGADOR ===");
        int id;
        while (true) {
            try {
                id = InputHelper.lerNumInt("ID: ");
                controller.validarId(id);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        String nome = InputHelper.lerTexto("Nome: ");
        String cargo = InputHelper.lerTexto("Cargo: ");
        String departamento = InputHelper.lerTexto("Departamento: ");

        controller.cadastrarInvestigador(id, nome, cargo, departamento);
        System.out.println("Investigador cadastrado!");
    }

    public void listarInvestigadores() {
        if (controller.listarInvestigadores().isEmpty()) {
            System.out.println("Não há investigadores.");
            return;
        }
        for (Investigador i : controller.listarInvestigadores()) {
            System.out.println(i.gerarResumoDetalhado());
        }
    }

    public void menuInvestigadores() {
        int op;
        do {
            System.out.println("\n===== INVESTIGADORES =====");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("0 - Voltar");
            op = InputHelper.lerNumInt("Opção: ");

            switch (op) {
                case 1 -> cadastrarInvestigador();
                case 2 -> listarInvestigadores();
            }
        } while (op != 0);
    }
}
