package domain;

public class Transaction {
    private int transaction_id;
    private int customer_id;
    private int transaction_amount;

    public Transaction(int transaction_id,int acccount_id, int transaction_amount) {
        this.transaction_id = transaction_id;
        this.customer_id = acccount_id;
        this.transaction_amount = transaction_amount;
    }

    public Transaction(int transaction_amount, int customer_id) {
        this.transaction_amount = transaction_amount;
        this.customer_id = customer_id;
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

}
