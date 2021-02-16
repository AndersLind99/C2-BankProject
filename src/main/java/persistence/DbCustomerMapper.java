package persistence;

import domain.Customer;

import javax.print.attribute.standard.PresentationDirection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


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

    public List<Customer> getAllCustomers(){

        List<Customer> customerList = new ArrayList<>();

        String sql = "select * from bank.customer";

        try (Connection connection = database.connect();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int customer_id = rs.getInt("customer_id");
                String customer_name = rs.getString("customer_name");
                String customer_birthday = rs.getString("customer_birthday");
                int customer_phone = rs.getInt("customer_phone");
                String customer_address = rs.getString("customer_address");
                int customer_saldo = rs.getInt("customer_saldo");
                customerList.add(new Customer(customer_id, customer_name, customer_birthday, customer_phone, customer_address, customer_saldo));
            }
        }catch (SQLException e){
            System.out.println("Fejl i connection til databasen");
            e.printStackTrace();
        }
        return customerList;
    }}


