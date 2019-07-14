package com.thoughtworks.tdd;

import com.thoughtworks.tdd.parking.car.Car;
import com.thoughtworks.tdd.parking.person.Manager;
import com.thoughtworks.tdd.parking.person.ParkingBoy;
import com.thoughtworks.tdd.parking.relatedAffairs.ParkingLot;
import com.thoughtworks.tdd.parking.relatedAffairs.Ticket;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Story3Test {
    @Test
    public void should_park_the_car_to_parkingSizeOf20_when_parkingSizeOf10_is_full(){
        Manager manager = new Manager();
        ParkingLot parkingLotSizeOf10 = new ParkingLot();
        ParkingLot parkingLotSizeOf20 = new ParkingLot(10);
        manager.addParkingLot(parkingLotSizeOf10);
        manager.addParkingLot(parkingLotSizeOf20);
        ParkingBoy parkingBoy = new ParkingBoy();
        manager.distributionParkingLot(parkingBoy);
        for(int i = 0;i < 10;i++){
            parkingBoy.park(new Car(i + " car's"));
        }
        Car car = new Car("11 car's");
        Ticket returnTicket = parkingBoy.park(car);
        assertThat(returnTicket,is(car.getTicket()));
    }
}
