package com.nfs.bank_co.dao;

import com.nfs.bank_co.entities.Customer;

import javax.persistence.*;

public class CustomerDao {
    private EntityManager em;

    public CustomerDao() {
        em = PersistenceManager.getEmf().createEntityManager();
    }

    public Customer findOneById(int id) {
        Query query = em.createQuery("SELECT c FROM Customer AS c WHERE c.id = :id");
        query.setParameter("id", id);
        return (Customer) query.getSingleResult();
    }

    public Customer getOneByCustomerNumber(String customerNumber) {
        Query query = em.createQuery("SELECT c FROM Customer AS c WHERE c.customerNumber = :customerNumber");
        query.setParameter("customerNumber", customerNumber);
        return (Customer) query.getSingleResult();
    }

    public boolean isEmailAlreadyInUse(String email){
        Query query = em.createQuery("SELECT c FROM Customer AS c WHERE c.email = :email");
        query.setParameter("email", email);
        Customer customer = (Customer) query.getSingleResult();
        if (query != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean updateNewCustomerState(Customer customer) {
        customer.setNewCustomer(false);
        try {
            em.getTransaction().begin();
            em.merge(customer);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return true;
    }
}
