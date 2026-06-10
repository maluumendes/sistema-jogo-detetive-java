package Util;

import java.util.Scanner;

public class InputHelper {

    static Scanner scan = new Scanner(System.in);

    public static String lerTexto(String texto){
        System.out.println(texto);
        return scan.nextLine();
    }

    public static int lerNumInt(String texto){
        System.out.println(texto);
        return Integer.parseInt(scan.nextLine());
    }

}
