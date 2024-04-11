package ru.sgu;

import java.io.File;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class StockEntryProcessor {
    public static void main(String[] args) {
        Set<StockEntry> entries = new TreeSet<>(); 
        try (Scanner scanner = new Scanner(new File("data/input.txt"))) { 
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(" ", 4); 
                String ownerFullName = data[0] + " " + data[1] + " " + data[2];
                String companyName = data[3].substring(0, data[3].lastIndexOf(" "));
                int rating = Integer.parseInt(data[3].substring(data[3].lastIndexOf(" ") + 1));
                entries.add(new StockEntry(ownerFullName, companyName, rating));
            }
        } catch (Exception e) {
            System.err.println("Ошибка чтения из файла " + e.getMessage());
        }

        for (StockEntry entry : entries) {
            System.out.println(entry);
        }
    }
}
