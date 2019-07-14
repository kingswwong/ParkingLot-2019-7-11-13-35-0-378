package com.thoughtworks.tdd;

import com.thoughtworks.tdd.parking.car.Car;
import com.thoughtworks.tdd.parking.person.Customer;
import com.thoughtworks.tdd.parking.person.Manager;
import com.thoughtworks.tdd.parking.person.ParkingBoy;
import com.thoughtworks.tdd.parking.relatedAffairs.ParkingLot;
import com.thoughtworks.tdd.parking.relatedAffairs.Ticket;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Story4Test {
    @Test
    public void should_park_the_car_to_parkingSizeOf20_when_parkingSizeOf20_is_more_empty(){
        Manager manager = new Manager();
        ParkingLot parkingLotSizeOf10 = new ParkingLot(10,1);
        ParkingLot parkingLotSizeOf20 = new ParkingLot(20,2);
        manager.addParkingLot(parkingLotSizeOf10);
        manager.addParkingLot(parkingLotSizeOf20);
        ParkingBoy parkingBoy = new ParkingBoy();
        manager.distributionParkingLot(parkingBoy);
        Car car = new Car("11 car's");
        Customer customer = new Customer(car);
        parkingBoy.addObserver(customer);
        parkingBoy.park(car);
        String successMessage = "Park Success!Your car is parking in 2 lot.";
        assertThat(customer.getSuccessMessage(),is(successMessage));
    }
}
