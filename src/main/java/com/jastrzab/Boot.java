package com.jastrzab;

import com.jastrzab.app.domain.model.Mark;
import com.jastrzab.app.domain.model.Student;
import com.jastrzab.app.infrastructure.Hibernate.Hibernate;
import com.jastrzab.app.infrastructure.StudentRepository;

public class Boot {
    public static void main(String[] args) {
        Hibernate hibernate = new Hibernate();

        final StudentRepository studentRepository = new StudentRepository(hibernate);

        final Student student = new Student("Roman", "Kot", 20);
        student.addMark(new Mark(4.5f,student));
        student.addMark(new Mark(5f,student));

        studentRepository.insert(student);

        System.out.println(studentRepository.get(1));
        final Student student1 = studentRepository.get(1);
        student.setAge(21);
        studentRepository.update(student1);
        System.out.println(studentRepository.get(1));
        //System.out.println(studentRepository.getAll());


        studentRepository.delete(1);
        hibernate.closeFactory();
    }
}
