package com.geekbang.demo.course_17;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author yangweiping
 * @date 2022/2/8 上午10:20
 */
public class ReadWriteLockDemo {

    public static void main(String[] args) {
//        new ReadWriteLockDemo().case1();
//        new ReadWriteLockDemo().case2();
//        new ReadWriteLockDemo().case3();
        new ReadWriteLockDemo().case4();

    }

    /**
     * 两个线程 线程1 读, 线程2 写
     * 写线程一直执行, 读线程被阻塞
     */
    public void case1(){
        Cache<String, String> cache = new Cache();

        // write
        new Thread(() -> {
            Thread.currentThread().setName("Write Thread");
            cache.put("A", "AAA");
        }).start();

        // read
        new Thread(() -> {
            Thread.currentThread().setName("Read Thread");
            String value = cache.get("A");
            System.out.println("this value is: " + value);
        }).start();
    }

    /**
     * 两个线程 1.读线程 2.写线程
     * 读锁被持有, 写锁被阻塞
     */
    public void case2(){
        Cache<String, String> cache = new Cache();

        // read
        new Thread(() -> {
            Thread.currentThread().setName("Read Thread");
            String value = cache.get("A");
            System.out.println("this value is: " + value);
        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // write
        new Thread(() -> {
            Thread.currentThread().setName("Write Thread");
            cache.put("A", "AAA");
        }).start();
    }

    /**
     * 两个线程 1.读线程1 2.读线程2
     * 读锁被持有, 其他读锁可以进入
     */
    public void case3(){
        Cache<String, String> cache = new Cache();

        cache.put("B", "BBB");

        // read
        new Thread(() -> {
            Thread.currentThread().setName("Read Thread-1");
            String value = cache.get("B");
            System.out.println(Thread.currentThread().getName()+ " this value is: " + value);
        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // write
        new Thread(() -> {
            Thread.currentThread().setName("Read Thread-2");
            String value = cache.get("B");
            System.out.println(Thread.currentThread().getName()+ " this value is: " + value);
        }).start();
    }

    /**
     * 不支持锁的升级
     * 当线程持有读锁时,且未释放,此时尝试获取写锁,会造成程序一直等待
     */
    public void case4(){
        Cache<String, String> cache = new Cache();
        new Thread(() -> {
            Thread.currentThread().setName("case4");
            cache.lock();
        }).start();
    }
}



class Cache<K, V> {
    final Map<K, V> m = new HashMap<>();
    final ReadWriteLock rwl = new ReentrantReadWriteLock();

    // read lock
    final Lock r = rwl.readLock();

    // write lock
    final Lock w = rwl.writeLock();


    void lock(){


        r.lock();

        try {
            w.lock();
            try {

            }finally {
                w.unlock();
            }
        } finally {
            r.unlock();
        }

    }

    V get(K key){
        System.out.println("pre read lock");
        r.lock();
        System.out.println("after read lock");
        try {
            // do something
            String name = Thread.currentThread().getName();
            if (name.equals("Read Thread-1")){
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return m.get(key);
        } finally {
            r.unlock();
        }
    }

    V put(K key, V value){
        System.out.println("pre write lock");
        w.lock();
        System.out.println("after write lock");
        try {
            return m.put(key, value);
        } finally {
            w.unlock();
        }
    }


}
