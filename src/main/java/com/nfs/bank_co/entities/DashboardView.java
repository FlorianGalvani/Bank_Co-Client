package com.nfs.bank_co.entities;


import org.hibernate.annotations.Immutable;
import javax.persistence.*;

@Entity
@Immutable
@Table(name="customer_dashboardd")
public class DashboardView implements java.io.Serializable {
    private String C_firstname; //Ok
    private String C_lastname; //Ok
    @Id
    private int id_customer; //Ok
    private float balance; //Ok
    private int authorized_debt; //Ok
    private String account_type; //Ok
    private int id_customer_account; //Ok
    private String B_firstname; //Ok
    private String B_lastname; //Ok
    private String customerNumber; //Ok
    @Id
    private String account_number; //Ok
    private int id_banker; //Ok
    private boolean is_new_customer;

    public String getC_firstname() {
        return C_firstname;
    }

    public void setC_firstname(String c_firstname) {
        C_firstname = c_firstname;
    }

    public String getC_lastname() {
        return C_lastname;
    }

    public void setC_lastname(String c_lastname) {
        C_lastname = c_lastname;
    }

    public int getId_customer() {
        return id_customer;
    }

    public void setId_customer(int id_customer) {
        this.id_customer = id_customer;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public int getAuthorized_debt() {
        return authorized_debt;
    }

    public void setAuthorized_debt(int authorized_debt) {
        this.authorized_debt = authorized_debt;
    }

    public String getAccount_type() {
        return account_type;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }

    public int getId_customer_account() {
        return id_customer_account;
    }

    public void setId_customer_account(int id_customer_account) {
        this.id_customer_account = id_customer_account;
    }

    public String getB_firstname() {
        return B_firstname;
    }

    public void setB_firstname(String b_firstname) {
        B_firstname = b_firstname;
    }

    public String getB_lastname() {
        return B_lastname;
    }

    public void setB_lastname(String b_lastname) {
        B_lastname = b_lastname;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public int getId_banker() {
        return id_banker;
    }

    public void setId_banker(int id_banker) {
        this.id_banker = id_banker;
    }

    public boolean isIs_new_customer() {
        return is_new_customer;
    }

    public void setIs_new_customer(boolean is_new_customer) {
        this.is_new_customer = is_new_customer;
    }
}


