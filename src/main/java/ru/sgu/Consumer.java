package ru.sgu;

import java.util.concurrent.BlockingQueue;
import java.util.Random;

public class Consumer implements Runnable {
    private final BlockingQueue<FoodItem> queue;
    private final String name;
    private int totalCalories = 0;
    private final Random random = new Random();

    public Consumer(BlockingQueue<FoodItem> queue, String name) {
        this.queue = queue;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            FoodItem item;
            while (!(item = queue.take()).getName().equals("STOP")) {
                totalCalories += item.getCalories();
                System.out.printf("%s съел %s (%d ккал), всего употреблено: %d ккал\n", name, item.getName(), item.getCalories(), totalCalories);
                Thread.sleep(random.nextInt(500)); 
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
