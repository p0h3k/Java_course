package ru.sgu;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class DateCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LocalDate startDate = null;
        LocalDate endDate = null;
        while (startDate == null) {
            System.out.println("Введите первую дату в формате \"год месяц день\":");
            startDate = parseDate(scanner.nextLine());
            if (startDate == null) {
                System.out.println("Ошибка: Неправильный формат даты. Пожалуйста, попробуйте снова.");
            }
        }
        
        while (endDate == null) {
            System.out.println("Введите вторую дату в формате \"год месяц день\":");
            endDate = parseDate(scanner.nextLine());
            if (endDate == null) {
                System.out.println("Ошибка: Неправильный формат даты. Пожалуйста, попробуйте снова.");
            }
        }

        long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);

        System.out.println("Число дней между минимальной и максимальной датой: " + daysBetween);
    }

    // Метод для парсинга даты из строки
    private static LocalDate parseDate(String dateStr) {
        try {
            String[] parts = dateStr.split("\\s+");
            int year = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);
            int day = Integer.parseInt(parts[2]);
            return LocalDate.of(year, month, day);
        } catch (DateTimeException | ArrayIndexOutOfBoundsException | NumberFormatException | NullPointerException e) {
            System.err.println("Дата введена с ошибкой ");
            return null;
        }
    }
}
