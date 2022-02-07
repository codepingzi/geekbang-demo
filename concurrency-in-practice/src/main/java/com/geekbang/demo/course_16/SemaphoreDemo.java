package com.geekbang.demo.course_16;

import java.util.concurrent.Semaphore;

/**
 * @author yangweiping
 * @date 2022/2/7 下午5:17
 */
public class SemaphoreDemo {

    static int count;

    static final Semaphore s = new Semaphore(0);

    static void addOne() {
        try {
            s.acquire();
            count += 1;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 只允许一个线程, 其他线程被阻塞
//            s.release();
        }
    }


    public static void main(String[] args) {

        MutliThread mutliThread = new MutliThread();

        Thread t1=new Thread(mutliThread,"Window 1");
        Thread t2=new Thread(mutliThread,"Window 2");
        t1.start();
        t2.start();


    }


}

class MutliThread implements Runnable {

    @Override
    public void run() {
        SemaphoreDemo.addOne();

        System.out.println("----" + Thread.currentThread().getName());

//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
