package View;

import Controller.InterrogatorioController;
import Model.Interrogatorio;
import Util.InputHelper;

public class InterrogatorioView {
    private InterrogatorioController controller = new InterrogatorioController();

    public void registrarInterrogatorio() {
        System.out.println("\n=== REGISTRAR INTERROGATÓRIO ===");
        int idCaso = InputHelper.lerNumInt("ID do Caso: ");
        int idInv = InputHelper.lerNumInt("ID do Investigador: ");
        int idSusp = InputHelper.lerNumInt("ID do Suspeito: ");
        String data = InputHelper.lerTexto("Data: ");
        String depoimento = InputHelper.lerTexto("Depoimento Coletado: ");

        controller.registrarInterrogatorio(idCaso, idInv, idSusp, data, depoimento);
        System.out.println("✓ Interrogatório salvo com sucesso!");
    }

    public void listarInterrogatorios() {
        if (controller.listarInterrogatorios().isEmpty()) {
            System.out.println("Nenhum depoimento nos arquivos.");
            return;
        }
        for (Interrogatorio i : controller.listarInterrogatorios()) {
            System.out.println("Interrogatório ID: " + i.getId() + " | Caso: " + i.getIdCaso() + " | Depoimento: " + i.getDepoimento());
        }
    }

    public void menuInterrogatorios() {
        int op;
        do {
            System.out.println("\n===== INTERROGATÓRIOS =====");
            System.out.println("1 - Registrar Novo");
            System.out.println("2 - Listar Todos");
            System.out.println("0 - Voltar");
            op = InputHelper.lerNumInt("Opção: ");
            switch (op) {
                case 1 -> registrarInterrogatorio();
                case 2 -> listarInterrogatorios();
            }
        } while (op != 0);
    }
}
