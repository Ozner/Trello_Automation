package helpers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;

public class Utils {

    public static long generateRandomNumber(int digits) {
        long min = (long) Math.pow(10, digits - 1);
        return ThreadLocalRandom.current().nextLong(min, min * 10);
    }
}
