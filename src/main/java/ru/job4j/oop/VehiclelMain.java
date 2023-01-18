package ru.job4j.oop;

public class VehiclelMain {
    public static void main(String[] args) {
        Vehicle bus = new Bus();
        Vehicle airplane = new Airplane();
        Vehicle train = new Train();
        Vehicle[] vehicle = new Vehicle[]{airplane, train, bus};
        for (Vehicle i : vehicle) {
            i.move();
        }
    }
}
