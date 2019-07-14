package com.thoughtworks.tdd;

import com.thoughtworks.tdd.parking.*;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class Story1Test {



    @Test
    public void should_return_a_ticket_when_customer_give_a_car_to_parking_boy_to_park_and_should_return_back_car_when_given_the_ticket() {
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
        //then
        assertThat(car.getTicket(),is(ticket));

        //given ticket
        //when
        Car returnCar = parkingBoy.fetch(ticket);
        //then
        assertThat(returnCar,is(car));
    }

    @Test
    public void should_return_null_when_ticket_is_wrong_or_null(){
        Manager manager = new Manager();
        ParkingLot parkingLotSizeOf10 = new ParkingLot();
        ParkingLot parkingLotSizeOf20 = new ParkingLot(10);
        manager.addParkingLot(parkingLotSizeOf10);
        manager.addParkingLot(parkingLotSizeOf20);
        ParkingBoy parkingBoy = new ParkingBoy();
        manager.distributionParkingLot(parkingBoy);
        //given
        Ticket ticketNewTicket = new Ticket("ac4's car Ticket");
        //when
        Car returnCar = parkingBoy.fetch(ticketNewTicket);
        //then
        assertThat(returnCar,is(nullValue()));
        //given
        Car car = new Car("ac3's car");
        //when
        parkingBoy.park(car);
        returnCar = parkingBoy.fetch(ticketNewTicket);
        //then
        assertThat(returnCar,is(nullValue()));
    }

    @Test
    public void should_return_null_when_ticket_is_been_used(){
        Manager manager = new Manager();
        ParkingLot parkingLotSizeOf10 = new ParkingLot();
        ParkingLot parkingLotSizeOf20 = new ParkingLot(10);
        manager.addParkingLot(parkingLotSizeOf10);
        manager.addParkingLot(parkingLotSizeOf20);
        ParkingBoy parkingBoy = new ParkingBoy();
        manager.distributionParkingLot(parkingBoy);
        //given
        Car car = new Car("ac4's car");
        //when
        Ticket returnTicket = parkingBoy.park(car);
        parkingBoy.fetch(returnTicket);
        Car returnCar = parkingBoy.fetch(returnTicket);
        //then
        assertThat(returnCar, is(nullValue()));
    }
}
