package persistence;

import domain.Customer;

import javax.print.attribute.standard.PresentationDirection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class DbCustomerMapper {

    private Database database;

    public DbCustomerMapper(Database database) {
        this.database = database;
    }

    public Customer addCustomer(Customer customer) {

        boolean result = false;


        String sql = "insert into bank.customer (customer_name, customer_birthday, customer_phone, customer_address, customer_saldo) values (?,?,?,?,?)";
        try (Connection connection = database.connect()) {
            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, customer.getCustomer_name());
                ps.setString(2, customer.getCustomer_birthday());
                ps.setInt(3, customer.getCustomer_phone());
                ps.setString(4, customer.getCustomer_address());
                ps.setInt(5, customer.getCustomer_saldo());
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected >= 1) {
                    result = true;

                }
            } catch (SQLException e) {
                System.out.println("der er sket en databasefejl");

            }



        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } return customer;


    }



    }
