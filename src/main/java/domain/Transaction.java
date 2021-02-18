package domain;

import java.sql.Timestamp;

public class Transaction {
    private int transaction_id;
    private int transaction_amount;
    private int customer_id;
    private Timestamp date;

    public Transaction(int transaction_id, int transaction_amount,int customer_id,Timestamp date ) {
        this.transaction_id = transaction_id;
        this.transaction_amount = transaction_amount;
        this.customer_id = customer_id;
        this.date = date;
    }

    public Transaction(int transaction_amount, int customer_id) {
        this.transaction_amount = transaction_amount;
        this.customer_id = customer_id;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public int getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int acccount_id) {
        this.customer_id = acccount_id;
    }

    public int getTransaction_amount() {
        return transaction_amount;
    }

    public void setTransaction_amount(int transaction_amount) {
        this.transaction_amount = transaction_amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transaction_id=" + transaction_id +
                ", transaction_amount=" + transaction_amount +
                ", customer_id=" + customer_id +
                '}';
    }
}
