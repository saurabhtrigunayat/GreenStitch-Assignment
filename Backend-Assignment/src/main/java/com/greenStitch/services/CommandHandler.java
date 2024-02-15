package com.greenStitch.services;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.greenStitch.validations.CommandValidator;

@Service
public class CommandHandler {

	@Autowired
	private CommandDisplayService parkingLotUserInterface;

	@Autowired
	private CommandValidator commandValidatorService;

	@Autowired
	private RestTemplate restTemplate;
	private final String BASE_URL = "http://localhost:8080/parking";
	private final Scanner scanner = new Scanner(System.in);

	public void userCommandHandler() {
		try {
			this.parkingLotUserInterface.commandsDescription();
			while (true) {
				System.out.print("Enter command: ");
				String userCommand = scanner.nextLine();
				if (commandValidatorService.isValidCommand(userCommand)) {

					String[] commandParts = userCommand.split(" ");

					String command = commandParts[0].toLowerCase();
					String API_URL = BASE_URL + "/" + command;
					String ENDPOINT_URL;
					String data = null; // Declare a single data variable

					switch (command) {
					case "create_parking_lot":
						ENDPOINT_URL = API_URL + "/" + commandParts[1];
						data = restTemplate.postForObject(ENDPOINT_URL, null, String.class);
						break;
					case "park":
						String regNumber = commandParts[1];
						String color = commandParts[2];
						ENDPOINT_URL = API_URL + "/" + regNumber + "/" + color;
						data = restTemplate.postForObject(ENDPOINT_URL, null, String.class);
						break;
					case "leave":
						int slotNumber = Integer.parseInt(commandParts[1]);
						ENDPOINT_URL = API_URL + "/" + slotNumber;
						restTemplate.delete(ENDPOINT_URL);
						break;
					case "status":
						restTemplate.getForObject(API_URL, String.class);
						break;
					case "exit":
						System.out.println("Exiting the application.");
						scanner.close();
						System.exit(0);
					case "registration_numbers_for_cars_with_colour":
						ENDPOINT_URL = API_URL + "/" + commandParts[1];
						// System.out.println("Correct>>> "+ENDPOINT_URL);
						restTemplate.getForObject(ENDPOINT_URL, String.class);
						break;

					default:
						System.out.println("Invalid command. Please try again.");
						break;
					}
					if (data != null) {
						System.out.println(data);
					}
				} else {
					System.out.println("Invalid command. Please try again.");
				}
			}
		} catch (HttpClientErrorException e) {
			String data = e.getResponseBodyAsString();
			System.out.println(data);
		}
	}
}
