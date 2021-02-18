package persistence;

import domain.Customer;
import domain.Transaction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbTransactionMapper{

    private Database database;
    private Object Transaction;

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

    public List<Transaction> getTransactionByCustomerId(int id) {
        Transaction transaction = null;
        String sql = "select * from bank.transaction where customer_id = ?";
        List<Transaction> transactionList = new ArrayList<>();

        try (Connection connection = database.connect()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    int transaction_id = rs.getInt("transaction_id");
                    int transaction_amount = rs.getInt("transaction_amount");
                    int customer_id = rs.getInt("customer_id");
                    Timestamp date = rs.getTimestamp("transaction_date");
                    transactionList.add(new Transaction(transaction_id,transaction_amount,customer_id,date));
                }
            } catch (SQLException throwables) {
                System.out.println("der er sket en databasefejl");
            }
        } catch (SQLException e) {
            System.out.println("der er sket en databasefejl");
        }
        return transactionList;
    }



}
