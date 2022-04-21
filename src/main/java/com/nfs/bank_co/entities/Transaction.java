package com.nfs.bank_co.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transaction")
    private int id;
    private Date date;
    private int amount;
    private String description;

    @ManyToOne
    @JoinColumn(name = "from_account")
    private CustomerAccounts fromAccount;

    @ManyToOne
    @JoinColumn(name = "to_account")
    private CustomerAccounts toAccount;

    public Transaction(Date date, CustomerAccounts fromAccount, CustomerAccounts toAccount, int amount, String description) {
        this.date = date;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
        this.description = description;
    }

    public Transaction() {

    }
}
