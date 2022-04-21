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
    private String firstname;
    private String lastname;
    private String phone;
    private String role;

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

}
