package com.nfs.bank_co.entities;
import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "accounts")
public class CustomerAccounts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer_account")
    private int id;
    @Column(name = "account_number")
    private String accountNumber;
    @Column(name = "account_type")
    private String accountType;
    private int balance;
    private int authorizedDebt;

//    @ManyToOne
//    private Customer owner;
//
//    @OneToMany(cascade = CascadeType.ALL)
//    private List<Transaction> transactions;

    public CustomerAccounts(String accountNumber, String accountType, int balance, int authorizedDebt) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
        this.authorizedDebt = authorizedDebt;
    }

    public CustomerAccounts() {
    }

    public int getId() {
        return id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public int getBalance() {
        return balance;
    }

    public int getAuthorizedDebt() {
        return authorizedDebt;
    }
}
