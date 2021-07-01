package com.bridgelabz.cabinvoicegenerator.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bridgelabz.cabinvoicegenerator.dto.Ride;
import com.bridgelabz.cabinvoicegenerator.exception.RideRepositoryException;
import com.bridgelabz.cabinvoicegenerator.type.ExceptionType;

public class RideRepository {
	Map<String, List<Ride>> userRides = new HashMap<String, List<Ride>>();

	public RideRepository() {

	}

	public RideRepository(Map<String, List<Ride>> userRides) {
		this.userRides = userRides;
	}

	/**
	 * Function to add rides
	 * 
	 * @param userId
	 * @param rides
	 * @return List<Ride>
	 * @throws RideRepositoryException
	 */
	public List<Ride> addRides(String userId, Ride[] rides) throws RideRepositoryException {
		if (rides != null && userId != "")
			return userRides.put(userId, Arrays.asList(rides));
		throw new RideRepositoryException("No ride found for the user " + userId, ExceptionType.NO_RIDE_FOUND);
	}

	/**
	 * This method is used to get rides
	 * 
	 * @param userId
	 * @return
	 * @throws RideRepositoryException
	 */
	public Ride[] getRides(String userId) throws RideRepositoryException {
		if (userId.isEmpty()) {
			List<Ride> rideList = new ArrayList<Ride>();
			rideList = userRides.get(userId);
			return rideList.toArray(new Ride[0]);
		} else
			throw new RideRepositoryException("UserId is invalid ", ExceptionType.NO_RIDE_FOUND);
	}
}
