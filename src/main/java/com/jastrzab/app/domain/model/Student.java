package com.jastrzab.app.domain.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    private String name;
    private String surname;
    int age;
    @OneToMany( cascade = {CascadeType.REMOVE,CascadeType.ALL},fetch = FetchType.EAGER, mappedBy = "STUDENT")

   // @JoinColumn(name = "STUDENT")
    private List<Mark> marks;
    public Student() {
        this.marks = new ArrayList<>();
    }

    public Student(String name, String surname, int age) {
        this();
        this.name = null;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }
    public void addMark(Mark mark){
        this.marks.add(mark);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", marks=" + marks +
                '}';
    }
}
