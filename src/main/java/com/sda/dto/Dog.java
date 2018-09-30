package com.sda.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity
@Table(name = "dog")
public class Dog {
    @Id
    @Column(name="idDog", nullable=false, unique=true)
    private int iddog;

    @Override
    public String toString() {
        return "Dog{" +
                "iddog=" + iddog +
                '}';
    }
}
