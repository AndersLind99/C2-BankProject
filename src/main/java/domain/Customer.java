package domain;

public class Customer {
    private int customer_id;
    private String customer_name;
    private String customer_birthday;
    private int customer_phone;
    private String customer_address;
    private int customer_saldo;

    public Customer(int customer_id, String customer_name, String customer_birthday, int customer_phone, String customer_address, int customer_saldo) {
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.customer_birthday = customer_birthday;
        this.customer_phone = customer_phone;
        this.customer_address = customer_address;
        this.customer_saldo = customer_saldo;
    }

    public Customer(String customer_name, String customer_birthday, int customer_phone, String customer_address, int customer_saldo) {

        this.customer_name = customer_name;
        this.customer_birthday = customer_birthday;
        this.customer_phone = customer_phone;
        this.customer_address = customer_address;
        this.customer_saldo = customer_saldo;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_birthday() {
        return customer_birthday;
    }

    public void setCustomer_birthday(String customer_birthday) {
        this.customer_birthday = customer_birthday;
    }

    public int getCustomer_phone() {
        return customer_phone;
    }

    public void setCustomer_phone(int customer_phone) {
        this.customer_phone = customer_phone;
    }

    public String getCustomer_address() {
        return customer_address;
    }

    public void setCustomer_address(String customer_address) {
        this.customer_address = customer_address;
    }

    public int getCustomer_saldo() {
        return customer_saldo;
    }

    public void setCustomer_saldo(int customer_saldo) {
        this.customer_saldo = customer_saldo;
    }

}
