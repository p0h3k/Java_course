package ru.sgu;

public class Main {
    public static void main(String[] args) {
        Printer printer1 = Printer.getInstance("Принтер 1");
        Printer printer2 = Printer.getInstance("Принтер 2");

        printer1.print("Документ 1");
        printer2.print("Документ 2");


        Printer printer3 = Printer.getInstance("Принтер 1");
    }
}
