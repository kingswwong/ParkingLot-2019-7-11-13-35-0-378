package com.thoughtworks.tdd.parking;

public class ParkingBoy {
    private ParkingLot parkingLot;

    public Ticket park(Car car){
        Ticket ticket = new Ticket(car.getId() + " ticket");
        car.setTicket(ticket);
        return ticket;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }
}
