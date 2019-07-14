package com.thoughtworks.tdd.parking.relatedAffairs;

import com.thoughtworks.tdd.parking.car.Car;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private final int size;
    private List<Car> carList = new ArrayList<>();

    public ParkingLot() {
        this.size = 10;
    }

    public ParkingLot(int size) {
        this.size = size;
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
}
