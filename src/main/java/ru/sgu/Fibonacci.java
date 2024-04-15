package ru.sgu;

import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Fibonacci extends RecursiveTask<Long> {
    private final int n;

    public Fibonacci(int n) {
        this.n = n;
    }

    @Override
    protected Long compute() {
        if (n <= 1) {
            return (long) n;
        } else {
            Fibonacci f1 = new Fibonacci(n - 1);
            f1.fork(); 
            Fibonacci f2 = new Fibonacci(n - 2);
            return f2.compute() + f1.join();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Введите N для вычисления N-го числа Фибоначчи: ");
            int N = scanner.nextInt();
            
            if (N < 0) {
                System.err.println("Ошибка: Число N должно быть неотрицательным.");
                return;
            }

            ForkJoinPool pool = new ForkJoinPool();
            Fibonacci task = new Fibonacci(N);
            long result = pool.invoke(task);
            System.out.println("N-е число Фибоначчи: " + result);
        } catch (Exception e) {
            System.err.println("Произошла ошибка при вводе или выполнении: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
