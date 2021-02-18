package ui;

import domain.Transaction;
import domain.BankException;
import domain.Customer;
import org.junit.jupiter.api.Test;
import persistence.Database;
import persistence.DbCustomerMapper;
import persistence.DbAccountMapper;

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

    int id = 0;


    public void getAllCustomers() {

        List<Customer> customerList = this.dbCustomerMapper.getAllCustomers();
        for (Customer customer : customerList) {
            System.out.println(customer.getCustomer_name());

        }

    }

    public void login() throws BankException {
        List<Customer> customerList = dbCustomerMapper.getAllCustomers();

        showMenu();
        id = Input.getInt("");
        dbCustomerMapper.getCustomerById(id);

        for (Customer customer : customerList) {
            if (id == customer.getCustomer_id()) {
                while (running) {
                    showMainMenu();
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
                            System.out.println("Tak for i dag");
                            running = false;
                            break;
                    }
                }
            }

        }
    }



    private void showMenu() {

        System.out.println("*********************************************");
        System.out.println("                                             ");
        System.out.println("                Velkommen til                ");
        System.out.println("                Ebberød Bank                 ");
        System.out.println("                                             ");
        System.out.println("               skriv dit login               ");
        System.out.println("                                             ");
        System.out.println("*********************************************");


    }

    private void showMainMenu() {

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
        System.out.println("  Navn: " + dbCustomerMapper.getCustomerById(id).getCustomer_name());
        System.out.println("                                             ");
        System.out.println("  CPR_NR: " + dbCustomerMapper.getCustomerById(id).getCustomer_birthday());
        System.out.println("                                             ");
        System.out.println("  Telefon: " + dbCustomerMapper.getCustomerById(id).getCustomer_phone());
        System.out.println("                                             ");
        System.out.println("  Adresse: " + dbCustomerMapper.getCustomerById(id).getCustomer_address());
        System.out.println("                                             ");
        System.out.println("  Saldo: " + dbCustomerMapper.getCustomerById(id).getCustomer_saldo());
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
        int a = dbCustomerMapper.getCustomerById(id).getCustomer_saldo() - PengeHævet;

        Customer customer = null;
        try {
            customer = dbCustomerMapper.getCustomerById(id);

        } catch (Exception e){
            e.printStackTrace();
        }
        customer.setCustomer_saldo(a);
        boolean result = false;

        try {
            result = dbCustomerMapper.updateCustomer(customer);

        } catch (Exception e){

            e.printStackTrace();
        }

        if (a >= 0) {
            System.out.println("du har succesfuldt hævet " + PengeHævet + " du har nu " + a + ",- på din konto");
        } else {
            System.out.println("du kan ikke hæve beløbet kontakt venligst din bank");
        }

        running = false;

    }

    private void showIndsætPenge() {

        System.out.println("*********************************************");
        System.out.println("*                                           *");
        System.out.println("*     Hvor meget ønsker du at indsætte?     *");
        System.out.println("*                                           *");
        System.out.println("*********************************************");
        int PengeIndsat = Input.getInt("");
        int b = dbCustomerMapper.getCustomerById(id).getCustomer_saldo() + PengeIndsat;


        Customer customer = null;
        try {
            customer = dbCustomerMapper.getCustomerById(id);

        } catch (Exception e){
            e.printStackTrace();
        }
        customer.setCustomer_saldo(b);
        boolean result = false;

        try {
            result = dbCustomerMapper.updateCustomer(customer);

        } catch (Exception e){

            e.printStackTrace();
        }


        System.out.println("du har succesfuldt indsat " + PengeIndsat + " du har nu " + b + ",- på din konto");

        running = false;

    }

}



