package com.greenStitch.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greenStitch.entities.Parking;
import com.greenStitch.exceptions.ResourceNotFoundException;
import com.greenStitch.repository.ParkingRepository;
import com.greenStitch.services.ParkingLotService;

@Service
public class ParkingLotServiceImpl implements ParkingLotService {

	@Autowired
	private ParkingRepository parkingRepository;

	@Override
	public String createParkingLot(Integer numberOfRows) {
		for (int i = 1; i <= numberOfRows; i++) {
			Parking parkingData = new Parking();
			parkingData.setSlotNumber(i);
			parkingData.setIsSlotOccupied("Available");
			parkingRepository.save(parkingData);
		}
		return "Created a parking Lot with " + numberOfRows + " slots.";
	}

	@Override
	public String putCarIntoParking(String carRegistrationNumber, String carColor) {
		List<Parking> allParkingSlots = parkingRepository.findAll();
		if (allParkingSlots.size() == 0)
			throw new IllegalArgumentException("Please first create a Parking lot Area with a valid command");
		List<Parking> availableSlots = parkingRepository.getAvailableSlots();
		if (availableSlots.size() == 0)
			throw new NullPointerException("Sorry, parking lot is full !!");
		Parking nearestAvailableSlot = availableSlots.get(0);
		nearestAvailableSlot.setCarColour(carColor);
		nearestAvailableSlot.setCarRegistrationNumber(carRegistrationNumber);
		nearestAvailableSlot.setIsSlotOccupied("Occupied");
		this.parkingRepository.save(nearestAvailableSlot);
		return "Allocated Slot Number : " + nearestAvailableSlot.getSlotNumber();
	}

	@Override
	public String leaveCarFromParking(Integer slotNumber) {
		Parking carParked = parkingRepository.findById(slotNumber)
				.orElseThrow(() -> new ResourceNotFoundException("You entered wrong Slot Please Check again !!"));
		if (carParked.getCarColour() == null)
			throw new ResourceNotFoundException("This slot is vacant, No car parked in this slot");
		carParked.setCarRegistrationNumber(null);
		carParked.setCarColour(null);
		carParked.setIsSlotOccupied("Available");
		this.parkingRepository.save(carParked);
		return "Slot Number " + slotNumber + " is free.";
	}

	@Override
	public List<Parking> getAllCarStatus() {
		List<Parking> bookedParkingSlot = parkingRepository.getBookedSlots();
		return bookedParkingSlot;
	}

	@Override
	public List<String> getCarRegistrationNumbersByColor(String carColour) {
		List<String> registeredCarNumber = this.parkingRepository.getCarRegistrationNumbersByColor(carColour);
		return registeredCarNumber;
	}

}
