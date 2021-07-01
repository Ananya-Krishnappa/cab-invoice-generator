package com.bridgelabz.cabinvoicegenerator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.bridgelabz.cabinvoicegenerator.dto.InvoiceSummary;
import com.bridgelabz.cabinvoicegenerator.dto.Ride;
import com.bridgelabz.cabinvoicegenerator.exception.RideRepositoryException;
import com.bridgelabz.cabinvoicegenerator.service.InvoiceService;
import com.bridgelabz.cabinvoicegenerator.type.RideType;

public class InvoiceServiceTest {
	private static InvoiceService invoiceService;

	@BeforeAll
	public static void initialize() {
		invoiceService = new InvoiceService();
	}

	@Test
	public void givenDistanceAndTime_ShouldReturnNormalTotalFare() {
		double distance = 0.1;
		int time = 1;
		double fare = invoiceService.calculateFare(distance, time, RideType.NORMAL);
		Assertions.assertEquals(5, fare, 0.0);
	}

	@Test
	public void givenDistanceAndTime_ShouldReturnPremiumTotalFare() {
		double distance = 0.1;
		int time = 1;
		double fare = invoiceService.calculateFare(distance, time, RideType.PREMIUM);
		Assertions.assertEquals(20, fare, 0.0);
	}

	@Test
	public void givenMultipleRides_ShouldReturnNormalInvoiceSummary() throws RideRepositoryException {
		Ride[] rides = { new Ride(2.0, 5), new Ride(0.1, 1) };
		InvoiceSummary summary = invoiceService.calculateFare(rides, RideType.NORMAL);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
		Assertions.assertEquals(expectedInvoiceSummary, summary);
	}

	@Test
	public void givenMultipleRides_ShouldReturnPremiumInvoiceSummary() throws RideRepositoryException {
		Ride[] rides = { new Ride(2.0, 5), new Ride(0.1, 1) };
		InvoiceSummary summary = invoiceService.calculateFare(rides, RideType.PREMIUM);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 60.0);
		Assertions.assertEquals(expectedInvoiceSummary, summary);
	}
}
