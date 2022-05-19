package com.nfs.bank_co.dao;

import com.nfs.bank_co.entities.Customer;
import com.nfs.bank_co.entities.DashboardView;

import javax.persistence.*;
import java.util.List;

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

    public List getViewsByCustomerNumber(String customerNumber) {
//        Query query = em.createNativeQuery("SELECT * FROM customer_dashboard WHERE c.customerNumber = :customerNumber");
        Query query = em.createQuery("SELECT c FROM DashboardView AS c WHERE c.customerNumber = :customerNumber");
        query.setParameter("customerNumber", customerNumber);
        return query.getResultList();
    }
    public List getViewsByCustomerNumber(List<DashboardView> dashboardView) {
        for (DashboardView view : dashboardView) {
            em.refresh(view);
        }
        Query query = em.createQuery("SELECT c FROM DashboardView AS c WHERE c.customerNumber = :customerNumber");
        query.setParameter("customerNumber",  dashboardView.get(0).getCustomerNumber());
        return query.getResultList();
    }

    public boolean isEmailAlreadyInUse(String email){
        boolean result = true;
        Query query = em.createQuery("SELECT c FROM Customer AS c WHERE c.email = :email");
        query.setParameter("email", email);
        Customer customer;
        try {
            customer = (Customer) query.getSingleResult();
            if (customer != null) {
                result = true;
            }
        } catch (NoResultException e) {
            result = false;
        }
        return result;
    }

    public boolean updateIsNewCustomerState(Customer customer) {
        boolean success = false;
        customer.setNewCustomer(false);

        try {
            em.getTransaction().begin();
            em.merge(customer);
            em.getTransaction().commit();
            success = true;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return success;
    }
    public boolean updatePassword(Customer customer,String hash) {
        boolean success = false;
        customer.setPassword(hash);
        try {
            em.getTransaction().begin();
            em.merge(customer);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return success;
    }

}
