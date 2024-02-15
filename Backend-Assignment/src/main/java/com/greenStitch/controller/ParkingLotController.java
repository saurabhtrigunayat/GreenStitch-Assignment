package com.greenStitch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greenStitch.entities.Parking;
import com.greenStitch.services.ParkingLotService;

@RestController
@RequestMapping("/parking")
public class ParkingLotController {

	@Autowired
	private ParkingLotService parkingLotService;

	@PostMapping("/create_parking_lot/{capacity}")
	public String createParkingLot(@PathVariable int capacity) {
		return parkingLotService.createParkingLot(capacity);
	}

	@PostMapping("/park/{registrationNumber}/{colour}")
	public String parkCar(@PathVariable String registrationNumber, @PathVariable String colour) {
		return parkingLotService.putCarIntoParking(registrationNumber, colour);
	}

	@DeleteMapping("/leave/{slotNumber}")
	public void leaveParkingLot(@PathVariable int slotNumber) {
		String responseData = parkingLotService.leaveCarFromParking(slotNumber);
		System.out.println(responseData);
	}

	@GetMapping("/status")
	public void getParkingLotStatus() {
		List<Parking> carsStatus = this.parkingLotService.getAllCarStatus();
		if (carsStatus.size() == 0)
			throw new NullPointerException("No car is parked !!");
		System.out.println("Slot Number  Registration No Colour");
		for (Parking parkedCar : carsStatus)
			System.out.println(parkedCar.getSlotNumber() + " " + parkedCar.getCarRegistrationNumber());
	}

	@GetMapping("/registration_numbers_for_cars_with_colour/{carColour}")
	public void getRegistrationNumberByColor(@PathVariable String carColour) {
		// System.out.println("API Hitting >>");
		List<String> getRegisteredCars = this.parkingLotService.getCarRegistrationNumbersByColor(carColour);
		for (String registrationNumber : getRegisteredCars)
			System.out.println(registrationNumber);
	}

}
