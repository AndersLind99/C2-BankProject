package ui;

import domain.BankException;
import jdk.internal.util.xml.impl.Input;
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
            while (Input.getInt("hvad ønsker du?")) {

            case 1:
                showKonto();
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


}

