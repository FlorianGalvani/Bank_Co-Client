package com.nfs.bank_co.entities;
import javax.persistence.*;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "bankers")
public class Banker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_banker")
    private int id;
    @Column(name = "B_firstname")
    private String firstname;
    @Column(name =  "B_lastname")
    private String lastname;
    private String phone;
    private String role;
    private String email;

    @OneToMany(orphanRemoval = true)
    @JoinColumn(name = "banker_id")
    private List<Customer> customers;

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPhone() {
        return phone;
    }

    public String getRole() {
        return role;
    }

    public String getEmail() {
        return email;
    }

}

// Mardi 24 11h30
// Lundi 23 15h