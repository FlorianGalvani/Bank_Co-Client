package com.nfs.bank_co.dao;

import com.nfs.bank_co.entities.Account;
import com.nfs.bank_co.entities.Customer;

import javax.persistence.*;
import java.sql.SQLException;

public class AccountDao {
    private EntityManager em;

    public AccountDao() {
        em = PersistenceManager.getEmf().createEntityManager();
    }

    public Account getOneById(int id) {
        try {
            Query query = em.createQuery("SELECT c FROM Account AS c WHERE c.id = :id");
            query.setParameter("id", id);
            Account account = (Account) query.getSingleResult();
            em.refresh(account);
            return account;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void updateBalance(Account account, int amount) {
        account.setBalance(account.getBalance() + amount);
        try {
            em.getTransaction().begin();
            em.merge(account);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        em.refresh(account);
    }
}
