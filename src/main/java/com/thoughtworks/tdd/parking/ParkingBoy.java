package com.thoughtworks.tdd.parking;

public class ParkingBoy {
    private ParkingLot parkingLot;

    public Ticket park(Car car){
        Ticket ticket = new Ticket(car.getId() + " ticket");
        car.setTicket(ticket);
        parkingLot.getCarList().add(car);
        return ticket;
    }

    public Car fetch(Ticket ticket){
        return null;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }
}
