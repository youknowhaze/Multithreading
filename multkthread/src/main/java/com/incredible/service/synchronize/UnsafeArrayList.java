package com.incredible.service.synchronize;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 锁的对象应该是 被变更时会存在安全问题的对象所指向的this对象，
 * 如这里被改的是list这个集合，他this所指向的是list本身，所以锁的对象应该是list
 */
public class UnsafeArrayList {
    public static void main(String[] args) {
        /*List<Integer> list = new ArrayList();

        for (int i = 0; i < 10000; i++) {
            new Thread(()->{
                synchronized (list){
                    list.add(1);
                }
            }).start();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("========   "+list.size());*/
        safeList();
    }


    private static void safeList(){
        CopyOnWriteArrayList list = new CopyOnWriteArrayList();
        for (int i = 0; i < 10000; i++) {
            new Thread(()->list.add(1)).start();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("==== "+list.size());
    }
}
