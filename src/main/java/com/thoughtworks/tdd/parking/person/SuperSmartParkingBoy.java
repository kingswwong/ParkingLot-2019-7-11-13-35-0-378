package com.thoughtworks.tdd.parking.person;

import com.thoughtworks.tdd.parking.car.Car;
import com.thoughtworks.tdd.parking.parkingway.ParkingWay;
import com.thoughtworks.tdd.parking.relatedAffairs.ParkingLot;
import com.thoughtworks.tdd.parking.relatedAffairs.Ticket;

public class SuperSmartParkingBoy extends ParkingBoy implements ParkingWay {

    public SuperSmartParkingBoy() {
    }

    public SuperSmartParkingBoy(String id) {
        super(id);
    }

    @Override
    public ParkingLot parkingWay() {
        ParkingLot parkingLotIsMoreEmpty = null;
        double min = Double.MIN_VALUE;
        for(ParkingLot parkingLot: this.getParkingLotList()){
            if(parkingLot.getCarList().size() + 1 < parkingLot.getSize()){
                double parkingRate = (parkingLot.getSize() - parkingLot.getCarList().size()) / parkingLot.getSize();
                if(parkingRate > min){
                    min = parkingRate ;
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
