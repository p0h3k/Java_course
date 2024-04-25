package ru.sgu;

import java.util.Scanner;

public class DayOfWeekCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите имя дня недели и количество дней через пробел (например, 'sunday 10'): ");
        String input = scanner.nextLine().trim();

        String[] parts = input.split(" ");
        String dayName = parts[0].toUpperCase();
        int days = Integer.parseInt(parts[1]);

        try {
            DayOfWeek dayOfWeek = DayOfWeek.valueOf(dayName);

            DayOfWeek nextDay = dayOfWeek.nextDay(days);

            System.out.println("Через " + days + " дней будет " + nextDay.toString().toLowerCase());
        } catch (IllegalArgumentException e) {
            System.err.println("Неправильный формат ввода.");
        }
    }
}
