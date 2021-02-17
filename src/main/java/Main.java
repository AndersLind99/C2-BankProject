import domain.BankException;
import domain.Customer;
import persistence.Database;
import persistence.DbCustomerMapper;

import ui.Menu;
import domain.BankException;

import java.util.List;

public class Main {



    public static void main(String[] args) throws BankException {

        // created customer branch

        Menu menu = new Menu();
        menu.menuLoop();

        menu.getAllCustomers();




    }


}
