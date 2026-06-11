package View;

import Controller.PersonagensController;
import Model.Investigador;
import Model.Suspeito;
import java.util.Scanner;
import Util.InputHelper;

public class PersonagensView {
    private Scanner scanner;
    private PersonagensController controller;

    public PersonagensView(PersonagensController controller) {
        this.controller = controller;
    }

    public void exibirMenuPrincipal() {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n========= SISTEMA DE CADASTRO CRIMINAL =========");
            System.out.println("1. Cadastrar Investigador");
            System.out.println("2. Cadastrar Suspeito");
            System.out.println("3. Abrir Novo Caso (Vincular Investigador)");
            System.out.println("4. Encerrar/Desvincular Caso por ID");
            System.out.println("5. Listar Envolvidos (Relatório Geral)");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = InputHelper.lerNumInt("Escolha uma opção: ");

            controller.processarOpcaoMenu(opcao, this);
        }
    }

    public void cadastrarInvestigador() {
        String nome = InputHelper.lerTexto("Nome do Investigador: ");
        String ocupacao = InputHelper.lerTexto("Cargo/Posto atual: ");
        int idade = InputHelper.lerNumInt("Idade: ");
        int limite = InputHelper.lerNumInt("Limite de Casos Simultâneos: ");
        String metodo = InputHelper.lerTexto("Método de Investigação: ");
        String item = InputHelper.lerTexto("Item de Investigação Favorito: ");

        controller.cadastrarInvestigador(nome, ocupacao, idade, limite, 0, metodo, item);
        System.out.println("✓ Investigador adicionado com sucesso!");
    }

    public void cadastrarSuspeito() {
        String nome = InputHelper.lerTexto("Nome do Suspeito: ");
        String ocupacao = InputHelper.lerTexto("Profissão/Ocupação: ");
        int idade = InputHelper.lerNumInt("Idade: ");
        String alibi = InputHelper.lerTexto("Álibi apresentado: ");
        String relacao = InputHelper.lerTexto("Relação com a Vítima: ");

        String strAntecedentes = InputHelper.lerTexto("Possui Antecedentes Criminais? (true/false): ");
        boolean antecedentes = Boolean.parseBoolean(strAntecedentes);

        controller.cadastrarSuspeito(nome, ocupacao, idade, alibi, relacao, antecedentes);
        System.out.println("✓ Suspeito fichado com sucesso!");
    }

    public void solicitarAberturaCaso() {
        int idCaso = InputHelper.lerNumInt("ID numérico do Caso: ");
        String titulo = InputHelper.lerTexto("Título/Descrição Curta do Caso: ");
        String nomeInvestigador = InputHelper.lerTexto("Nome do Investigador que assumirá o caso: ");

        Investigador inv = controller.buscarInvestigadorPorNome(nomeInvestigador);

        if (inv == null) {
            System.out.println("❌ Erro: Nenhum investigador cadastrado com o nome '" + nomeInvestigador + "'.");
            return;
        }

        boolean sucesso = controller.criarCaso(idCaso, titulo, inv);

        if (sucesso) {
            System.out.println("✓ Caso registrado! Carga de trabalho de " + inv.getNome() + " atualizada.");
        } else {
            System.out.println("❌ Erro: O investigador " + inv.getNome() + " já atingiu o limite máximo de casos simultâneos!");
        }
    }

    public void solicitarEncerramentoCaso() {
        System.out.println("\n--- ARQUIVAR / ENCERRAR CASO POR ID ---");
        System.out.print("Digite o ID do caso que deseja encerrar: ");

        int idDigitado = InputHelper.lerNumInt("Digite o ID do caso que deseja encerrar: ");

        boolean sucesso = controller.verificarEDesvincularPorId(idDigitado);

        if (sucesso) {
            System.out.println("✓ Caso encerrado! O investigador associado foi liberado.");
        } else {
            System.out.println("❌ Erro: Nenhum caso com o ID " + idDigitado + " foi localizado.");
        }
    }

    public void mostrarRelatorioGeral() {
        System.out.println("\n========================================");
        System.out.println("     REGISTROS ATUAIS NO SISTEMA        ");
        System.out.println("========================================");

        if (controller.getListaInvestigadores().isEmpty() && controller.getListaSuspeitos().isEmpty()) {
            System.out.println("O arquivo do caso está inteiramente vazio.");
            return;
        }

        for (Investigador inv : controller.getListaInvestigadores()) {
            System.out.println(inv.gerarResumoDetalhado());
        }

        for (Suspeito susp : controller.getListaSuspeitos()) {
            System.out.println(susp.gerarResumoDetalhado());
        }
    }
}