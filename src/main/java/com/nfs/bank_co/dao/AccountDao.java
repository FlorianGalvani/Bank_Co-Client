package com.nfs.bank_co.dao;

import com.nfs.bank_co.entities.Account;

import javax.persistence.*;
import java.sql.SQLException;

public class AccountDao {
    private EntityManager em;

    public AccountDao() {
        em = PersistenceManager.getEmf().createEntityManager();
    }

    public Account create(Account c) {
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

    public void updateBalance(Account account, int amount) throws SQLException {
        //TODO Mise a jour du solde du compte
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


//        Query query = em.createQuery("UPDATE Account AS a SET a.balance = :newBalance WHERE a.id = :id");
//        query.setParameter("id", id);
//        query.setParameter("newBalance", currentBalance + amount);
    }

    public Account getOneByCustomerNumber(String customerNumber) {
        Query query = em.createQuery("SELECT c FROM Customer AS c WHERE c.customerNumber = :customerNumber");
        query.setParameter("customerNumber", customerNumber);
        return (Account) query.getSingleResult();
    }
}
