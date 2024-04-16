package ru.sgu;

import java.util.concurrent.BlockingQueue;
import java.util.Random;

public class Producer implements Runnable {
    private final BlockingQueue<FoodItem> queue;
    private final String[] menu = {"Салат", "Суп", "Котлета", "Хлеб", "Пицца", "Яблоко"};
    private final int[] calories = {100, 250, 300, 50, 500, 80};
    private final Random random = new Random();

    public Producer(BlockingQueue<FoodItem> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 30; i++) {
                int index = random.nextInt(menu.length);
                FoodItem item = new FoodItem(menu[index], calories[index]);
                queue.put(item);
                System.out.printf("Продюсер положил: %s (%d ккал)\n", item.getName(), item.getCalories());
                Thread.sleep(random.nextInt(200));
            }
            for (int i = 0; i < 5; i++) { 
                queue.put(new FoodItem("STOP", 0));
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
