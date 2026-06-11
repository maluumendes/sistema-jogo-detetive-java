import view.InterrogatorioView;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InterrogatorioView viewInterrogatorio = new InterrogatorioView();

        int opcao;
        do {
            System.out.println("\n=================================");
            System.out.println("  JOGO DE DETETIVE  ");
            System.out.println("=================================");
            System.out.println("1. Menu Casos ");
            System.out.println("2. Menu Suspeitos ");
            System.out.println("3. Menu Pistas");
            System.out.println("4. Menu Investigadores ");
            System.out.println("5. Menu Interrogatórios ");
            System.out.println("0. Sair do Sistema");
            System.out.print("Escolha o módulo: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> System.out.println("[Integração] Chamar viewCaso aqui.");
                case 2 -> System.out.println("[Integração] Chamar viewSuspeito aqui.");
                case 3 -> System.out.println("[Integração] Chamar viewPista aqui.");
                case 4 -> System.out.println("[Integração] Chamar viewInvestigador aqui.");
                case 5 -> viewInterrogatorio.menuInterrogatorios();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
