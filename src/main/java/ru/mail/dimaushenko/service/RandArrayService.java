package ru.mail.dimaushenko.service;

import java.lang.invoke.MethodHandles;
import java.util.Arrays;
import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.mail.dimaushenko.utils.RandomUtil;

/**
 *
 * @author dmitry
 */
public class RandArrayService implements IService {

    private final int min = -300;
    private final int max = 300;
    private final int amount = 10;

    private final Random rand = new Random();
    private final Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());

    @Override
    public void run() {

        int arr[] = new int[amount];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = RandomUtil.getInt(min, max);
        }

        int maxElem = 0;
        int minElem = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[maxElem] < arr[i]) {
                maxElem = i;
            }
            if (arr[minElem] > arr[i]) {
                minElem = i;
            }
        }
        logger.info("Min: " + arr[maxElem] + "  Max: " + arr[minElem]);

        arr[maxElem] = arr[maxElem] * arr[minElem];

        logger.error("Array: " + Arrays.toString(arr));

    }

}
