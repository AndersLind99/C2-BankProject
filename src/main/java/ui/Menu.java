package ui;


import domain.BankException;
import org.junit.jupiter.api.Test;

import javax.swing.plaf.basic.BasicBorders;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Menu {

    //private final String USER = "bankdb_user";
    //private final String PASSWORD = "1234";
    //private final String URL =

    boolean running = true;

    private void mainMenuLoop() throws BankException {

        while (running) {
            showMenu();
            switch (Input.getInt("Vælg hvad du vil")) {
                case 1:
                    showKonto();
                    break;
                case 2:
                    showHævPenge();
                    break;
                case 3:
                    showIndsætPenge();
                    break;
                case 4:
                    running = false;
                    break;


            }
        }


    }

    private void showMenu() {

        System.out.println("*********************************************");
        System.out.println("*                                           *");
        System.out.println("*               Velkommen til               *");
        System.out.println("*               Ebberød Bank                *");
        System.out.println("*                                           *");
        System.out.println("*                                           *");
        System.out.println("*                Konto     [1]              *");
        System.out.println("*              Hæv penge   [2]              *");
        System.out.println("*             Indsæt penge [3]              *");
        System.out.println("*                Exit      [4]              *");
        System.out.println("*                                           *");
        System.out.println("*                                           *");
        System.out.println("*********************************************");

    }

    private void showKonto() {

        System.out.println("*********************************************");
        System.out.println("*                                           *");
        System.out.println("* Navn:                                     *");
        System.out.println("*                                           *");
        System.out.println("* CPR_NR:                                   *");
        System.out.println("*                                           *");
        System.out.println("* Adresse:                                  *");
        System.out.println("*                                           *");
        System.out.println("* Saldo:                                    *");
        System.out.println("*                                           *");
        System.out.println("*                                           *");
        System.out.println("*                [0] Tilbage                *");
        System.out.println("*********************************************");

    }

    private void showHævPenge() {

        System.out.println("*********************************************");
        System.out.println("*                                           *");
        System.out.println("*       Hvor meget ønsker du at hæve?       *");
        System.out.println("*                                           *");
        System.out.println("*                [0] Tilbage                *");
        System.out.println("*                                           *");
        System.out.println("*********************************************");

    }

    private void showIndsætPenge() {

        System.out.println("*********************************************");
        System.out.println("*                                           *");
        System.out.println("*     Hvor meget ønsker du at indsætte?     *");
        System.out.println("*                                           *");
        System.out.println("*                [0] Tilbage                *");
        System.out.println("*                                           *");
        System.out.println("*********************************************");

    }

}

