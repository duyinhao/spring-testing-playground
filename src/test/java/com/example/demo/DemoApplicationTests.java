package com.example.demo;

import com.example.demo.controller.ReminderController;
import com.example.demo.requests.ReminderResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureGraphQlTester;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.Date;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {
	@Value(value="${local.server.port}")
	private int port;

	@Autowired
	private ReminderController reminderController;

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	void contextLoads() {
		assertThat(reminderController).isNotNull();
	}

	@Test
	void getReminderRequest() {
		ResponseEntity<ReminderResponse> reminderResponseResponseEntity;
		reminderResponseResponseEntity = testRestTemplate.getForEntity("/Reminder",ReminderResponse.class);
		ReminderResponse reminderResponse = reminderResponseResponseEntity.getBody();

		assertThat(reminderResponseResponseEntity).isNotNull();
		assertThat(reminderResponseResponseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat (reminderResponse).isNotNull();
		assertThat(reminderResponse.getDate()).isEqualToIgnoringSeconds("2007-12-03");
		assertThat(reminderResponse.getName()).isEqualTo("Event Name");
	}

}
