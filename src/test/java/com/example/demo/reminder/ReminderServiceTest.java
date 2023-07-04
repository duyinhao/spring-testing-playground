package com.example.demo.reminder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class ReminderServiceTest {
    @Mock
    ReminderRepository reminderRepository;

    ReminderService reminderService;

    long eventDateInTime = 100;
    String eventName = "Test Event";

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
        reminderService = new ReminderService(reminderRepository);
    }

    @Test
    void getLatestReminder() {
        ReminderDTO reminderMock = new ReminderDTO();
        Date date = new Date();

        date.setTime(eventDateInTime);
        reminderMock.setDate(date);
        reminderMock.setName(eventName);

        when(reminderRepository.getFirstByDate()).thenReturn(reminderMock);

        Reminder reminder = reminderService.getLatest();
        assertThat(reminder.getDate().getTime()).isEqualTo(eventDateInTime);
        assertThat(reminder.getName()).isEqualTo(eventName);
    }
}
