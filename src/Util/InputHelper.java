package Util;

import java.util.Scanner;

public class InputHelper {
    private static Scanner scanner = new Scanner(System.in);

    public static int lerNumInt(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, insira um número inteiro válido.");
            System.out.print(prompt);
            scanner.next();
        }
        int num = scanner.nextInt();
        scanner.nextLine(); // Limpa buffer
        return num;
    }

    public static String lerTexto(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}
