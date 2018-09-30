package com.jastrzab.app.domain.model;

import javax.persistence.*;

@Entity
public class Mark {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private float value;
    @ManyToOne(cascade = {CascadeType.REMOVE,CascadeType.ALL})
    @JoinColumn(name = "STUDENT")
    private Student STUDENT;

    public Mark() {
    }

    public Mark(float value, Student STUDENT) {
        this.value = value;
        this.STUDENT = STUDENT;
    }

    @Override
    public String toString() {
        return Float.toString(this.value);
    }
}
