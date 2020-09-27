package com.pfroad.demo;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BubbleSortTest {
    public final static ExecutorService exec = Executors.newFixedThreadPool(3);
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            exec.submit(new Task(new int[]{i * 5, i * -5, i * 3, i * 1, i * 4, i * -2, i * 10, i * 9}));
        }

        exec.shutdown();
        while (!exec.awaitTermination(1000, TimeUnit.MILLISECONDS)) {
            System.out.println("Executor has not been terminated.");
        }
        System.out.println("It takes " + (System.currentTimeMillis() - start) + " ms");
//        printArray(arr);
//        for (String arg : args) {
//            System.out.println(arg);
//        }
    }



    private static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.println(i);
        }
    }

    static class Task implements Runnable {
        private int[] arr;

        public Task(int[] arr) {
            this.arr = arr;
        }

        @Override
        public void run() {
            bubbleSort(arr);
//            StringBuilder arrStr = new StringBuilder();
//            Arrays.stream(arr).forEach(it -> {
//                arrStr.append(it);
//                arrStr.append(" ");
//            });
//            System.out.printf("sorted arr: %s\n", arrStr.toString());
        }

        private void bubbleSort(int[] arr) {
            boolean swapped = true;
            int j = 0;
            int tmp;
            while (swapped) {
                swapped = false;
                j++;
                for (int i = 0; i < arr.length - j; i++) {
                    if (arr[i] > arr[i + 1]) {
                        tmp = arr[i];
                        arr[i] = arr[i + 1];
                        arr[i + 1] = tmp;
                        swapped = true;
                    }
                }
            }
        }
    }
}
