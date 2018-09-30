package com.jastrzab.app.infrastructure;

import com.jastrzab.app.domain.model.Mark;
import com.jastrzab.app.infrastructure.Hibernate.Hibernate;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class MarkRepository extends AbstractRepository<Mark> {

    Hibernate hibernate;

    public MarkRepository(Hibernate hibernate) {
        this.hibernate = hibernate;
    }

    @Override
    public Mark get(int id) {
        AtomicReference<Mark> mark = null;
        this.hibernate.executeWithTransaction(entityManager -> {
            mark.set(entityManager.find(Mark.class, id));
        });
        return mark.get();
    }

    @Override
    public List<Mark> getAll() {
        AtomicReference<List<Mark>> marks = null;
        this.hibernate.executeWithTransaction(entityManager -> {
            marks.set(entityManager.createQuery("FROM Mark ", Mark.class).getResultList());
        });
        return marks.get();
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean delete(Mark object) {
        return false;
    }

    @Override
    public boolean insert(Mark object) {
        return false;
    }

    @Override
    public boolean update(Mark object) {
        return false;
    }
}
