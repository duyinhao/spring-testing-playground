package com.example.demo.reminder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class ReminderServiceTest {
    @Mock
    ReminderRepository reminderRepository;

    ReminderService reminderService;

    long dateInTime = 100;
    String eventName = "Test Event";
    @BeforeEach
    void setup(){

        MockitoAnnotations.initMocks(this);

        Reminder reminderMock = new Reminder();
        Date date = new Date();

        date.setTime(dateInTime);
        reminderMock.setDate(date);
        reminderMock.setName(eventName);

        when(reminderRepository.getFirstByDate()).thenReturn(reminderMock);

        reminderService = new ReminderService(reminderRepository);
    }

    @Test
    void getLatestReminder(){
        Reminder reminder = reminderService.getLatestReminder();
        assertThat(reminder.getDate().getTime()).isEqualTo(dateInTime);
        assertThat(reminder.getName()).isEqualTo(eventName);
    }
}
