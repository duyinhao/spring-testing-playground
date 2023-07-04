package com.example.demo.reminder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReminderRepository extends JpaRepository<ReminderDTO, Long> {
    public Reminder getFirstByDate();
}
