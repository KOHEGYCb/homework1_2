package ru.mail.dimaushenko;

import ru.mail.dimaushenko.service.RandArrayService;
import ru.mail.dimaushenko.service.RandCarsService;
import ru.mail.dimaushenko.service.RandNumbersService;
import ru.mail.dimaushenko.service.HomeWorkServices;

public class App {

    public static void main(String[] args) {
        HomeWorkServices first = new RandNumbersService();
        first.run();

        HomeWorkServices second = new RandArrayService();
        second.run();

        HomeWorkServices third = new RandCarsService();
        third.run();

    }
}
