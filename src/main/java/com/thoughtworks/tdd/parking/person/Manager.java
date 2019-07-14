package com.thoughtworks.tdd.parking.person;

import com.thoughtworks.tdd.parking.relatedAffairs.ParkingLot;

import java.util.ArrayList;
import java.util.List;

public class Manager {
    private List<ParkingBoy> parkingBoyList = new ArrayList<>();
    private List<ParkingLot> parkingLotList = new ArrayList<>();

    public void addParkingBoy(ParkingBoy parkingBoy){
        parkingBoyList.add(parkingBoy);
    }

    public void addParkingLot(ParkingLot parkingLot){
        parkingLotList.add(parkingLot);
    }

    public void distributionParkingLot(ParkingBoy parkingBoy){
        parkingBoy.setParkingLot(parkingLotList);
    }

    public void distributionParkingLot(ParkingBoy parkingBoy,ParkingLot parkingLot){
        parkingBoy.getParkingLot().add(parkingLot);
    }

    public ParkingBoy getParkingBoyById(String id){
        for(ParkingBoy parkingBoy: parkingBoyList){
            if(parkingBoy.getId().equals(id)){
                return parkingBoy;
            }
        }
        return null;
    }
}
