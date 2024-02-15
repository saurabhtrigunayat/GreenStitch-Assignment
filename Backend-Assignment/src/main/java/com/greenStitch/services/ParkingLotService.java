package com.greenStitch.services;

import java.util.List;

import com.greenStitch.entities.Parking;

public interface ParkingLotService {

	String createParkingLot(Integer userCommand);

	String putCarIntoParking(String registrationNumber, String carColor);

	String leaveCarFromParking(Integer slotNumber);

	List<Parking> getAllCarStatus();

	List<String> getCarRegistrationNumbersByColor(String carColor);
}
