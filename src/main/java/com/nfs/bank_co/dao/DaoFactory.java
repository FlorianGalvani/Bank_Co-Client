package com.nfs.bank_co.dao;

public class DaoFactory {
   private static TransactionsDao transactionDao;
    private static NewCustomerRequestDao newCustomerRequestDao;
    private static CustomerDao customerDao;
    private static AccountDao accountDao;

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

    public static CustomerDao getCustomerDao() {
        if (customerDao == null) {
            customerDao  = new CustomerDao();
        }
        return customerDao;
    }

    public static AccountDao getAccountDao() {
        if (accountDao == null) {
            accountDao = new AccountDao();
        }
        return accountDao;
    }
}
