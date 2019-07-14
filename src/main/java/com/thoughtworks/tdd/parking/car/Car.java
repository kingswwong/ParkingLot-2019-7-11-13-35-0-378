package com.thoughtworks.tdd.parking.car;

import com.thoughtworks.tdd.parking.relatedAffairs.Ticket;

import java.util.Objects;

public class Car {
    private String id;
    private Ticket ticket;

    public Car(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(id, car.id) &&
                Objects.equals(ticket, car.ticket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ticket);
    }
}
