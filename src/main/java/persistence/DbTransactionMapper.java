package persistence;

import domain.Customer;
import domain.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DbTransactionMapper{

    private Database database;

    public DbTransactionMapper(Database database) {
        this.database = database;
    }

    public Transaction newTransaction(Transaction transaction) {

        boolean result = false;


        String sql = "insert into bank.transaction (transaction_amount,customer_id) values (?,?)";
        try (Connection connection = database.connect()) {
            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, transaction.getTransaction_amount());
                ps.setInt(2, transaction.getCustomer_id());
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected >= 1) {
                    result = true;

                }
            } catch (SQLException e) {
                System.out.println("der er sket en databasefejl");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } return transaction;


    }



}
