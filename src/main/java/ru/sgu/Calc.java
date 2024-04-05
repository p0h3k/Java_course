package ru.sgu;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class Calc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (scanner.hasNextLine()) {
            String[] input = scanner.nextLine().split(" ");
            
            if (input.length != 3) {
                System.out.println("Ошибка: введено больше трех параметров.");
                return;
            }
            
            String number1 = input[0];
            String number2 = input[1];
            String operation = input[2];
            
            try {
                BigDecimal bd1 = new BigDecimal(number1);
                BigDecimal bd2 = new BigDecimal(number2);
                
                switch (operation) {
                    case "ADD":
                        System.out.println(bd1.add(bd2).toPlainString());
                        break;
                    case "SUB":
                        System.out.println(bd1.subtract(bd2).toPlainString());
                        break;
                    case "MULT":
                        System.out.println(bd1.multiply(bd2).toPlainString());
                        break;
                    case "DIV":
                        if (bd2.compareTo(BigDecimal.ZERO) == 0) {
                            System.out.println("Ошибка: деление на ноль.");
                        } else {
                            System.out.println(bd1.divide(bd2, BigDecimal.ROUND_HALF_UP).toPlainString());
                        }
                        break;
                    case "REM":
			if (bd2.compareTo(BigDecimal.ZERO) == 0){
			    System.out.println("Ошибка: деление на ноль.");
			} else {
                            System.out.println(bd1.remainder(bd2).toPlainString());
			}
                        break;
                    case "POW":
                        int power = Integer.parseInt(number2);
			if (power < 0){
			    System.out.println("Ошибка: возведение в отрицательную степень. ");
			} else {
                            System.out.println(bd1.toBigInteger().pow(power).toString());
			}
                        break;
                    default:
                        System.out.println("Ошибка: недопустимая операция.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введенные символы не являются числами.");
            } catch (Exception e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
    }
}
