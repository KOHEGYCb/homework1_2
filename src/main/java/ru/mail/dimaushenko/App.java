package ru.mail.dimaushenko;

import ru.mail.dimaushenko.service.IService;
import ru.mail.dimaushenko.service.RandArrayService;
import ru.mail.dimaushenko.service.RandCarsService;
import ru.mail.dimaushenko.service.RandNumbersService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        IService first = new RandNumbersService();
        first.run();

        IService second = new RandArrayService();
        second.run();

        IService third = new RandCarsService();
        third.run();

    }
}
