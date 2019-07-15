package com.thoughtworks.tdd.parking.person;

import com.thoughtworks.tdd.parking.car.Car;
import com.thoughtworks.tdd.parking.parkingway.ParkingWay;
import com.thoughtworks.tdd.parking.relatedAffairs.ParkingLot;
import com.thoughtworks.tdd.parking.relatedAffairs.Ticket;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public abstract class ParkingBoy extends Observable implements ParkingWay{
    private String id;
    private List<ParkingLot> parkingLotList = new ArrayList<>();

    public ParkingBoy() {
    }

    public ParkingBoy(String id) {
        this.id = id;
    }

    public Ticket park(Car car,ParkingLot parkingLot) {
        if(car == null){
            return null;
        }
        if(parkingLot == null){
            setChanged();
            notifyObservers("Not enough position.");
            return null;
        }
        for(Car parkingCar: parkingLot.getCarList()){
            if(car.equals(parkingCar)){
                return null;
            }
        }
        Ticket ticket = new Ticket(car.getId() + " ticket");
        car.setTicket(ticket);
        parkingLot.getCarList().add(car);
        setChanged();
        notifyObservers("Park Success!Your car is parking in " + parkingLot.getId() + " lot.");
        return ticket;
    }

    @Override
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


    public List<ParkingLot> getParkingLotList() {
        return parkingLotList;
    }

    public void setParkingLotList(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
