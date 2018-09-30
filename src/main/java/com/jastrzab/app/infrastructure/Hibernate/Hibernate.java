package com.jastrzab.app.infrastructure.Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Hibernate {

    private EntityManagerFactory entityManagerFactory;

    public Hibernate() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("my-persistence-unit");
    }

    public EntityManager getEntityManager() {
        return this.entityManagerFactory.createEntityManager();
    }

    /**
     * Create EntityManager
     * then open transaction
     * then execute transaction
     * then close transaction and close EntityManager
     * @param transaction transaction to execute
     */
    public void executeWithTransaction(Transaction transaction) {
        final EntityManager entityManager = this.getEntityManager();
        entityManager.getTransaction().begin();
        transaction.execute(entityManager);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    /**
     * Create EntityManager
     * then execute transaction and close EntityManager
     *
     * @param transaction transaction to execute
     */
    public void execute(Transaction transaction) {
        final EntityManager entityManager = this.getEntityManager();
        transaction.execute(entityManager);
        entityManager.close();
    }

    public void closeFactory() {
        this.entityManagerFactory.close();
    }
}
