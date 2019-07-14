package com.thoughtworks.tdd;

import com.thoughtworks.tdd.parking.*;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Story1Test {



    @Test
    public void should_return_a_ticket_when_customer_give_a_car_to_parking_boy_to_park() {
        Manager manager = new Manager();
        ParkingLot parkingLotSizeOf10 = new ParkingLot();
        ParkingLot parkingLotSizeOf20 = new ParkingLot(10);
        manager.addParkingLot(parkingLotSizeOf10);
        manager.addParkingLot(parkingLotSizeOf20);
        ParkingBoy parkingBoy = new ParkingBoy();
        manager.distributionParkingLot(parkingBoy);
        //given
        Car car = new Car("ac1's car");
        //when
        Ticket ticket = parkingBoy.park(car);
        String result = "ac1's car ticket";
        //then
        assertThat(ticket.getId(),is(result));
    }
}
