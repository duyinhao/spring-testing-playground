package com.example.demo.reminder;

import java.util.Date;

class Reminder {
    String name;
    Date date;

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
}
