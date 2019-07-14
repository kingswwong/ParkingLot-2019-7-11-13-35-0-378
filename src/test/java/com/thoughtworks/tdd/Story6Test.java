package com.thoughtworks.tdd;

import com.thoughtworks.tdd.parking.car.Car;
import com.thoughtworks.tdd.parking.person.*;
import com.thoughtworks.tdd.parking.relatedAffairs.ParkingLot;
import com.thoughtworks.tdd.parking.relatedAffairs.Ticket;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Story6Test {

    @Test
    public void should_park_the_car_to_the_lot_management_by_parkingboy1_when_manager_other_him_to_park(){
        Manager manager = new Manager();
        NormalParkingBoy normalParkingBoy = new NormalParkingBoy("1");
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy("2");
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy("3");
        ParkingLot parkingLotSizeOf10 = new ParkingLot(10,1);
        ParkingLot parkingLotSizeOf20 = new ParkingLot(20,2);
        ParkingLot parkingLotSizeOf30 = new ParkingLot(30,3);
        manager.addParkingLot(parkingLotSizeOf10);
        manager.addParkingLot(parkingLotSizeOf20);
        manager.addParkingLot(parkingLotSizeOf30);
        manager.distributionParkingLot(normalParkingBoy,parkingLotSizeOf10);
        manager.distributionParkingLot(smartParkingBoy,parkingLotSizeOf20);
        manager.distributionParkingLot(superSmartParkingBoy,parkingLotSizeOf30);
        manager.addParkingBoy(normalParkingBoy);
        manager.addParkingBoy(smartParkingBoy);
        manager.addParkingBoy(superSmartParkingBoy);
        Car car = new Car("1 car's");
        Customer customer = new Customer(car);
        NormalParkingBoy orderParkingBoy = (NormalParkingBoy) manager.getParkingBoyById("1");
        orderParkingBoy.addObserver(customer);
        orderParkingBoy.parking(car);
        String successMessage = "Park Success!Your car is parking in 1 lot.";
        assertThat(customer.getSuccessMessage(),is(successMessage));
    }

    @Test
    public void should_park_the_car_to_the_lot_by_manager(){
        Manager manager = new Manager();
        ParkingLot parkingLotSizeOf10 = new ParkingLot(10,1);
        ParkingLot parkingLotSizeOf20 = new ParkingLot(20,2);
        ParkingLot parkingLotSizeOf30 = new ParkingLot(30,3);
        manager.addParkingLot(parkingLotSizeOf10);
        manager.addParkingLot(parkingLotSizeOf20);
        manager.addParkingLot(parkingLotSizeOf30);
        Car car = new Car("1 car's");
        Customer customer = new Customer(car);
        manager.addObserver(customer);
        //parking
        Ticket returnTicket = manager.parking(car);
//        String successMessage = "Park Success!Your car is parking in 3 lot.";
        assertThat(car.getTicket(),is(returnTicket));
        //fetch
        Car returnCar = manager.fetch(returnTicket);
        assertThat(car,is(returnCar));
    }

    @Test
    public void should_the_manager_tell_the_error_message_Unrecognized_parking_ticket_when_customer_given_the_wrong_ticket_or_ticket_is_been_user(){
        Manager manager = new Manager();
        ParkingLot parkingLotSizeOf10 = new ParkingLot();
        manager.addParkingLot(parkingLotSizeOf10);
        NormalParkingBoy parkingBoy = new NormalParkingBoy();
        manager.distributionParkingLot(parkingBoy);
        //given
        Car car = new Car("customer1 Car");
        Customer customer1 = new Customer(car);
        parkingBoy.addObserver(customer1);
        //when
        Ticket reusltTicket = parkingBoy.parking(car);
        //the parking boy does not provide the ticket
        parkingBoy.fetch(new Ticket("wrong ticket"));
        //the ticket has been used
        parkingBoy.fetch(reusltTicket);
        parkingBoy.fetch(reusltTicket);
        //then
        assertThat(customer1.getWrongMessageList().get(0),is("Unrecognized parking ticket."));
        assertThat(customer1.getWrongMessageList().get(1),is("Unrecognized parking ticket."));
    }
}
