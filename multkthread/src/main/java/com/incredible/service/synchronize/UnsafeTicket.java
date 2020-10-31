package com.incredible.service.synchronize;

/**
 * 买票实例
 * 锁方法 应该锁住会存在安全问题的方法上，即方法中有值被改变时可能存在线程安全问题
 */
public class UnsafeTicket {
    public static void main(String[] args) {
        BuyTicket buyTicket = new BuyTicket();
        new Thread(buyTicket,"学生党").start();
        new Thread(buyTicket,"黄牛党").start();
        new Thread(buyTicket,"上班族").start();
    }
}


class BuyTicket implements Runnable{

    private int ticketNumbers = 10;
    boolean flag = true;

    @Override
    public void run() {
        while (flag){
            buy();
        }
    }

    private synchronized void buy(){
        if (ticketNumbers<=0){
            flag = false;
            return;
        }

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" 拿到"+ticketNumbers--);
    }

}

