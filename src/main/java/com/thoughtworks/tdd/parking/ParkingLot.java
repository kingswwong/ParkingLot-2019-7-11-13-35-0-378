package com.thoughtworks.tdd.parking;

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
}
