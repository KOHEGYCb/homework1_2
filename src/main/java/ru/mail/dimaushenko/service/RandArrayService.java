package ru.mail.dimaushenko.service;

import java.lang.invoke.MethodHandles;
import java.util.Arrays;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.mail.dimaushenko.utils.RandomUtil;

public class RandArrayService implements HomeWorkServices {

    private static final int MIN = -300;
    private static final int MAX = 300;
    private static final int AMOUNT = 10;

    private static final Logger LOGGER = LogManager.getLogger(MethodHandles.lookup().lookupClass());

    @Override
    public void run() {

        int arr[] = new int[AMOUNT];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = RandomUtil.getInt(MIN, MAX);
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
        LOGGER.info("Min: " + arr[maxElem] + "  Max: " + arr[minElem]);

        arr[maxElem] = arr[maxElem] * arr[minElem];

        LOGGER.error("Array: " + Arrays.toString(arr));

    }

}
