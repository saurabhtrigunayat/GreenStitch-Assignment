package com.greenStitch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.greenStitch.entities.Parking;

@Repository
public interface ParkingRepository extends JpaRepository<Parking, Integer> {

	@Query("SELECT p FROM Parking p WHERE p.isSlotOccupied = 'Available' ORDER BY p.slotNumber ASC")
	List<Parking> getAvailableSlots();

	@Query("SELECT p FROM Parking p WHERE p.isSlotOccupied = 'Occupied' ORDER BY p.slotNumber ASC")
	List<Parking> getBookedSlots();

	@Query("SELECT p.carRegistrationNumber FROM Parking p WHERE p.carColour = :carColor")
	List<String> getCarRegistrationNumbersByColor(@Param("carColor") String carColor);

}
