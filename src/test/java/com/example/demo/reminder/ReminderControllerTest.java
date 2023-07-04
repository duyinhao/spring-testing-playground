package com.example.demo.reminder;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;

import java.util.Date;

import static org.mockito.Mockito.when;

public class ReminderControllerTest {
    @Mock
    ReminderService reminderService;

    ReminderController reminderController;

    @BeforeEach
    public void setup(){
        reminderController = new ReminderController(reminderService);
    }

}
