package com.nfs.bank_co.dao;

import com.nfs.bank_co.entities.NewCustomerRequest;

import javax.persistence.*;

public class NewCustomerRequestDao {
    private EntityManager em;

    public NewCustomerRequestDao() {
        em = PersistenceManager.getEmf().createEntityManager();
    }

    public NewCustomerRequest create(NewCustomerRequest c) {
        try {
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return c;
    }
}
