package com.thoughtworks.tdd.parking.relatedAffairs;

import com.thoughtworks.tdd.parking.car.Car;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private final int size;
    private List<Car> carList = new ArrayList<>();
    private int id;

    public ParkingLot() {
        this.size = 10;
    }

    public ParkingLot(int size) {
        this.size = size;
    }

    public ParkingLot(int size, int id) {
        this.size = size;
        this.id = id;
    }

    public int getSize() {
        return size;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
