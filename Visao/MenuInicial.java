package Trabalho.Visao;

import java.util.Scanner;
public class MenuInicial {
    int op;
    boolean stop;
    public MenuInicial (Scanner scn){
        stop = true;
        while (stop){
            System.out.println("\nMENU INICIAL:");
            System.out.println("\t0 - Para sair");
            System.out.println("\t1 - Para Iniciar Cinema");
            System.out.print("\n\tOpcao: ");
            op = scn.nextInt();
            switch (op) {
                case 0 -> stop = false;
                case 1 -> new Menu2(scn);
                default -> System.out.println("\n" + Character.toString(100_62) + " Opcao invalida!\n");
            }
        }
    }
}
