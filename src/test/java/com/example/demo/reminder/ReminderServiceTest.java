package com.example.demo.reminder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Date;

import static org.mockito.Mockito.when;

public class ReminderServiceTest {
    @Mock
    ReminderRepository reminderRepository;

    ReminderService reminderService;

    @BeforeEach
    void setup(){
        Reminder reminderMock = new Reminder();
        Date date = new Date();
        long dateInTime = 100;
        date.setTime(dateInTime);

        String eventName = "Test Event";

        reminderMock.setDate(date);
        reminderMock.setName(eventName);

        when(reminderRepository.getFirstByDate()).thenReturn(reminderMock);

        reminderService = new ReminderService(reminderRepository);
    }


}
