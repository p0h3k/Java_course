package ru.sgu;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class FoodProductionSimulation {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<FoodItem> queue = new ArrayBlockingQueue<>(10);
        ExecutorService executor = Executors.newFixedThreadPool(6);

        executor.execute(new Producer(queue));
        for (int i = 1; i <= 5; i++) {
            executor.execute(new Consumer(queue, "Потребитель " + i));
        }
        
        executor.shutdown();
        if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
            System.err.println("Потоки не завершились вовремя!");
        }
        System.out.println("Все потоки завершили работу.");
    }
}
