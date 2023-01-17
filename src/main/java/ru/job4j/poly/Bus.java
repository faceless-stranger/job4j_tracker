package ru.job4j.poly;

public class Bus implements Transport {
    private int passengers;

    @Override
    public void drive() {
        System.out.println("Автобус едет");
    }

    @Override
    public void passengers(int count) {
        this.passengers = count;
    }

    @Override
    public float refuel(float count) {
        return count * 52.3F;
    }
}
