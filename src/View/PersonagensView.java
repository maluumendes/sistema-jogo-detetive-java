package View;

import Controller.PersonagensController;
import Model.Investigador;
import Model.Suspeito;
import Util.InputHelper;

public class PersonagensView {
    private PersonagensController controller;

    public PersonagensView(PersonagensController controller) {
        this.controller = controller;
    }

    public void exibirMenuPrincipal() {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n========= MÓDULO: PERSONAGENS E CASOS =========");
            System.out.println("1. Cadastrar Investigador");
            System.out.println("2. Cadastrar Suspeito");
            System.out.println("3. Abrir Novo Caso (Vincular Investigador)");
            System.out.println("4. Encerrar/Desvincular Caso por ID");
            System.out.println("5. Listar Envolvidos (Relatório Geral)");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.println("===============================================");
            
            opcao = InputHelper.lerNumInt("Escolha uma opção: ");
            controller.processarOpcaoMenu(opcao, this);
        }
    }

    public void cadastrarInvestigador() {
        System.out.println("\n--- NOVO INVESTIGADOR ---");
        int id = InputHelper.lerNumInt("ID Numérico único: ");
        
        if (controller.buscarInvestigadorPorId(id) != null) {
            System.out.println("❌ Erro: Já existe um investigador com este ID!");
            return;
        }

        String nome = InputHelper.lerTexto("Nome do Investigador: ");
        String ocupacao = InputHelper.lerTexto("Cargo/Posto atual: ");
        int idade = InputHelper.lerNumInt("Idade: ");
        int limiteCasos = InputHelper.lerNumInt("Limite de casos simultâneos: ");
        String metodo = InputHelper.lerTexto("Método de investigação: ");
        String itemFavorito = InputHelper.lerTexto("Item de investigação favorito: ");

        controller.cadastrarInvestigador(id, nome, ocupacao, idade, limiteCasos, 0, metodo, itemFavorito);
        System.out.println("✓ Investigador registrado e salvo com sucesso!");
    }

    public void cadastrarSuspeito() {
        System.out.println("\n--- NOVO SUSPEITO ---");
        int id = InputHelper.lerNumInt("ID Numérico único: ");

        if (controller.buscarSuspeitoPorId(id) != null) {
            System.out.println("❌ Erro: Já existe um suspeito com este ID!");
            return;
        }

        String nome = InputHelper.lerTexto("Nome do Suspeito: ");
        String ocupacao = InputHelper.lerTexto("Profissão/Ocupação: ");
        int idade = InputHelper.lerNumInt("Idade: ");
        String alibi = InputHelper.lerTexto("Álibi apresentado: ");
        String relacao = InputHelper.lerTexto("Relação com a vítima: ");
        
        System.out.println("Possui antecedentes criminais?");
        System.out.println("1 - Sim\n2 - Não");
        int antOp = InputHelper.lerNumInt("Escolha: ");
        boolean antecedentes = (antOp == 1);

        controller.cadastrarSuspeito(id, nome, ocupacao, idade, alibi, relacao, antecedentes);
        System.out.println("✓ Ficha do suspeito arquivada e salva!");
    }

    public void solicitarAberturaCaso() {
        System.out.println("\n--- ABERTURA DE CASO RÁPIDO ---");
        if (controller.getListaInvestigadores().isEmpty()) {
            System.out.println("❌ Não é possível abrir casos sem investigadores cadastrados!");
            return;
        }

        int idCaso = InputHelper.lerNumInt("Digite o ID do Novo Caso: ");
        String titulo = InputHelper.lerTexto("Título ou Nome do Caso: ");
        
        System.out.println("\nInvestigadores Disponíveis:");
        for (Investigador inv : controller.getListaInvestigadores()) {
            System.out.println("ID: " + inv.getId() + " - " + inv.getNome() + " (Casos ativos: " + inv.getCasosAtivosAtuais() + "/" + inv.getLimiteCasosSimultaneos() + ")");
        }
        
        int idInv = InputHelper.lerNumInt("Digite o ID do Investigador responsável: ");
        Investigador invEscolhido = controller.buscarInvestigadorPorId(idInv);

        if (invEscolhido == null) {
            System.out.println("❌ Investigador não encontrado!");
            return;
        }

        boolean sucesso = controller.criarCaso(idCaso, titulo, invEscolhido);
        if (sucesso) {
            System.out.println("✓ Caso ID " + idCaso + " aberto e atribuído ao detetive " + invEscolhido.getNome() + "!");
        } else {
            System.out.println("❌ Falha: O investigador atingiu o limite de casos permitidos!");
        }
    }

    public void solicitarEncerramentoCaso() {
        System.out.println("\n--- ENCERRAMENTO DE CASO ---");
        int idDigitado = InputHelper.lerNumInt("Digite o ID do caso que deseja encerrar: ");

        boolean sucesso = controller.verificarEDesvincularPorId(idDigitado);
        if (sucesso) {
            System.out.println("✓ Caso encerrado! O investigador associado foi liberado de uma carga de trabalho.");
        } else {
            System.out.println("❌ Erro: Nenhum caso ativo com o ID " + idDigitado + " foi localizado.");
        }
    }

    public void mostrarRelatorioGeral() {
        System.out.println("\n========================================================");
        System.out.println("               REGISTROS GERAIS DO DISTRITO             ");
        System.out.println("========================================================");

        System.out.println("\n--- DETETIVES DA CORPORAÇÃO ---");
        if (controller.getListaInvestigadores().isEmpty()) System.out.println("Nenhum detetive na lista.");
        for (Investigador inv : controller.getListaInvestigadores()) {
            System.out.println(inv.gerarResumoDetalhado());
        }

        System.out.println("\n--- FICHA DE SUSPEITOS ---");
        if (controller.getListaSuspeitos().isEmpty()) System.out.println("Nenhum suspeito fichado.");
        for (Suspeito susp : controller.getListaSuspeitos()) {
            System.out.println(susp.gerarResumoDetalhado());
        }

        System.out.println("\n--- CASOS EM ANDAMENTO ---");
        if (controller.getListaCasos().isEmpty()) System.out.println("Nenhum caso ativo.");
        for (Caso c : controller.getListaCasos()) {
            c.mostrarInfo();
        }
        System.out.println("========================================================");
    }
}
