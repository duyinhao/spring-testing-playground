package com.example.demo.controller;

import com.example.demo.model.Reminder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class ReminderController {
    @GetMapping
    public Reminder getReminder(){
        return null;
    }



}
