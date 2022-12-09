package com.nest.studentapp_new_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Students {
@Id
    @GeneratedValue
    private int id;
private String name;
private int admnno;
private int rollno;
private String college;

    public Students() {
    }

    public Students(int id, String name, int admnno, int rollno, String college) {
        this.id = id;
        this.name = name;
        this.admnno = admnno;
        this.rollno = rollno;
        this.college = college;
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

    public int getAdmnno() {
        return admnno;
    }

    public void setAdmnno(int admnno) {
        this.admnno = admnno;
    }

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }
}
