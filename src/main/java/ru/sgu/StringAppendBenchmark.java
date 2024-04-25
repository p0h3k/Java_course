package ru.sgu;

import java.util.Random;

public class StringAppendBenchmark {
    public static void main(String[] args) {
        long startTimeStringBuilder = System.currentTimeMillis();
        appendWithStringBuilder();
        long endTimeStringBuilder = System.currentTimeMillis();
        long totalTimeStringBuilder = endTimeStringBuilder - startTimeStringBuilder;
        System.out.println("Общее время с StringBuilder: " + totalTimeStringBuilder + " миллисекунд");

        long startTimeStringBuffer = System.currentTimeMillis();
        appendWithStringBuffer();
        long endTimeStringBuffer = System.currentTimeMillis();
        long totalTimeStringBuffer = endTimeStringBuffer - startTimeStringBuffer;
        System.out.println("Общее время с StringBuffer: " + totalTimeStringBuffer + " миллисекунд");

        long startTimeCharArray = System.currentTimeMillis();
        appendWithCharArray();
        long endTimeCharArray = System.currentTimeMillis();
        long totalTimeCharArray = endTimeCharArray - startTimeCharArray;
        System.out.println("Общее время с char array: " + totalTimeCharArray + " миллисекунд");
    }

    private static void appendWithStringBuilder() {
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 100000; i++) {
            stringBuilder.append(generateRandomString(random));
        }
    }

    private static void appendWithStringBuffer() {
        StringBuffer stringBuffer = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < 100000; i++) {
            stringBuffer.append(generateRandomString(random));
        }
    }

    private static void appendWithCharArray() {
        char[] result = new char[100000 * 10]; 
        Random random = new Random();
        int index = 0;
        for (int i = 0; i < 100000; i++) {
            String randomString = generateRandomString(random);
            for (int j = 0; j < 10; j++) {
                result[index++] = randomString.charAt(j);
            }
        }
    }

    private static String generateRandomString(Random random) {
        char[] chars = new char[10];
        for (int i = 0; i < 10; i++) {
            chars[i] = (char) (random.nextInt(26) + 'a');
        }
        return new String(chars);
    }
}
