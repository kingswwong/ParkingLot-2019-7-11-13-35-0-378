package com.thoughtworks.tdd.parking.person;

import com.thoughtworks.tdd.parking.relatedAffairs.ParkingLot;

import java.util.ArrayList;
import java.util.List;

public class Manager {
    private List<ParkingLot> parkingLotList = new ArrayList<>();


    public void addParkingLot(ParkingLot parkingLot){
        parkingLotList.add(parkingLot);
    }

    public void distributionParkingLot(ParkingBoy parkingBoy){
        parkingBoy.setParkingLot(parkingLotList.get(0));
    }
}
