package com.greenStitch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.greenStitch.services.CommandHandler;

@SpringBootApplication
public class BackendAssignmentApplication implements CommandLineRunner {

	@Autowired
	CommandHandler commandHandler;

	public static void main(String[] args) {
		SpringApplication.run(BackendAssignmentApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		this.commandHandler.userCommandHandler();
	}

}
