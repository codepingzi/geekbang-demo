package com.geekbang.base.demo.mutilthread;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class ExecutorDemo {


    public static void main(String[] args) {

        ThreadFactory threadFactory = Executors.defaultThreadFactory();

        Executors.newFixedThreadPool(1);
        Executors.newFixedThreadPool(1, threadFactory);

        Executors.newWorkStealingPool();
        Executors.newWorkStealingPool(2);

        Executors.newSingleThreadExecutor();
        Executors.newSingleThreadExecutor(threadFactory);


        Executors.newCachedThreadPool();
        Executors.newCachedThreadPool(threadFactory);



        Executors.newScheduledThreadPool(1);
        Executors.newScheduledThreadPool(1, threadFactory);


        Executors.newSingleThreadScheduledExecutor();
        Executors.newSingleThreadScheduledExecutor(threadFactory);




    }
}
