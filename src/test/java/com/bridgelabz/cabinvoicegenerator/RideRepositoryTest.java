package com.bridgelabz.cabinvoicegenerator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.bridgelabz.cabinvoicegenerator.dao.RideRepository;
import com.bridgelabz.cabinvoicegenerator.dto.Ride;
import com.bridgelabz.cabinvoicegenerator.exception.RideRepositoryException;
import com.bridgelabz.cabinvoicegenerator.type.ExceptionType;

public class RideRepositoryTest {
	@Test
	public void givenMultipleRides_ShouldReturnTotalFare() {
		try {
			RideRepository rideRepository = new RideRepository();
			String userId = "a@b.com";
			Ride[] rides = { new Ride(2.0, 5), new Ride(0.1, 1) };
			rideRepository.addRides(userId, rides);
			Ride[] summary = rideRepository.getRides(userId);
			Assertions.assertEquals(rides[0], summary[0]);
		} catch (RideRepositoryException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void givenDistanceAndTime_WithNullUserId_ShouldReturnCustomExceptionType() {
		try {
			RideRepository rideRepository = new RideRepository();
			String userId = "";
			Ride[] rides = { new Ride(2.0, 5), new Ride(0.1, 1) };
			rideRepository.addRides(userId, rides);
			Ride[] summary = rideRepository.getRides(userId);
			Assertions.assertEquals(rides[0], summary[0]);
		} catch (RideRepositoryException e) {
			Assertions.assertEquals(ExceptionType.NO_RIDE_FOUND, e.type);
		}
	}

	@Test
	public void givenDistanceAndTime_WithEmptyRide_ShouldReturnCustomExceptionType() {
		try {
			RideRepository rideRepository = new RideRepository();
			String userId = "";
			Ride[] rides = {};
			rideRepository.addRides(userId, rides);
			Ride[] summary = rideRepository.getRides(userId);
			Assertions.assertEquals(rides[0], summary[0]);
		} catch (RideRepositoryException e) {
			Assertions.assertEquals(ExceptionType.NO_RIDE_FOUND, e.type);
		}
	}

	@Test
	public void givenDistanceAndTime_GetRides() {
		try {
			RideRepository rideRepository = new RideRepository();
			String userId = "";
			Ride[] summary = rideRepository.getRides(userId);
		} catch (RideRepositoryException e) {
			Assertions.assertEquals(ExceptionType.NO_RIDE_FOUND, e.type);
		}
	}
}
