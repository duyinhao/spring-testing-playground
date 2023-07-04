package com.example.demo.reminder;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;
@Entity
public class ReminderDTO {
    String name;
    Date date;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    Date getDate() {
        return date;
    }

    void setDate(Date date) {
        this.date = date;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
