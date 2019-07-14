package com.thoughtworks.tdd.parking.person;

import com.thoughtworks.tdd.parking.car.Car;
import com.thoughtworks.tdd.parking.parkingway.ParkingWay;
import com.thoughtworks.tdd.parking.relatedAffairs.ParkingLot;
import com.thoughtworks.tdd.parking.relatedAffairs.Ticket;

public class SmartParkingBoy extends ParkingBoy implements ParkingWay {

    public SmartParkingBoy() {
    }

    public SmartParkingBoy(String id) {
        super(id);
    }

    @Override
    public ParkingLot parkingWay() {
        ParkingLot parkingLotIsMoreEmpty = null;
        int min = Integer.MIN_VALUE;
        for(ParkingLot parkingLot: this.getParkingLotList()){
            if(parkingLot.getCarList().size() + 1 < parkingLot.getSize()){
                if(parkingLot.getSize() - parkingLot.getCarList().size() > min){
                    min = parkingLot.getSize() - parkingLot.getCarList().size();
                    parkingLotIsMoreEmpty = parkingLot;
                }
            }
        }
        return parkingLotIsMoreEmpty;
    }

    @Override
    public Ticket parking(Car car) {
        return super.park(car,parkingWay());
    }
}
