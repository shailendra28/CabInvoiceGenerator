package com.cabinvoice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InvoiceGeneratorTest {
    /**
     * This method will check the totalFare according to the input.
     */
    @Test
    public void givenDistanceAndTime_ShouldReturnTotalfare() {
        // Generating Invoice and assigning it to local variable
        InvoiceGenerator invoiceGenerator=new InvoiceGenerator();
        // Defining local variable
        double distance = 2.0;
        int time = 5;
        double totalFare = invoiceGenerator.calculateTotalFare(distance, time);
        Assertions.assertEquals(25,totalFare,0.0);
    }
    /**
     * This method will check the Minimum Fare according to the input.
     */
    @Test
    public void givenLessDistanceAndTime_ShouldReturnMinimumFare() {
        // Generating Invoice and assigning it to local variable
        InvoiceGenerator invoiceGenerator=new InvoiceGenerator();
        // Defining local variable
        double distance = 0.1;
        int time = 1;
        double totalFare = invoiceGenerator.calculateTotalFare(distance, time);
        Assertions.assertEquals(5,totalFare,0.0);
    }
    /**
     * This method will check the invoice Summary with multiple rides.
     */
    @Test
    public void givenDistanceAndTIme_WithMultipleRidesCount_ShouldReturnInvoiceSummary() {
        // Generating Invoice and assigning it to local variable
        InvoiceGenerator invoiceGenerator=new InvoiceGenerator();
        // Defining local variable by using an Array to get multiple ride
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)
        };
        InvoiceSummary summary = invoiceGenerator.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        Assertions.assertEquals(expectedInvoiceSummary, summary);
    }
    /**
     * This method will check the Invoice Summary Id according to the input.
     */
    @Test
    public void givenUserId_ShouldReturn_InvoiceSummaryWithId() {
        // Generating Invoice and assigning it to local variable
        InvoiceGenerator invoiceGenerator=new InvoiceGenerator();
        // Defining local variable by using an Array to get multiple summary
        InvoiceSummaryWithId[] summaries = {new InvoiceSummaryWithId(1,30.2,1),
                                            new InvoiceSummaryWithId(2,53.5, 2)
        };
        int id = 1;
        InvoiceSummaryWithId summary = invoiceGenerator.invoiceList(summaries, id);
        InvoiceSummaryWithId expectedInvoiceSummary = new InvoiceSummaryWithId(1,30.2,1);
        Assertions.assertEquals(expectedInvoiceSummary,summary);
    }
    /**
     * This method will check the totalFare according to the Premium Ride category.
     */
    @Test
    public void givenDistanceAndTime_ForPremiumRide_ShouldReturn_TotalFare() {
        // Generating Invoice and assigning it to local variable
        InvoiceGenerator invoiceGenerator=new InvoiceGenerator();
        // Defining local variable
        double distance = 2.0;
        int time = 5;
        double fare = invoiceGenerator.calculateTotalFare(distance, time, InvoiceGenerator.Ride_Type.PREMIUM_RIDE);
        Assertions.assertEquals(40,fare,0.0);
    }
    /**
     * This method will check the totalFare according to the Normal Ride category.
     */
    @Test
    public void givenDistanceAndTime_ForNormalRide_ShouldReturn_TotalFare() {
        // Generating Invoice and assigning it to local variable
        InvoiceGenerator invoiceGenerator=new InvoiceGenerator();
        // Defining local variable
        double distance = 2.0;
        int time = 5;
        double fare = invoiceGenerator.calculateTotalFare(distance, time, InvoiceGenerator.Ride_Type.NORMAL_RIDE);
        Assertions.assertEquals(25,fare,0.0);
    }
}
