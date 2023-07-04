package com.example.demo.reminder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class ReminderControllerTest {
    @Mock
    ReminderService reminderService;

    ReminderController reminderController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        reminderController = new ReminderController(reminderService);
    }

    @Test
    public void getReminder() {
        Reminder reminderMock = new Reminder();
        Date date = new Date();
        long dateInTime = 100;
        date.setTime(dateInTime);

        String eventName = "Test Event";

        reminderMock.setDate(date);
        reminderMock.setName(eventName);

        when(reminderService.getLatest()).thenReturn(reminderMock);

        Reminder reminder = reminderService.getLatest();

        assertThat(reminder.getDate().getTime()).isEqualTo(dateInTime);
        assertThat(reminder.getName()).isEqualTo(eventName);
    }

}
