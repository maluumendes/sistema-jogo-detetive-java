import Controller.CasoController;
import Controller.InvestigadorController;
import Controller.SuspeitoController;
import View.CasoView;
import View.InterrogatorioView;
import View.InvestigadorView;
import View.SuspeitoView;
import Util.InputHelper;

public class Main {
    public static void main(String[] args) {
        InvestigadorController investigadorController = new InvestigadorController();
        CasoController casoController = new CasoController();
        SuspeitoController suspeitoController = new SuspeitoController();

        InvestigadorView investigadorView = new InvestigadorView(investigadorController);
        CasoView casoView = new CasoView(casoController, investigadorController);
        SuspeitoView suspeitoView = new SuspeitoView(suspeitoController);
        InterrogatorioView interrogatorioView = new InterrogatorioView();

        int opcao;
        do {
            System.out.println("\n=================================");
            System.out.println("       SISTEMA DETETIVE v2       ");
            System.out.println("=================================");
            System.out.println("1. Menu de Casos");
            System.out.println("2. Menu de Investigadores");
            System.out.println("3. Menu de Suspeitos");
            System.out.println("4. Menu de Interrogatórios");
            System.out.println("0. Sair do Sistema");
            System.out.println("=================================");
            
            opcao = InputHelper.lerNumInt("Escolha o módulo: ");

            switch (opcao) {
                case 1 -> casoView.menuCasos();
                case 2 -> investigadorView.menuInvestigadores();
                case 3 -> suspeitoView.menuSuspeitos();
                case 4 -> interrogatorioView.menuInterrogatorios();
                case 0 -> System.out.println("Desligando terminais do distrito central...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }
}
