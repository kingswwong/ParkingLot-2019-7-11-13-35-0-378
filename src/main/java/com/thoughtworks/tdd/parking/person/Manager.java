package com.thoughtworks.tdd.parking.person;

import com.thoughtworks.tdd.parking.car.Car;
import com.thoughtworks.tdd.parking.parkingway.ParkingWay;
import com.thoughtworks.tdd.parking.relatedAffairs.ParkingLot;
import com.thoughtworks.tdd.parking.relatedAffairs.Ticket;

import java.util.ArrayList;
import java.util.List;

public class Manager extends ParkingBoy implements ParkingWay {
    private List<ParkingBoy> parkingBoyList = new ArrayList<>();
    private List<ParkingLot> parkingLotManagementList = new ArrayList<>();

    public void addParkingBoy(ParkingBoy parkingBoy){
        parkingBoyList.add(parkingBoy);
    }

    public void addParkingLot(ParkingLot parkingLot){
        super.getParkingLotList().add(parkingLot);
        parkingLotManagementList.add(parkingLot);
    }

    public void distributionParkingLot(ParkingBoy parkingBoy){
        parkingBoy.setParkingLotList(parkingLotManagementList);
    }

    public void distributionParkingLot(ParkingBoy parkingBoy,ParkingLot parkingLot){
        parkingBoy.getParkingLotList().add(parkingLot);
    }

    public ParkingBoy getParkingBoyById(String id){
        for(ParkingBoy parkingBoy: parkingBoyList){
            if(parkingBoy.getId().equals(id)){
                return parkingBoy;
            }
        }
        return null;
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
        return super.park(car, parkingWay());
    }

}
