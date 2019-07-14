package com.thoughtworks.tdd.parking.person;

import com.thoughtworks.tdd.parking.car.Car;
import com.thoughtworks.tdd.parking.relatedAffairs.ParkingLot;
import com.thoughtworks.tdd.parking.relatedAffairs.Ticket;

import java.util.List;
import java.util.Observable;

public class ParkingBoy extends Observable {
    private ParkingLot parkingLot;

    public Ticket park(Car car) {
        if(car == null){
            return null;
        }
        if(parkingLot.getCarList().size() + 1 >= parkingLot.getSize()){
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
        return ticket;
    }

    public Car fetch(Ticket ticket) {
        if(ticket == null){
            return null;
        }
        List<Car> carList = parkingLot.getCarList();
        for (Car car : carList) {
            if(car.getTicket().equals(ticket)){
                carList.remove(car);
                return car;
            }
        }
        setChanged();
        notifyObservers("Unrecognized parking ticket.");
        return null;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }
}
