package com.incredible.service.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 显式锁，是Lock的一个子类
 */
public class ReentrantLockTest {

    public static void main(String[] args) {
        TicketNum t = new TicketNum();
        new Thread(t,"黄牛党").start();
        new Thread(t,"学生党").start();
        new Thread(t,"上班族").start();
    }

}

class TicketNum implements Runnable{

    private final ReentrantLock reentrantLock = new ReentrantLock();

    int num = 10;
    boolean flag = true;

    @Override
    public void run() {
        while (flag){
            try {
                buyTicket();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 显示锁，需在需要加锁的代码块前后声明加锁和释放锁
     * @throws InterruptedException
     */
    private void buyTicket() throws InterruptedException {
        try {
            // 加锁
            reentrantLock.lock();
            if (num <= 0){
                System.out.println("========没票了=======");
                flag = false;
                return;
            }
            Thread.sleep(400);

            System.out.println(Thread.currentThread().getName()+" ------- "+num--);
        }finally {
            // 释放锁
            reentrantLock.unlock();
        }

    }
}
