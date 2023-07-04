package com.example.demo.reminder;

import org.springframework.stereotype.Service;

@Service
class ReminderService {
    ReminderRepository reminderRepository;
    public ReminderService(ReminderRepository reminderRepository){
        this.reminderRepository = reminderRepository;
    }
    Reminder getLatestReminder(){
        return reminderRepository.getFirstByDate();
    }
}
