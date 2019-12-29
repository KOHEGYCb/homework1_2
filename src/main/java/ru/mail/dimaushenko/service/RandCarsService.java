package ru.mail.dimaushenko.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import ru.mail.dimaushenko.beans.Car;
import ru.mail.dimaushenko.enums.CarModels;
import ru.mail.dimaushenko.utils.RandomUtil;

/**
 *
 * @author dmitry
 */
public class RandCarsService implements IService {

    private final int amount = 10;
    private final Random rand = new Random();
    private final int minEngineCapacity = 1;
    private final int maxEngineCapacity = 3;

    private final String filePath = "output";

    @Override
    public void run() {
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            Car car = new Car();
            car.setName("Car_" + i);
            car.setCarModel(getRandCarModel());
            car.setEngineCapacity(RandomUtil.getInt(minEngineCapacity, maxEngineCapacity));
            cars.add(car);
        }
        Map<Integer, List<Car>> mapCars = new HashMap<>();
        for (Car car : cars) {
            if (!mapCars.containsKey(car.getEngineCapacity())) {
                mapCars.put(car.getEngineCapacity(), new ArrayList<>());
            }
            mapCars.get(car.getEngineCapacity()).add(car);
        }
        try (PrintWriter print = new PrintWriter(new File(filePath))) {
            for (int i : mapCars.keySet()) {
                for (Car car : mapCars.get(i)) {
                    print.println(car);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RandCarsService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private CarModels getRandCarModel() {
        return CarModels.values()[rand.nextInt(CarModels.values().length)];
    }

}
