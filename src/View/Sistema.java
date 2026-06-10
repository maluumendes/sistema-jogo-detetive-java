package View;

import Util.InputHelper;

public class Sistema {

    private CasoView casoView;

    public void executar() {

        int op;

        do{

            System.out.println("\n==== SISTEMA DETETIVE ====");
            System.out.println("1 - Casos");
            System.out.println("2 - Investigadores");
            System.out.println("3 - Suspeitos");
            System.out.println("0 - Sair");

            op = InputHelper.lerNumInt(">> Opção: ");
            verificarOp(op);
        } while (op != 0);
    }

    public void verificarOp(int op){
        switch (op){
            case 1:
                casoView.menuCasos();
                break;

            //ADICIONAR OUTROS CASES

            case 0:
                System.out.println("Deseja manter os dados?");
                System.out.println("1 - SIM \n0 - NÃO");

                int escolha = InputHelper.lerNumInt(">> ");

                if (escolha == 0){
                    persistencia.limparArquivos();
                }

                break;
        }
    }
}
