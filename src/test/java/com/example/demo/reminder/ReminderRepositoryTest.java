package com.example.demo.reminder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ReminderRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    ReminderRepository repository;



    @BeforeEach
    void setup(){
        ReminderDTO firstReminderDTO = new ReminderDTO();
        Date firstDate = new Date();
        firstDate.setTime(100);
        firstReminderDTO.setDate(firstDate);
        firstReminderDTO.setName("first event");

        ReminderDTO secondReminderDTO = new ReminderDTO();
        Date secondDate = new Date();
        secondDate.setTime(200);
        secondReminderDTO.setDate(secondDate);
        secondReminderDTO.setName("second event");

        ReminderDTO thirdReminderDTO = new ReminderDTO();
        Date thirdDate = new Date();
        thirdDate.setTime(300);
        thirdReminderDTO.setDate(thirdDate);
        thirdReminderDTO.setName("third event");

        this.entityManager.persist(firstReminderDTO);
        this.entityManager.persist(secondReminderDTO);
        this.entityManager.persist(thirdReminderDTO);
    }
    @Test
    void retrieveLatestReminder(){
        ReminderDTO latestReminder = repository.findFirst1ByOrderByDateDesc();
        assertThat(latestReminder.date.getTime()).isEqualTo(300);
        assertThat(latestReminder.name).isEqualTo("third event");



    }

}
