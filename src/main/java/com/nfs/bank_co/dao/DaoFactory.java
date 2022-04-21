package com.nfs.bank_co.dao;

public class DaoFactory {
   private static TransactionsDao transactionDao;
    private static NewCustomerRequestDao newCustomerRequestDao;

    private DaoFactory(){}

    public static TransactionsDao getTransactionDao() {
        if (transactionDao == null) {
            transactionDao  = new TransactionsDao();
        }
        return transactionDao;
    }
    public static NewCustomerRequestDao getNewCustomerRequestDao() {
        if (newCustomerRequestDao == null) {
            newCustomerRequestDao  = new NewCustomerRequestDao();
        }
        return newCustomerRequestDao;
    }


}
