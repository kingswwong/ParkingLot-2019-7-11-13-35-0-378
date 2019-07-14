package com.thoughtworks.tdd;

import com.thoughtworks.tdd.parking.car.Car;
import com.thoughtworks.tdd.parking.person.Manager;
import com.thoughtworks.tdd.parking.person.NormalParkingBoy;
import com.thoughtworks.tdd.parking.person.ParkingBoy;
import com.thoughtworks.tdd.parking.relatedAffairs.ParkingLot;
import com.thoughtworks.tdd.parking.relatedAffairs.Ticket;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class Story1Test {



    @Test
    public void should_return_a_ticket_when_customer_give_a_car_to_parking_boy_to_park_and_should_return_back_car_when_given_the_ticket() {
        Manager manager = new Manager();
        ParkingLot parkingLotSizeOf10 = new ParkingLot();
        manager.addParkingLot(parkingLotSizeOf10);
        NormalParkingBoy parkingBoy = new NormalParkingBoy();
        manager.distributionParkingLot(parkingBoy);
        //given
        Car car = new Car("ac1's car");
        //when
        Ticket ticket = parkingBoy.parking(car);
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
        manager.addParkingLot(parkingLotSizeOf10);
        NormalParkingBoy parkingBoy = new NormalParkingBoy();
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
        parkingBoy.parking(car);
        returnCar = parkingBoy.fetch(ticketNewTicket);
        //then
        assertThat(returnCar,is(nullValue()));
    }

    @Test
    public void should_return_null_when_ticket_is_been_used(){
        Manager manager = new Manager();
        ParkingLot parkingLotSizeOf10 = new ParkingLot();
        manager.addParkingLot(parkingLotSizeOf10);
        NormalParkingBoy parkingBoy = new NormalParkingBoy();
        manager.distributionParkingLot(parkingBoy);
        //given
        Car car = new Car("ac4's car");
        //when
        Ticket returnTicket = parkingBoy.parking(car);
        parkingBoy.fetch(returnTicket);
        Car returnCar = parkingBoy.fetch(returnTicket);
        //then
        assertThat(returnCar, is(nullValue()));
    }

    @Test
    public void should_return_null_when_parkinglot_is_full(){
        Manager manager = new Manager();
        ParkingLot parkingLotSizeOf10 = new ParkingLot();
        manager.addParkingLot(parkingLotSizeOf10);
        NormalParkingBoy parkingBoy = new NormalParkingBoy();
        manager.distributionParkingLot(parkingBoy);
        for(int i = 0;i < 10;i++){
            parkingBoy.parking(new Car(i + " car's"));
        }
        Car car = new Car("11 car's");
        Ticket returnTicket = parkingBoy.parking(car);
        assertThat(returnTicket,is(nullValue()));
    }

    @Test
    public void should_return_null_when_car_is_parked(){
        Manager manager = new Manager();
        ParkingLot parkingLotSizeOf10 = new ParkingLot();
        manager.addParkingLot(parkingLotSizeOf10);
        NormalParkingBoy parkingBoy = new NormalParkingBoy();
        manager.distributionParkingLot(parkingBoy);
        //given
        Car car = new Car("ac7's car");
        //when
         parkingBoy.parking(car);
        Ticket returnTicket = parkingBoy.parking(car);
        //then
        assertThat(returnTicket, is(nullValue()));
    }

    @Test
    public void should_return_null_when_car_is_null(){
        Manager manager = new Manager();
        ParkingLot parkingLotSizeOf10 = new ParkingLot();
        manager.addParkingLot(parkingLotSizeOf10);
        NormalParkingBoy parkingBoy = new NormalParkingBoy();
        manager.distributionParkingLot(parkingBoy);
        //given
        Car car = null;
        //when
        Ticket returnTicket = parkingBoy.parking(car);
        //then
        assertThat(returnTicket, is(nullValue()));
    }
}
