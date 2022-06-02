package com.nfs.bank_co.entities;


import org.hibernate.annotations.Immutable;

import javax.persistence.*;

@Entity
@Immutable
@Table(name = "customer_dashboardd")
public class DashboardView implements java.io.Serializable {
    @Id
    @Column(name = "id_customer")
    private int customerId; //Ok
    @Column(name = "C_firstname")
    private String customerFirstname; //Ok
    @Column(name = "C_lastname")
    private String customerLastname; //Ok
    @Column(name = "customer_number")
    private String customerNumber; //Ok
    @Column(name = "is_new_customer")
    private boolean isNewCustomer;
    @Column(name = "id_customer_account")
    private int accountId; //Ok
    @Id
    @Column(name = "account_number")
    private String accountNumber; //Ok
    private float balance; //Ok
    @Column(name = "authorized_debt")
    private int authorizedDebt; //Ok
    @Column(name = "account_type")
    private String accountType; //Ok
    @Column(name = "id_banker")
    private int bankerId; //Ok
    @Column(name = "B_firstname")
    private String bankerFirstname; //Ok
    @Column(name = "B_lastname")
    private String bankerLastname; //Ok

    @Column(name = "B_phone")
    private String bankerPhone; //Ok

    @Column(name = "B_email")
    private String bankerEmail; //Ok

    public int getCustomerId() {
        return customerId;
    }

    public String getCustomerFirstname() {
        return customerFirstname;
    }

    public String getCustomerLastname() {
        return customerLastname;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public boolean getIsNewCustomer() {
        return isNewCustomer;
    }

    public int getAccountId() {
        return accountId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public float getBalance() {
        return balance;
    }

    public int getAuthorizedDebt() {
        return authorizedDebt;
    }

    public String getAccountType() {
        return accountType;
    }

    public int getBankerId() {
        return bankerId;
    }

    public String getBankerFirstname() {
        return bankerFirstname;
    }

    public String getBankerLastname() {
        return bankerLastname;
    }

    public String getBankerPhone() {
        return bankerPhone;
    }

    public void setBankerPhone(String bankerPhone) {
        this.bankerPhone = bankerPhone;
    }

    public String getBankerEmail() {
        return bankerEmail;
    }

    public void setBankerEmail(String bankerEmail) {
        this.bankerEmail = bankerEmail;
    }
}

/*
SELECT
    `bankco`.`customers`.`id_customer` AS `id_customer`,
    `bankco`.`customers`.`firstname` AS `C_firstname`,
    `bankco`.`customers`.`lastname` AS `C_lastname`,
    `bankco`.`customers`.`customer_number` AS `customer_number`,
    `bankco`.`customers`.`is_new_customer` AS `is_new_customer`,
    `bankco`.`accounts`.`id_customer_account` AS `id_customer_account`,
    `bankco`.`accounts`.`account_number` AS `account_number`,
    `bankco`.`accounts`.`account_type` AS `account_type`,
    `bankco`.`accounts`.`authorized_debt` AS `authorized_debt`,
    `bankco`.`accounts`.`balance` AS `balance`,
    `bankco`.`bankers`.`id_banker` AS `id_banker`,
    `bankco`.`bankers`.`firstname` AS `B_firstname`,
    `bankco`.`bankers`.`lastname` AS `B_lastname`
FROM
    (
        (
            `bankco`.`customers`
        JOIN `bankco`.`accounts`
        )
    JOIN `bankco`.`bankers`
    )
WHERE
    (
        (
            `bankco`.`accounts`.`customer_id` = `bankco`.`customers`.`id_customer`
        ) AND(
            `bankco`.`customers`.`banker_id` = `bankco`.`bankers`.`id_banker`
        )
    )
 */

