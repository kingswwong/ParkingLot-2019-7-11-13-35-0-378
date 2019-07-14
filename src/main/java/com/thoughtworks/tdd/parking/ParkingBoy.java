package com.thoughtworks.tdd.parking;

import java.util.List;

public class ParkingBoy {
    private ParkingLot parkingLot;

    public Ticket park(Car car) {
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
        return null;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }
}
