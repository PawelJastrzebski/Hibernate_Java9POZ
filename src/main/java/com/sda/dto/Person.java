package dto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name="person")
public class Person {
    @Id
    @Column(name="idperson", nullable=false, unique=true)
    private int idperson;

    @Column(name="name")
    private String name;

    @Column
    private String surname;

    @Column
    private int age;

    @OneToMany
    @JoinColumn(name = "person_id")
    private Collection<Dog> dogs = new ArrayList<>();

    public int getIdperson() {
        return idperson;
    }

    public void setIdperson(int idperson) {
        this.idperson = idperson;
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

    public Collection<Dog> getDogs() {
        return dogs;
    }

    public void setDogs(Collection<Dog> dogs) {
        this.dogs = dogs;
    }
}
