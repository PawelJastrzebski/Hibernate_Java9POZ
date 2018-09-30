package com.jastrzab.app.infrastructure;

import com.jastrzab.app.domain.model.Student;
import com.jastrzab.app.infrastructure.Hibernate.Hibernate;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class StudentRepository extends AbstractRepository<Student> {

    Hibernate hibernate;

    public StudentRepository(Hibernate hibernate) {
        this.hibernate = hibernate;
    }

    @Override
    public Student get(int id) {
        AtomicReference<Student> student = new AtomicReference<>();
        hibernate.executeWithTransaction(entityManager -> {
            student.set(entityManager.createQuery("FROM Student WHERE id = :id", Student.class).setParameter("id", id).getSingleResult());;
        });
        return student.get();
    }

    @Override
    public List<Student> getAll() {
        final AtomicReference<List<Student>> students = new AtomicReference<>();

        this.hibernate.executeWithTransaction(entityManager -> {

            students.set(entityManager.createQuery("FROM Student", Student.class).getResultList());
        });
        return students.get();
    }

    @Override
    public boolean delete(int id) {
        this.hibernate.executeWithTransaction(entityManager -> {
            entityManager.createQuery("DELETE Student WHERE id = : id").setParameter("id", id).executeUpdate();
        });
        return true;
    }

    @Override
    public boolean delete(Student object) {
        hibernate.executeWithTransaction(entityManager -> {
            entityManager.remove(object);
        });
        return true;
    }

    @Override
    public boolean insert(Student object) {

        this.hibernate.executeWithTransaction(entityManager -> {
            entityManager.persist(object);
        });
        return true;
    }

    @Override
    public boolean update(Student object) {
        this.hibernate.executeWithTransaction(entityManager -> {
            entityManager.merge(object);
        });
        return true;
    }

}
