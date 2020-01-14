package com.bruse.extension;

public class RaceCar extends Car {
    Wheel wheel;

    public RaceCar(Wheel wheel) {
        this.wheel = wheel;
    }

    public Wheel getWheel() {
        return wheel;
    }

    public void setWheel(Wheel wheel) {
        this.wheel = wheel;
    }
}
