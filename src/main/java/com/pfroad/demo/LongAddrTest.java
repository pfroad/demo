package com.pfroad.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;

public class LongAddrTest {
    public static LongAdder count = new LongAdder();
    public static void main(String[] args) throws InterruptedException {
        final ExecutorService es = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 1000; i++) {
            es.submit(new LongAdderTask());
        }

        es.shutdown();
        if (es.awaitTermination(60, TimeUnit.SECONDS)) {
            System.out.println(Thread.currentThread().getName() + ":" + count.longValue());
        }

        count.reset();
        System.out.println(Thread.currentThread().getName() + ":" + count.longValue());
    }

    public static class LongAdderTask implements Runnable {
        @Override
        public void run() {
            count.increment();
            if (count.longValue() % 10 == 0) {
                count.reset();
            }
        }
    }
}
