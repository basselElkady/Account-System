package edu.mum.cs.cs525.labs.exercises.project.accountparty;

import java.util.Random;

public final class RandomGenerator {

    private static final Random random = new Random();
    private static final int[] DIGITS = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    private RandomGenerator() {}


    public static String generateCCNumber() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            sb.append(DIGITS[random.nextInt(DIGITS.length)]);
        }
        return sb.toString();
    }


    public static String generateCVV() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append(DIGITS[random.nextInt(DIGITS.length)]);
        }
        return sb.toString();
    }



    public static String generateAccountNumber() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(DIGITS[random.nextInt(DIGITS.length)]);
        }
        return sb.toString();
    }
}
