package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void drive() {
        System.out.println("Автобус едет");
    }

    @Override
    public void passengers(int count) {

    }

    @Override
    public float refuel(float count) {
        return count * 52.3F;
    }
}
