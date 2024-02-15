package com.greenStitch.services;

import org.springframework.stereotype.Service;

@Service
public class CommandDisplayService {
	
	public void commandsDescription() {
		System.out.println();
		System.out.println("Welcome to the Parking Lot Application");
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("Use given below commands to operate this application : ");
		System.out.println("1.To create parking lot Area please use this command : create_parking_lot {Insert size of parking lot}");
		System.out.println("2.To park your car use this command: park {car Reg. No} {color of car}");
		System.out.println("3.To leave your slot please use this command : leave {your car slot Number}");
		System.out.println("4.To check status of all cars use this command : status");
		System.out.println("5.To fetch cars registrations with particular colors please use this command : registration_numbers_for_cars_with_colour {car_color}");
		System.out.println("6.To close the application please use this command : exit");
		System.out.println();
		System.out.println("Important Information : It's a request to create parking lot area first otherwise application will not work !!");
		System.out.println("----------------------------------------------------------------------------------------");
	}

}
