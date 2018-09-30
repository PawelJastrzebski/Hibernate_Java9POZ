package com.jastrzab.app.infrastructure.Hibernate;

import javax.persistence.EntityManager;

public interface Transaction {

    void execute(EntityManager entityManager);
}
