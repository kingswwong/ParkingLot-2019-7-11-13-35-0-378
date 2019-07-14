package com.thoughtworks.tdd.parking.parkingway;

import com.thoughtworks.tdd.parking.car.Car;
import com.thoughtworks.tdd.parking.relatedAffairs.ParkingLot;
import com.thoughtworks.tdd.parking.relatedAffairs.Ticket;

public interface ParkingWay {
    ParkingLot parkingWay();
    Ticket parking(Car car);
}
