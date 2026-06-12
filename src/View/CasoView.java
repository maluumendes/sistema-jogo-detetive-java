package View;

import Controller.CasoController;
import Controller.InvestigadorController;
import Model.Caso;
import Model.Investigador;
import Model.Pista;
import Util.InputHelper;

public class CasoView {


    private CasoController casoController = new CasoController();
    private InvestigadorController investigadorController;

    public CasoView(CasoController casoController, InvestigadorController investigadorController) {
        this.casoController = casoController;
        this.investigadorController = investigadorController;
    }

    public void cadastrarCaso(){

        if(investigadorController.listarInvestigadores().isEmpty()){
            System.out.println("Cadastre um investigador antes de criar um caso.");
            return;
        }

        System.out.println("=== CADASTRO DE CASO ===\n");
        int id;

        while(true) {
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

        System.out.println("\nInvestigadores disponíveis: ");

        //LISTAR INVESTIGADORES

        //controller.adicionarCaso(id, titulo, descricao, localCrime, dataCrime, status, investigadores);

    }

    public void listarCaso(){
        if(casoController.listarCaso().isEmpty()){
            System.out.println("Não há casos registrados!");
            return;
        }

        for (Caso c : casoController.listarCaso()) {
            System.out.println("ID: " + c.getId() + " | " + c.getTitulo() + " | " + c.getStatus());
        }
    }

    public void editarCaso(){
        int id = InputHelper.lerNumInt("Informe o ID do caso que deseja editar: ");

        Caso c = casoController.buscarCaso(id);

        if(c != null) {
            int op;
            do {
                System.out.println("=== EDITAR CASO ===\n");
                System.out.println("1 - Título \n2 - Descrição \n3 - Local do Crime \n4 - Data \n5 - Status \n0 - Voltar");

                op = InputHelper.lerNumInt("\n>> Escolha: ");

                switch (op) {
                    case 1:
                        System.out.println("Título atual: " + c.getTitulo());
                        String titulo = InputHelper.lerTexto("> Novo Título: ");

                        if(casoController.editarTitulo(id, titulo)){
                            System.out.println("Título atualizado!");
                        }else{
                            System.out.println("Erro ao atualizar!");
                        }

                        break;

                    case 2:
                        System.out.println("Descrição atual: " + c.getDescricao());
                        String descricao = InputHelper.lerTexto("> Nova Descrição: ");

                        if(casoController.editarDescricao(id, descricao)){
                            System.out.println("Descrição atualizada!");
                        }else{
                            System.out.println("Erro ao atualizar!");
                        }

                        break;

                    case 3:
                        System.out.println("Local do Crime atual: " + c.getLocalCrime());
                        String localCrime = InputHelper.lerTexto("> Novo Local do Crime: ");

                        if(casoController.editarLocalCrime(id, localCrime)){
                            System.out.println("Local do crime atualizado!");
                        }else{
                            System.out.println("Erro ao atualizar!");
                        }

                        break;

                    case 4:
                        System.out.println("Data do Crime atual: " + c.getDataCrime());
                        String dataCrime = InputHelper.lerTexto("> Nova Data do Crime: ");

                        if(casoController.editarDataCrime(id, dataCrime)){
                            System.out.println("Data do crime atualizada!");
                        }else{
                            System.out.println("Erro ao atualizar!");
                        }

                        break;

                    case 5:
                        System.out.println("Status atual: " + c.getStatus());
                        String status = InputHelper.lerTexto("> Novo Status: ");

                        if(casoController.editarStatus(id, status)){
                            System.out.println("Status atualizado!");
                        }else{
                            System.out.println("Erro ao atualizar!");
                        }

                        break;

                    case 0:
                        break;

                    default:
                        System.out.println("Opção inválida!");
                        break;
                }
            } while (op != 0);
        } else {
            System.out.println("Caso não encontrado!");
        }
    }

    public void removerCaso(){
        int id = InputHelper.lerNumInt("Informe o ID do caso que deseja remover: ");

        if(!casoController.removerCaso(id)){
            System.out.println("Caso não encontrado!");
        } else {
            System.out.println("Caso removido!");
        }
    }


    public void exibirDetalhes(){
        int id = InputHelper.lerNumInt("Informe o ID do caso: ");

        Caso c = casoController.buscarCaso(id);

        if(c != null){
            c.mostrarInfo();
        } else {
            System.out.println("Caso não encontrado!");
        }
    }


    public void menuCasos(){
        int op;

        do {


            System.out.println("\n========================");
            System.out.println("     MENU CASOS");
            System.out.println("\n========================");
            System.out.println("1 - Cadastrar Caso");
            System.out.println("2 - Listar Casos");
            System.out.println("3 - Exibir Detalhes");
            System.out.println("4 - Editar Caso");
            System.out.println("5 - Gerenciar Pistas");
            System.out.println("6 - Remover Caso");
            System.out.println("0 - Voltar");
            System.out.println("=========================");

            op = InputHelper.lerNumInt(">> Opção: ");

            verificarOp(op);
        } while (op != 0);
    }

   public void verificarOp(int op){

    switch (op) {

        case 1:
            cadastrarCaso();
            break;

        case 2:
            listarCaso();
            break;

        case 3:
            exibirDetalhes();
            break;

        case 4:
            editarCaso();
            break;

        case 5:
            menuPistas();
            break;

        case 6:
            removerCaso();
            break;

        case 0:
            System.out.println("Voltando...");
            break;

        default:
            System.out.println("Opção inválida!");
            break;
        }
    }
    
    public void cadastrarPista(int idCaso){

        int id = InputHelper.lerNumInt("ID da pista: ");

        String descricao = InputHelper.lerTexto("Descrição: ");

        String local = InputHelper.lerTexto("Local encontrada: ");

        Pista pista = new Pista(id, descricao, local);

        if(casoController.adicionarPista(idCaso, pista)){
            System.out.println("Pista cadastrada!");
        }
    }
    
    public void listarPistas(int idCaso){

        Caso caso = casoController.buscarCaso(idCaso);

        if(caso.getPistas().isEmpty()){

            System.out.println("Nenhuma pista cadastrada.");
                return;
        }

        for(Pista p : caso.getPistas()){
            System.out.println(p);
        }
    }

    public void editarPista(int idCaso){

        int idPista = InputHelper.lerNumInt("ID da pista: ");

        String descricao = InputHelper.lerTexto("Nova descrição: ");

        if(casoController.editarPista(idCaso, idPista, descricao)){
            System.out.println("Pista atualizada!");
        }else{
            System.out.println("Pista não encontrada!");
        }
    }

    public void removerPista(int idCaso){

        int idPista = InputHelper.lerNumInt("ID da pista: ");

        if(casoController.removerPista(idCaso, idPista)){
            System.out.println("Pista removida!");
        }else{
            System.out.println("Pista não encontrada!");
        }
    }

    public void menuPistas(){

        int idCaso = InputHelper.lerNumInt("ID do caso: ");

        Caso caso = casoController.buscarCaso(idCaso);

        if(caso == null){

            System.out.println("Caso não encontrado!");
            return;
        }

        int op;

        do{

            System.out.println("\n=== MENU PISTAS ===");
            System.out.println("1 - Cadastrar pista");
            System.out.println("2 - Listar pistas");
            System.out.println("3 - Editar pista");
            System.out.println("4 - Remover pista");
            System.out.println("0 - Voltar");

            op = InputHelper.lerNumInt(">> ");

            switch(op){

                case 1:
                    cadastrarPista(idCaso);
                    break;

                case 2:
                    listarPistas(idCaso);
                    break;

                case 3:
                    editarPista(idCaso);
                    break;

                case 4:
                    removerPista(idCaso);
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        }while(op != 0);
    }

}
