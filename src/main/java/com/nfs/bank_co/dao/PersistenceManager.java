package com.nfs.bank_co.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceManager {
    private static EntityManagerFactory emf;

    private PersistenceManager(){};

    public static EntityManagerFactory getEmf() {
        if(emf == null)
            emf = Persistence.createEntityManagerFactory("bank_coPU");
        return emf;
    }
}