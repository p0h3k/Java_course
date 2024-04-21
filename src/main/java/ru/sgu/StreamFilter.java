package ru.sgu;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamFilter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите числа через пробел:");
        String input = scanner.nextLine();
        
        List<Integer> numbers = parseInput(input);

        if (numbers != null) {
            System.out.println("Фильтрация чисел кратных 3:");
            filterStream(numbers.stream(), n -> n % 3 == 0)
                    .forEach(System.out::println);
        }

        scanner.close();
    }

    public static List<Integer> parseInput(String input) {
        try {
            return Stream.of(input.split("\\s+"))
                         .map(Integer::parseInt)
                         .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            System.err.println("Ошибка: введено не число.");
            return null;
        }
    }

    public static Stream<Integer> filterStream(Stream<Integer> stream, Predicate<Integer> predicate) {
        return stream.filter(predicate);
    }
}
