package com.thoughtworks.tdd;

import com.thoughtworks.tdd.parking.car.Car;
import com.thoughtworks.tdd.parking.person.Customer;
import com.thoughtworks.tdd.parking.person.Manager;
import com.thoughtworks.tdd.parking.person.ParkingBoy;
import com.thoughtworks.tdd.parking.relatedAffairs.ParkingLot;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Story6Test {

    @Test
    public void should_park_the_car_to_the_lot_management_by_parkingboy1_when_manager_other_him_to_park(){
        Manager manager = new Manager();
        ParkingBoy parkingBoy1 = new ParkingBoy("1");
        ParkingBoy parkingBoy2 = new ParkingBoy("2");
        ParkingBoy parkingBoy3 = new ParkingBoy("3");
        ParkingLot parkingLotSizeOf10 = new ParkingLot(10,1);
        ParkingLot parkingLotSizeOf20 = new ParkingLot(20,2);
        ParkingLot parkingLotSizeOf30 = new ParkingLot(30,3);
        manager.addParkingLot(parkingLotSizeOf10);
        manager.addParkingLot(parkingLotSizeOf20);
        manager.addParkingLot(parkingLotSizeOf30);
        manager.distributionParkingLot(parkingBoy1,parkingLotSizeOf10);
        manager.distributionParkingLot(parkingBoy2,parkingLotSizeOf20);
        manager.distributionParkingLot(parkingBoy3,parkingLotSizeOf30);
        manager.addParkingBoy(parkingBoy1);
        manager.addParkingBoy(parkingBoy2);
        manager.addParkingBoy(parkingBoy3);
        Car car = new Car("1 car's");
        Customer customer = new Customer(car);
        ParkingBoy orderParkingBoy = manager.getParkingBoyById("1");
        orderParkingBoy.addObserver(customer);
        orderParkingBoy.park(car);
        String successMessage = "Park Success!Your car is parking in 1 lot.";
        assertThat(customer.getSuccessMessage(),is(successMessage));
    }

}
