package com.thoughtworks.tdd.parking.person;

import com.thoughtworks.tdd.parking.car.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Customer implements Observer {

    private Car car;
    private List<String> wrongMessageList = new ArrayList<>();

    public Customer(Car car) {
        this.car = car;
    }

    @Override
    public void update(Observable o, Object arg) {
        wrongMessageList.add(arg.toString());
    }

    public List<String> getWrongMessageList() {
        return wrongMessageList;
    }

    public void setWrongMessageList(List<String> wrongMessageList) {
        this.wrongMessageList = wrongMessageList;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
