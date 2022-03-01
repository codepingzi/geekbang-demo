package com.geekbang.base.demo.mutilthread;

import java.util.concurrent.Callable;

public class Demo {

    public static void main(String[] args) {

    }

    private void test(){

        Thread a = new Thread();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    class RunnableDemo implements Runnable{

        @Override
        public void run() {

        }
    }

    class CallableDemo implements Callable{

        @Override
        public Object call() throws Exception {
            return null;
        }
    }

    class ThreadDemo extends Thread{

        @Override
        public void run() {

        }
    }
}
