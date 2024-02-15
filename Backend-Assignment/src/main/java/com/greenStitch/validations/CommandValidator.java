package com.greenStitch.validations;

import org.springframework.stereotype.Service;

@Service
public class CommandValidator {

	public boolean isValidCommand(String input) {
		String[] tokens = input.split(" ");

		if (tokens.length == 0) {
			return false;
		}

		String command = tokens[0].toLowerCase();

		switch (command) {
		case "create_parking_lot":
			return tokens.length == 2 && isNumeric(tokens[1]);
		case "park":
			return tokens.length == 3;
		case "leave":
			return tokens.length == 2 && isNumeric(tokens[1]);
		case "status":
			return tokens.length == 1;
		case "exit":
			return tokens.length == 1;
		case "registration_numbers_for_cars_with_colour":
			return tokens.length == 2;
		default:
			return false;
		}
	}

	private static boolean isNumeric(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
