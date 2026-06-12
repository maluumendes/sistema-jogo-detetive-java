package View;

import Controller.SuspeitoController;
import Model.Suspeito;
import Util.InputHelper;

public class SuspeitoView {
    private SuspeitoController controller;

    public SuspeitoView(SuspeitoController controller) {
        this.controller = controller;
    }

    public void cadastrarSuspeito() {
        System.out.println("\n=== CADASTRO DE SUSPEITO ===");
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
        String ocupacao = InputHelper.lerTexto("Ocupação: ");
        int idade = InputHelper.lerNumInt("Idade: ");
        String alibi = InputHelper.lerTexto("Álibi: ");
        String relacao = InputHelper.lerTexto("Relação com a Vítima: ");
        int ant = InputHelper.lerNumInt("Possui Antecedentes? (1-Sim / 0-Não): ");

        controller.cadastrarSuspeito(id, nome, ocupacao, idade, alibi, relacao, ant == 1);
        System.out.println("✓ Suspeito registrado!");
    }

    public void listarSuspeitos() {
        if (controller.listarSuspeitos().isEmpty()) {
            System.out.println("Nenhum suspeito catalogado.");
            return;
        }
        for (Suspeito s : controller.listarSuspeitos()) {
            System.out.println(s.gerarResumoDetalhado());
        }
    }

    public void menuSuspeitos() {
        int op;
        do {
            System.out.println("\n===== SUSPEITOS =====");
            System.out.println("1 - Cadastrar Suspeito");
            System.out.println("2 - Listar Suspeitos");
            System.out.println("0 - Voltar");
            op = InputHelper.lerNumInt("Opção: ");
            switch (op) {
                case 1 -> cadastrarSuspeito();
                case 2 -> listarSuspeitos();
            }
        } while (op != 0);
    }
}
