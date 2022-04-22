package com.nfs.bank_co.dao;

import com.nfs.bank_co.entities.Customer;

import javax.persistence.*;

public class CustomerDao {
    private EntityManager em;

    public CustomerDao() {
        em = PersistenceManager.getEmf().createEntityManager();
    }

    public Customer create(Customer c) {
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

    public Customer getOneById(int id) {
        Query query = em.createQuery("SELECT c FROM Customer AS c WHERE c.id = :id");
        query.setParameter("id", id);
        return (Customer) query.getSingleResult();
    }
    public Customer getOneByCustomerNumber(String customerNumber) {
        Query query = em.createQuery("SELECT c FROM Customer AS c WHERE c.customerNumber = :customerNumber");
        query.setParameter("customerNumber", customerNumber);
        return (Customer) query.getSingleResult();
    }
}
