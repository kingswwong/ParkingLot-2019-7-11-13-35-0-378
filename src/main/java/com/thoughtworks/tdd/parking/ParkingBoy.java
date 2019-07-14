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
        List<Car> carList = parkingLot.getCarList();
        for (Car car : carList) {
            if(car.getTicket().equals(ticket)){
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
