package com.example.demo.reminder;

import com.example.demo.reminder.Reminder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Reminder")
public class ReminderController {
    ReminderService reminderService;

    public ReminderController(ReminderService reminderService) {
        this.reminderService = reminderService;
    }

    @GetMapping
    public Reminder getReminder() {
        return reminderService.getLatestReminder();
    }


}
