package com.nfs.bank_co.dao;

import com.nfs.bank_co.entities.Transaction;

import javax.persistence.*;

public class TransactionsDao {
    private EntityManager em;

    public TransactionsDao() {
        em = PersistenceManager.getEmf().createEntityManager();
    }

    public Transaction create(Transaction c) {
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
