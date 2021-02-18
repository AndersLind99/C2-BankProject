package ui;

import domain.Transaction;
import domain.BankException;
import domain.Customer;
import org.junit.jupiter.api.Test;
import persistence.Database;
import persistence.DbCustomerMapper;

import javax.swing.plaf.basic.BasicBorders;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class Menu {

    private final String USER = "bankdb_user";
    private final String PASSWORD = "1234";
    private final String URL = "jdbc:mysql://localhost:3306/bank?serverTimezone=CET&useSSL=false";

    boolean running = true;

    Database database = new Database(USER, PASSWORD, URL);
    DbCustomerMapper dbCustomerMapper = new DbCustomerMapper(database);
    Scanner scanner = new Scanner(System.in);


    public void getAllCustomers() {

        List<Customer> customerList = this.dbCustomerMapper.getAllCustomers();
        for (Customer customer : customerList) {
            System.out.println(customer.getCustomer_name());

        }

    }


    public void menuLoop() throws BankException {

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


//    private void showMenu() {
//
//        System.out.println("*********************************************");
//        System.out.println("                                             ");
//        System.out.println("                Velkommen til                ");
//        System.out.println("                Ebberød Bank                 ");
//        System.out.println("                                             ");
//        System.out.println("               skriv dit login               ");
//        System.out.println("                                             ");
//        System.out.println("*********************************************");
//
//
//
//    }

    private void showMenu() {

        System.out.println("*********************************************");
        System.out.println("                                             ");
        System.out.println("                Velkommen til                ");
        System.out.println("                Ebberød Bank                 ");
        System.out.println("                                             ");
        System.out.println("                 Konto     [1]               ");
        System.out.println("               Hæv penge   [2]               ");
        System.out.println("              Indsæt penge [3]               ");
        System.out.println("                 Exit      [4]               ");
        System.out.println("                                             ");
        System.out.println("*********************************************");

    }

    private void showKonto() {

        System.out.println("*********************************************");
        System.out.println("                                             ");
        System.out.println("  Navn: " + dbCustomerMapper.getCustomerById().getCustomer_name());
        System.out.println("                                             ");
        System.out.println("  CPR_NR: " + dbCustomerMapper.getCustomerById().getCustomer_birthday());
        System.out.println("                                             ");
        System.out.println("  Adresse: " + dbCustomerMapper.getCustomerById().getCustomer_address());
        System.out.println("                                             ");
        System.out.println("  Saldo: " + dbCustomerMapper.getCustomerById().getCustomer_saldo());
        System.out.println("                                             ");
        System.out.println("*********************************************");

    }

    private void showHævPenge() {

        System.out.println("*********************************************");
        System.out.println("                                             ");
        System.out.println("        hvor meget ønsker du at hæve?        ");
        System.out.println("                                             ");
        System.out.println("*********************************************");
        int PengeHævet = Input.getInt("");
        int a = dbCustomerMapper.getCustomerById().getCustomer_saldo() - PengeHævet;

        if (a >= 0) {
            System.out.println("du har succesfuldt hævet" + PengeHævet + " du har nu " + a + ",- på din konto");
        } else {
            System.out.println("du kan ikke hæve beløbet kontakt venligst din bank");
        }

    }

    private void showIndsætPenge() {

        System.out.println("*********************************************");
        System.out.println("*                                           *");
        System.out.println("*     Hvor meget ønsker du at indsætte?     *");
        System.out.println("*                                           *");
        System.out.println("*********************************************");
        int  PengeIndsat = Input.getInt("");
        int b = dbCustomerMapper.getCustomerById().getCustomer_saldo() + PengeIndsat;

        System.out.println("du har succesfuldt indsat" + PengeIndsat + " du har nu " + b + ",- på din konto");

    }

}



