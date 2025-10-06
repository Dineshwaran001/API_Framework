package org.RestAPi.test.sample;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IntegrationSample {
    @Test
    @Owner("Dineshwaran")
    @Description("This TC is to verify the Booking 1")
    public void TokenGeneration(){
        System.out.println("This is a sample TC");
        Assert.assertTrue(true);
    }

    @Test
    @Owner("Dineshwaran")
    @Description("This TC is to verify the Booking 1")
    public void BookingCreation(){
        System.out.println("This is a sample TC");
        Assert.assertTrue(true);
    }

    @Test
    @Owner("Dineshwaran")
    @Description("This TC is to verify the Booking 1")
    public void UpdateBooking(){
        System.out.println("This is a sample TC");
        Assert.assertTrue(true);
    }

    @Test
    @Owner("Dineshwaran")
    @Description("This TC is to verify the Booking 1")
    public void DeleteBooking(){
        System.out.println("This is a sample TC");
        Assert.assertTrue(true);
    }

}
