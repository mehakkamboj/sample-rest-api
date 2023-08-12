package com.company.samplerestapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @Column(name = "rno")
    private String rno;
    @Column(name = "name")
    private  String name;
    @Column(name = "stream")
    private String stream;
    @Column(name = "dept")
    private String dept;
    public Student(){}   //for security purpose
    public Student(String rno, String name, String stream, String dept){
        this.rno = rno;
        this.name = name;
        this.stream = stream;
        this.dept = dept;
    }

    public String getRno() {
        return rno;
    }

    public void setRno(String rno) {
        this.rno = rno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }
}