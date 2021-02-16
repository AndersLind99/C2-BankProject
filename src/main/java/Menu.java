import org.junit.jupiter.api.Test;

public class Menu {

    private final String USER ="bankdb_user";
    private final String PASSWORD ="1234";
    private final String URL = "jdbc:mysql://localhost:3306/bank?serverTimezone=CET&useSSL=false";



    private static String menu() {

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


        return menu();
    }

}

