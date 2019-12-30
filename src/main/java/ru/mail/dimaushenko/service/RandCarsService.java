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
import ru.mail.dimaushenko.model.Car;
import ru.mail.dimaushenko.model.CarModelEnum;
import ru.mail.dimaushenko.utils.RandomUtil;

public class RandCarsService implements HomeWorkServices {

    private static final int AMOUNT = 10;
    private static final Random RAND = new Random();
    private static final int MIN_ENGINE_CAPACITY = 1;
    private static final int MAX_ENGINE_CAPACITY = 3;

    private static final String FILE_PATH = "output";

    @Override
    public void run() {
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < AMOUNT; i++) {
            Car car = new Car();
            car.setName("Car_" + i);
            car.setCarModel(getRandCarModel());
            car.setEngineCapacity(RandomUtil.getInt(MIN_ENGINE_CAPACITY, MAX_ENGINE_CAPACITY));
            cars.add(car);
        }
        Map<Integer, List<Car>> mapCars = new HashMap<>();
        for (Car car : cars) {
            if (!mapCars.containsKey(car.getEngineCapacity())) {
                mapCars.put(car.getEngineCapacity(), new ArrayList<>());
            }
            mapCars.get(car.getEngineCapacity()).add(car);
        }
        try (PrintWriter print = new PrintWriter(new File(FILE_PATH))) {
            for (int i : mapCars.keySet()) {
                for (Car car : mapCars.get(i)) {
                    print.println(car);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RandCarsService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private CarModelEnum getRandCarModel() {
        return CarModelEnum.values()[RAND.nextInt(CarModelEnum.values().length)];
    }

}
