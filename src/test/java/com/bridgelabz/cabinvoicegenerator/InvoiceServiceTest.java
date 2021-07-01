package com.bridgelabz.cabinvoicegenerator;

public class InvoiceServiceTest {private static InvoiceService invoiceService;

@BeforeAll
public static void initialize() {
	invoiceService = new InvoiceService();
}

@Test
public void givenDistanceAndTime_ShouldReturnTotalFare() {
	double distance = 0.1;
	int time = 1;
	double fare = invoiceService.calculateFare(distance, time);
	Assertions.assertEquals(5, fare, 0.0);
}

}
