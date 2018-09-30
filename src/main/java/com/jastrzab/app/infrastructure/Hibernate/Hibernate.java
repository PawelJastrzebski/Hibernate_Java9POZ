package com.jastrzab.app.infrastructure;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;

public class Hibernate {

    private EntityManagerFactory entityManagerFactory;

    public Hibernate() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("my-persistence-unit");
    }
    public EntityManager getEntityManager(){
        return this.entityManagerFactory.createEntityManager();
    }

    public void closeFactory(){
        this.entityManagerFactory.close();
    }
}
