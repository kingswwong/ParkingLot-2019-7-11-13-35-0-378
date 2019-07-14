package com.thoughtworks.tdd.parking.person;

import com.thoughtworks.tdd.parking.car.Car;
import com.thoughtworks.tdd.parking.parkingway.ParkingWay;
import com.thoughtworks.tdd.parking.relatedAffairs.ParkingLot;
import com.thoughtworks.tdd.parking.relatedAffairs.Ticket;

public class NormalParkingBoy extends ParkingBoy implements ParkingWay {

    public NormalParkingBoy() {
    }

    public NormalParkingBoy(String id) {
        super(id);
    }

    @Override
    public ParkingLot parkingWay() {
        ParkingLot parkingLotIsMoreEmpty = null;
        for(ParkingLot parkingLot: this.getParkingLotList()){
            if(parkingLot.getCarList().size() + 1 < parkingLot.getSize()){
                if(parkingLot.getSize() - parkingLot.getCarList().size() > 0){
                    return parkingLot;
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
