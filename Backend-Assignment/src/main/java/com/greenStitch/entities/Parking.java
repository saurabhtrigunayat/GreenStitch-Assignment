package com.greenStitch.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Car_Parking_Data")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Parking {
	@Id
	private int slotNumber;
	private String carRegistrationNumber;
	private String carColour;
	private String isSlotOccupied;
}
