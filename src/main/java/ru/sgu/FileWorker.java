package ru.sgu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;

public class FileWorker {
    public static void main(String[] args) {
        String inputFileName = "input.txt";
        String outputFileName = "output.txt";
        String regex = "^[A-Za-zА-Яа-я].*";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
             PrintWriter writer = new PrintWriter(outputFileName)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.trim().split("\\s+");
                if (parts.length >= 3 && parts[0].matches(regex) && parts[1].matches(regex) && parts[2].matches(regex)) {
                    writer.println(parts[1] + " " + parts[0].charAt(0) + "." + parts[2].charAt(0) + ".");
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка при работе с файлами: " + e.getMessage());
        }
    }
}
