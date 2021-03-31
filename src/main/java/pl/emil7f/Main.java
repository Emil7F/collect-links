package pl.emil7f;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(() -> printNumbers());
        executorService.submit(() -> printNumbers());
        executorService.shutdown();

    }

    private static void printNumbers() {
        for (int i = 0; i < 999; i++) {
            System.out.println((Thread.currentThread().getName() + " " + i));
        }
    }
}
