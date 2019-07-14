package com.thoughtworks.tdd.parking.person;

import com.thoughtworks.tdd.parking.car.Car;
import com.thoughtworks.tdd.parking.relatedAffairs.ParkingLot;
import com.thoughtworks.tdd.parking.relatedAffairs.Ticket;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class ParkingBoy extends Observable {
    private List<ParkingLot> parkingLotList = new ArrayList<>();

    public Ticket park(Car car) {
        ParkingLot parkingLotIsMoreEmpty = null;
        if(car == null){
            return null;
        }
        int min = Integer.MIN_VALUE;
        for(ParkingLot parkingLot: parkingLotList){
            if(parkingLot.getCarList().size() + 1 < parkingLot.getSize()){
                if(parkingLot.getSize() - parkingLot.getCarList().size() > min){
                    min = parkingLot.getSize() - parkingLot.getCarList().size();
                    parkingLotIsMoreEmpty = parkingLot;
                }
            }
        }
        if(parkingLotIsMoreEmpty == null){
            setChanged();
            notifyObservers("Not enough position.");
            return null;
        }
        for(Car parkingCar: parkingLotIsMoreEmpty.getCarList()){
            if(car.equals(parkingCar)){
                return null;
            }
        }
        Ticket ticket = new Ticket(car.getId() + " ticket");
        car.setTicket(ticket);
        parkingLotIsMoreEmpty.getCarList().add(car);
        setChanged();
        notifyObservers("Park Success!Your car is parking in " + parkingLotIsMoreEmpty.getId() + " lot.");
        return ticket;
    }

    public Car fetch(Ticket ticket) {
        if(ticket == null){
            setChanged();
            notifyObservers("Please provide your parking ticket.");
            return null;
        }
        for(ParkingLot parkingLotInMange: parkingLotList){
            List<Car> carList = parkingLotInMange.getCarList();
            for (Car car : carList) {
                if(car.getTicket().equals(ticket)){
                    carList.remove(car);
                    return car;
                }
            }
        }
        setChanged();
        notifyObservers("Unrecognized parking ticket.");
        return null;
    }

    public List<ParkingLot> getParkingLot() {
        return parkingLotList;
    }

    public void setParkingLot(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }
}
