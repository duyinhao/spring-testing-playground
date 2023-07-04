package com.example.demo.reminder;

import org.springframework.stereotype.Service;

@Service
class ReminderService {
    ReminderRepository reminderRepository;

    public ReminderService(ReminderRepository reminderRepository) {
        this.reminderRepository = reminderRepository;
    }

    Reminder getLatest() {

        ReminderDTO latestDto = reminderRepository.findFirst1ByOrderByDateDesc();
        return DTOtoDomain(latestDto);
    }

    Reminder DTOtoDomain(ReminderDTO reminderDTO){
        Reminder reminder = new Reminder();
        reminder.setName(reminderDTO.getName());
        reminder.setDate(reminderDTO.getDate());
        return reminder;
    }
}
