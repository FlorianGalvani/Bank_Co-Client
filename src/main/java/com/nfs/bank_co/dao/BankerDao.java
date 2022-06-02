package com.nfs.bank_co.dao;

import com.nfs.bank_co.entities.Account;
import com.nfs.bank_co.entities.Banker;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class BankerDao {
    private EntityManager em;

    public BankerDao() {
        em = PersistenceManager.getEmf().createEntityManager();
    }

    public Banker getOneById(int id) {
        try {
            Query query = em.createQuery("SELECT c FROM Banker AS c WHERE c.id = :id");
            query.setParameter("id", id);
            return (Banker) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
