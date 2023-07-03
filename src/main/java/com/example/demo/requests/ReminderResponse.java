package com.example.demo.requests;

import org.springframework.http.ResponseEntity;

import java.util.Date;

public class ReminderResponse {
    String name;
    Date date;

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
