/**
 * Purpose:Cab Invoice Generator- The cab service is subscription based system,
 * where the customer can book and pay bill at the end.
 * @author Ananya K
 * @version 1.0
 * @since 1/07/2021
 * 
 */
package com.bridgelabz.cabinvoicegenerator.service;

import com.bridgelabz.cabinvoicegenerator.dao.RideRepository;
import com.bridgelabz.cabinvoicegenerator.dto.InvoiceSummary;
import com.bridgelabz.cabinvoicegenerator.dto.Ride;
import com.bridgelabz.cabinvoicegenerator.exception.RideRepositoryException;
import com.bridgelabz.cabinvoicegenerator.type.ExceptionType;
import com.bridgelabz.cabinvoicegenerator.type.RideType;

public class InvoiceService {
	final RideRepository rideRepository = new RideRepository();

	/**
	 * Given distance and time,the invoice service should return total fare.
	 * 
	 * @param distance
	 * @param time
	 * @param normal
	 * @return double
	 */
	public double calculateFare(double distance, int time, RideType rideType) {
		double totalFare = distance * rideType.getMinimumCostPerKm() + time * rideType.getCostPerTime();
		return Math.max(totalFare, rideType.getMinimumFare());
	}

	/**
	 * Invoice service should take multiple rides and return aggregate total fare
	 * for all rides
	 * 
	 * @param rides
	 * @param normal
	 * @return
	 */
	public InvoiceSummary calculateFare(Ride[] rides, RideType rideType) {
		double totalFare = 0;
		for (Ride ride : rides) {
			totalFare += calculateFare(ride.distance, ride.time, rideType);
		}
		return new InvoiceSummary(rides.length, totalFare);
	}

	/**
	 * 
	 * @param userId
	 * @param rides
	 * @throws RideRepositoryException
	 */
	public void addRide(String userId, Ride[] rides) throws RideRepositoryException {
		rideRepository.addRides(userId, rides);
	}

	/**
	 * This methos is used to get the invoice summary
	 * 
	 * @param userId
	 * @param rideType
	 * @return InvoiceSummary
	 * @throws RideRepositoryException
	 */
	public InvoiceSummary getInvoiceSummary(String userId, RideType rideType) throws RideRepositoryException {
		try {
			Ride[] rides = rideRepository.getRides(userId);
			return calculateFare(rides, rideType);
		} catch (RideRepositoryException e) {
			throw new RideRepositoryException("No user found ", ExceptionType.NULL_VALUE);
		}
	}
}
