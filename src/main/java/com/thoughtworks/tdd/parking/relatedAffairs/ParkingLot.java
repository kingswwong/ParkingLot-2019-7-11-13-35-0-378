package com.thoughtworks.tdd.parking.relatedAffairs;

import com.thoughtworks.tdd.parking.car.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParkingLot that = (ParkingLot) o;
        return size == that.size &&
                id == that.id &&
                Objects.equals(carList, that.carList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, carList, id);
    }
}
