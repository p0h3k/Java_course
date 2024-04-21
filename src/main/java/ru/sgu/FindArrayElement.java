package ru.sgu;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class FindArrayElement {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите числа через пробел: ");
        String input = scanner.nextLine();

        String[] numbersAsString = input.trim().split("\\s+");
        int[] array = new int[numbersAsString.length];
        try {
            for (int i = 0; i < numbersAsString.length; i++) {
                array[i] = Integer.parseInt(numbersAsString[i]);
            }
        } catch (NumberFormatException e) {
            System.err.println("Ошибка: введено не число.");
            return;
        }

        int secondMax = findSecondMax(array);
        int thirdMin = findThirdMin(array);

        System.out.println("Второе наибольшее число: " + secondMax);
        System.out.println("Третье наименьшее число: " + thirdMin);

        scanner.close();
    }

    public static int findSecondMax(int[] array) {
        return Arrays.stream(array)
                     .boxed()
                     .sorted(Comparator.reverseOrder())
                     .distinct()
                     .skip(1)
                     .findFirst()
                     .orElseThrow(() -> new IllegalArgumentException("Массив должен содержать как минимум два уникальных числа"));
    }

    public static int findThirdMin(int[] array) {
        return Arrays.stream(array)
                     .boxed()
                     .sorted()
                     .distinct()
                     .skip(2)
                     .findFirst()
                     .orElseThrow(() -> new IllegalArgumentException("Массив должен содержать как минимум три уникальных числа"));
    }
}
