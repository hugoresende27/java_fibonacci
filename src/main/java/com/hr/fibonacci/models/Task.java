package com.hr.fibonacci.models;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Task {

    private Long id;
    private int cla;
    private String name;
    @DateTimeFormat (pattern="yyyy-MM-dd")
    private Date date;

    public Task(Long id, int cla, String name, Date date) {
        this.id = id;
        this.cla = cla;
        this.name = name;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", cla=" + cla +
                ", name='" + name + '\'' +
                ", date=" + date +
                '}';
    }

    public Task() {
    }

    public int getCla() {
        return cla;
    }

    public void setCla(int cla) {
        this.cla = cla;
    }

    public Task(Long id, String name, Date date) {
        this.id = id;
        this.name = name;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {


        this.date = date;
    }


}
