package com.example.demo;

import com.example.demo.controller.ReminderController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureGraphQlTester;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private ReminderController reminderController;

	@Test
	void contextLoads() {
		assertThat(reminderController).isNotNull();
	}

}
