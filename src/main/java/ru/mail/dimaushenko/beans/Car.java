package ru.mail.dimaushenko.beans;

import ru.mail.dimaushenko.enums.CarModels;

/**
 *
 * @author dmitry
 */
public class Car {

    private String name;
    private CarModels carModel;
    private int engineCapacity;

    public Car() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CarModels getCarModel() {
        return carModel;
    }

    public void setCarModel(CarModels carModel) {
        this.carModel = carModel;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(int engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    @Override
    public String toString() {
        return name + " : " + carModel + " : " + engineCapacity;
    }

}
