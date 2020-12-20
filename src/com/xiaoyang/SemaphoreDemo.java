package com.xiaoyang;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    private static class Worker extends Thread {
        private Semaphore semaphore;

        public Worker(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println(this.getId() + ": work");
                sleep(5000);
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 10; i++) {
            new Worker(semaphore).start();
        }
    }
}
