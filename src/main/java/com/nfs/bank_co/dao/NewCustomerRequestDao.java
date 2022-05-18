package com.nfs.bank_co.dao;

import com.nfs.bank_co.entities.Customer;
import com.nfs.bank_co.entities.NewCustomerRequest;

import javax.persistence.*;

public class NewCustomerRequestDao {
    private final EntityManager em;

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
    public boolean isEmailAlreadyInUse(String email){
        //FIXME Verifier si l'addresse email n'est pas déja utilisée par un Client déja inscrit
        boolean result = true;
        Query query = em.createQuery("SELECT c FROM NewCustomerRequest AS c WHERE c.email = :email");
        query.setParameter("email", email);
        NewCustomerRequest newCustomerRequest;
        try {
            newCustomerRequest = (NewCustomerRequest) query.getSingleResult();
            if (newCustomerRequest != null) {
                result = true;
            }
        } catch (NoResultException e) {
            result = false;
        }
        return result;
    }
}
