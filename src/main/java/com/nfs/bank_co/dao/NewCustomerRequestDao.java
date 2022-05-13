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
    public boolean isEmailAlreadyInUse(String email) {
        boolean result;
        return false;
        //FIXME Verifier si l'addrese email n'est pas déja utilisé par une autre demande d'ouverture de compte.
//        Query query = em.createQuery("SELECT c FROM NewCustomerRequest AS c WHERE c.email = :email", NewCustomerRequest.class);
//        query.setParameter("email", email);
//        NewCustomerRequest newCustomerRequest = (NewCustomerRequest) query.getSingleResult();
//        if (newCustomerRequest != null) {
//            return true;
//
//        } else {
//            return false;
//        }

    }
}
