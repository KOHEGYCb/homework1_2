package ru.mail.dimaushenko.service;

import java.lang.invoke.MethodHandles;
import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author dmitry
 */
public class RandNumbersService implements IService {

    private final int amount = 3;
    private final Random random = new Random();
    private final Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());

    @Override
    public void run() {

        int x = random.nextInt();
        int y = random.nextInt();
        int z = random.nextInt();

        if (x > z) {
            logger.debug("X + Y = " + (x + y));
        } else {
            logger.debug("Z = " + z);
        }

        int mean = (x + y + z) / amount;

        logger.info("mean: " + mean);
    }

}
