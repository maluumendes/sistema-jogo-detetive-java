package View;

import Controller.InvestigadorController;
import Model.Investigador;
import Util.InputHelper;

public class InvestigadorView {

    private InvestigadorController controller;

    public InvestigadorView(
            InvestigadorController controller) {

        this.controller = controller;
    }

    public void cadastrarInvestigador(){

        System.out.println("\n=== CADASTRO DE INVESTIGADOR ===");

        int id;

        while(true){

            try{

                id = InputHelper.lerNumInt("ID:");

                controller.validarId(id);

                break;

            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }

        String nome =
                InputHelper.lerTexto("Nome:");

        String cargo =
                InputHelper.lerTexto("Cargo:");

        String departamento =
                InputHelper.lerTexto("Departamento:");

        controller.cadastrarInvestigador(
                id,
                nome,
                cargo,
                departamento
        );

        System.out.println("Investigador cadastrado!");
    }

    public void listarInvestigadores(){

        if(controller.listarInvestigadores().isEmpty()){

            System.out.println("Não há investigadores.");
            return;
        }

        for(Investigador i :
                controller.listarInvestigadores()){

            System.out.println(
                    "ID: " + i.getId() +
                    " | Nome: " + i.getNome()
            );
        }
    }

    public void exibirDetalhes(){

        int id =
                InputHelper.lerNumInt("ID:");

        Investigador i =
                controller.buscarInvestigador(id);

        if(i != null){
            i.mostrarInfo();
        }
        else{
            System.out.println("Investigador não encontrado.");
        }
    }

    public void editarInvestigador(){

        int id =
                InputHelper.lerNumInt("ID:");

        Investigador i =
                controller.buscarInvestigador(id);

        if(i == null){

            System.out.println("Investigador não encontrado.");
            return;
        }

        int op;

        do{

            System.out.println("\n1-Nome");
            System.out.println("2-Cargo");
            System.out.println("3-Departamento");
            System.out.println("0-Voltar");

            op = InputHelper.lerNumInt("Escolha:");

            switch(op){

                case 1:

                    String nome =
                            InputHelper.lerTexto("Novo nome:");

                    controller.editarNome(id, nome);

                    break;

                case 2:

                    String cargo =
                            InputHelper.lerTexto("Novo cargo:");

                    controller.editarCargo(id, cargo);

                    break;

                case 3:

                    String dep =
                            InputHelper.lerTexto("Novo departamento:");

                    controller.editarDepartamento(id, dep);

                    break;
            }

        }while(op != 0);
    }

    public void removerInvestigador(){

        int id =
                InputHelper.lerNumInt("ID:");

        if(controller.removerInvestigador(id)){
            System.out.println("Investigador removido.");
        }
        else{
            System.out.println("Investigador não encontrado.");
        }
    }

    public void menuInvestigadores(){

        int op;

        do{

            System.out.println("\n===== INVESTIGADORES =====");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Exibir Detalhes");
            System.out.println("4 - Editar");
            System.out.println("5 - Remover");
            System.out.println("0 - Voltar");

            op = InputHelper.lerNumInt("Opção:");

            switch(op){

                case 1:
                    cadastrarInvestigador();
                    break;

                case 2:
                    listarInvestigadores();
                    break;

                case 3:
                    exibirDetalhes();
                    break;

                case 4:
                    editarInvestigador();
                    break;

                case 5:
                    removerInvestigador();
                    break;

                case 0:
                    System.out.println("Voltando...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        }while(op != 0);
    }
}
