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

public class Story2Test {

    @Test
    public void should_return_error_message_Unrecognized_parking_ticket_when_customer_given_the_wrong_ticket_or_ticket_is_been_user(){
        Manager manager = new Manager();
        ParkingLot parkingLotSizeOf10 = new ParkingLot();
        manager.addParkingLot(parkingLotSizeOf10);
        ParkingBoy parkingBoy = new ParkingBoy();
        manager.distributionParkingLot(parkingBoy);
        //given
        Car car = new Car("customer1 Car");
        Customer customer1 = new Customer(car);
        parkingBoy.addObserver(customer1);
        //when
        Ticket reusltTicket = parkingBoy.park(car);
        //the parking boy does not provide the ticket
        parkingBoy.fetch(new Ticket("wrong ticket"));
        //the ticket has been used
        parkingBoy.fetch(reusltTicket);
        parkingBoy.fetch(reusltTicket);
        //then
        assertThat(customer1.getWrongMessageList().get(0),is("Unrecognized parking ticket."));
        assertThat(customer1.getWrongMessageList().get(1),is("Unrecognized parking ticket."));
    }

    @Test
    public void should_return_error_message_Please_provide_your_parking_ticket_when_given_null_ticket(){
        Manager manager = new Manager();
        ParkingLot parkingLotSizeOf10 = new ParkingLot();
        manager.addParkingLot(parkingLotSizeOf10);
        ParkingBoy parkingBoy = new ParkingBoy();
        manager.distributionParkingLot(parkingBoy);
        //given
        Car car = new Car("customer1 Car");
        Customer customer1 = new Customer(car);
        parkingBoy.addObserver(customer1);
        //when
        parkingBoy.park(car);
        parkingBoy.fetch(null);
        //then
        assertThat(customer1.getWrongMessageList().get(0),is("Please provide your parking ticket."));
    }

    @Test
    public void should_return_error_message_Not_enough_position_when_parkinglot_is_full(){
        Manager manager = new Manager();
        ParkingLot parkingLotSizeOf10 = new ParkingLot();
        manager.addParkingLot(parkingLotSizeOf10);
        ParkingBoy parkingBoy = new ParkingBoy();
        manager.distributionParkingLot(parkingBoy);
        for(int i = 0;i < 10;i++){
            parkingBoy.park(new Car(i + " car's"));
        }
        //given
        Car car = new Car("customer1 Car");
        Customer customer1 = new Customer(car);
        parkingBoy.addObserver(customer1);
        //when
        parkingBoy.park(car);
        //then
        assertThat(customer1.getWrongMessageList().get(0),is("Not enough position."));
    }
}
