package com.thoughtworks.tdd;

import com.thoughtworks.tdd.parking.car.Car;
import com.thoughtworks.tdd.parking.person.Customer;
import com.thoughtworks.tdd.parking.person.Manager;
import com.thoughtworks.tdd.parking.person.ParkingBoy;
import com.thoughtworks.tdd.parking.relatedAffairs.ParkingLot;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Story5Test {
    @Test
    public void should_park_the_car_to_parkingSizeOf10_when_parkingSizeOf10_has_more_position_rate(){
        Manager manager = new Manager();
        ParkingLot parkingLotSizeOf13 = new ParkingLot(13,1);
        ParkingLot parkingLotSizeOf10 = new ParkingLot(10,2);
        manager.addParkingLot(parkingLotSizeOf13);
        manager.addParkingLot(parkingLotSizeOf10);
        ParkingBoy parkingBoy = new ParkingBoy();
        manager.distributionParkingLot(parkingBoy);
        Car car1 = new Car("1 car's");
        parkingBoy.park(car1);
        Car car2 = new Car("2 car's");
        Customer customer = new Customer(car2);
        parkingBoy.addObserver(customer);
        parkingBoy.park(car2);
        String successMessage = "Park Success!Your car is parking in 2 lot.";
        assertThat(customer.getSuccessMessage(),is(successMessage));
    }
}
