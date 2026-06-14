package View;

import Controller.InterrogatorioController;
import Model.Interrogatorio;
import Util.InputHelper;

public class InterrogatorioView {

    private InterrogatorioController controller;

    public InterrogatorioView(InterrogatorioController controller) {
        this.controller = controller;
    }

    public void menu() {

        int opcao;

        do {

            System.out.println("\n========== MENU INTERROGATÓRIOS ==========");
            System.out.println("1 - Cadastrar interrogatório");
            System.out.println("2 - Listar interrogatórios");
            System.out.println("3 - Buscar interrogatório");
            System.out.println("4 - Editar data");
            System.out.println("5 - Editar depoimento");
            System.out.println("6 - Remover interrogatório");
            System.out.println("0 - Voltar");
            System.out.println("==========================================");

            opcao = InputHelper.lerInt("Escolha uma opção: ");

            switch (opcao) {

                case 1:
                    cadastrarInterrogatorio();
                    break;

                case 2:
                    listarInterrogatorios();
                    break;

                case 3:
                    buscarInterrogatorio();
                    break;

                case 4:
                    editarData();
                    break;

                case 5:
                    editarDepoimento();
                    break;

                case 6:
                    removerInterrogatorio();
                    break;

                case 0:
                    System.out.println("Retornando ao menu principal...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }

    private void cadastrarInterrogatorio() {

        try {

            int id = InputHelper.lerInt("ID: ");

            controller.validarId(id);

            int idCaso = InputHelper.lerInt("ID do Caso: ");

            int idInvestigador = InputHelper.lerInt("ID do Investigador: ");

            int idSuspeito = InputHelper.lerInt("ID do Suspeito: ");

            String data = InputHelper.lerString("Data: ");

            String depoimento = InputHelper.lerString("Depoimento: ");

            controller.cadastrarInterrogatorio(
                    id,
                    idCaso,
                    idInvestigador,
                    idSuspeito,
                    data,
                    depoimento
            );

            System.out.println("Interrogatório cadastrado com sucesso!");

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }

    private void listarInterrogatorios() {

        if (controller.listarInterrogatorios().isEmpty()) {

            System.out.println("Nenhum interrogatório cadastrado.");
            return;
        }

        System.out.println("\n========== INTERROGATÓRIOS ==========");

        for (Interrogatorio interrogatorio : controller.listarInterrogatorios()) {

            System.out.println(interrogatorio.exibirResumo());
        }
    }

    private void buscarInterrogatorio() {

        int id = InputHelper.lerInt("Informe o ID: ");

        Interrogatorio interrogatorio = controller.buscarInterrogatorio(id);

        if (interrogatorio != null) {

            System.out.println("\n========== DADOS ==========");
            System.out.println("ID: " + interrogatorio.getId());
            System.out.println("ID Caso: " + interrogatorio.getIdCaso());
            System.out.println("ID Investigador: " + interrogatorio.getIdInvestigador());
            System.out.println("ID Suspeito: " + interrogatorio.getIdSuspeito());
            System.out.println("Data: " + interrogatorio.getData());
            System.out.println("Depoimento: " + interrogatorio.getDepoimento());

        } else {

            System.out.println("Interrogatório não encontrado.");
        }
    }

    private void editarData() {

        int id = InputHelper.lerInt("ID do interrogatório: ");

        String novaData = InputHelper.lerString("Nova data: ");

        if (controller.editarData(id, novaData)) {

            System.out.println("Data atualizada com sucesso.");

        } else {

            System.out.println("Interrogatório não encontrado.");
        }
    }

    private void editarDepoimento() {

        int id = InputHelper.lerInt("ID do interrogatório: ");

        String novoDepoimento = InputHelper.lerString("Novo depoimento: ");

        if (controller.editarDepoimento(id, novoDepoimento)) {

            System.out.println("Depoimento atualizado com sucesso.");

        } else {

            System.out.println("Interrogatório não encontrado.");
        }
    }

    private void removerInterrogatorio() {

        int id = InputHelper.lerInt("ID do interrogatório: ");

        if (controller.removerInterrogatorio(id)) {

            System.out.println("Interrogatório removido com sucesso.");

        } else {

            System.out.println("Interrogatório não encontrado.");
        }
    }
}