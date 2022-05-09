package com.nfs.bank_co.dao;

import com.nfs.bank_co.entities.Account;

import javax.persistence.*;
import java.sql.SQLException;

public class AccountDao {
    private EntityManager em;

    public AccountDao() {
        em = PersistenceManager.getEmf().createEntityManager();
    }

    public void updateBalance(Account account, int amount) throws SQLException {
            System.out.println("Amount before : " + account.getBalance());
            account.setBalance(account.getBalance() + amount);
            System.out.println("Amount after : " + account.getBalance());
        try {
            em.getTransaction().begin();
            em.merge(account);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }
}
