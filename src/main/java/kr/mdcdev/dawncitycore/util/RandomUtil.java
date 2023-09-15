package kr.mdcdev.dawncitycore.util;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtil {
    
    private static final ThreadLocalRandom random = ThreadLocalRandom.current();

    public static ThreadLocalRandom getRandom() {
        return random;
    }

    public static double getRandomDouble(double min, double max) {
        return random.nextDouble(min, max);
    }

    public static float getRandomFloat(float min, float max) {
        return random.nextFloat() * (max - min) + min;
    }

    public static int getRandomInt(int min, int max) {
        return random.nextInt(min, max);
    }

    public static <E> E getWeightedRandom(Map<E, Double> weights) {
        E result = null;
        double bestValue = Double.MAX_VALUE;

        for (Map.Entry<E, Double> entry : weights.entrySet()) {
            double value = -Math.log(random.nextDouble()) / entry.getValue();

            if (value < bestValue) {
                bestValue = value;
                result = entry.getKey();
            }
        }
        
        return result;
    }
}