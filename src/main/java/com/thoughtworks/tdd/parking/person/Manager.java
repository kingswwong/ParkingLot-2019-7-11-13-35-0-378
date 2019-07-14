package com.thoughtworks.tdd.parking.person;

import com.thoughtworks.tdd.parking.car.Car;
import com.thoughtworks.tdd.parking.parkingway.ParkingWay;
import com.thoughtworks.tdd.parking.relatedAffairs.ParkingLot;
import com.thoughtworks.tdd.parking.relatedAffairs.Ticket;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Manager extends Observable implements ParkingWay,Observer {
    private List<ParkingBoy> parkingBoyList = new ArrayList<>();
    private List<ParkingLot> parkingLotManagementList = new ArrayList<>();

    public void addParkingBoy(ParkingBoy parkingBoy){
        parkingBoyList.add(parkingBoy);
    }

    public void addParkingLot(ParkingLot parkingLot){
        parkingLotManagementList.add(parkingLot);
    }

    public void distributionParkingLot(ParkingBoy parkingBoy){
        parkingBoy.setParkingLotList(parkingLotManagementList);
    }

    public void distributionParkingLot(ParkingBoy parkingBoy,ParkingLot parkingLot){
        if(parkingLotManagementList.contains(parkingLot)){
            for(ParkingLot parkingLot1: parkingLotManagementList){
                if(parkingLot.equals(parkingLot1) && parkingLot1.isDistribution() == false){
                    parkingLot1.setDistribution(true);
                    parkingBoy.getParkingLotList().add(parkingLot1);
                    break;
                }
            }
        }
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
        for(ParkingLot parkingLot: this.parkingLotManagementList){
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
        if(car == null){
            return null;
        }
        ParkingLot parkingLotIsMoreEmpty = null;
        int min = Integer.MIN_VALUE;
        for(ParkingLot parkingLot: this.parkingLotManagementList){
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

    @Override
    public Car fetch(Ticket ticket) {
        if(ticket == null){
            setChanged();
            notifyObservers("Please provide your parking ticket.");
            return null;
        }
        for(ParkingLot parkingLotInMange: parkingLotManagementList){
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

    public Ticket orderParkingBoyToPark(Car car){
        ParkingBoy randomParkingBoy = this.parkingBoyList.get(0);
        Ticket ticket = randomParkingBoy.parking(car);
        return ticket;
    }

    @Override
    public void update(Observable o, Object arg) {
        setChanged();
        notifyObservers(arg.toString());
    }
}
