package com.incredible.service.synchronize;

public class UnsafeBank {
    public static void main(String[] args) {
        Account account = new Account(100,"住房基金");
        Drawing you = new Drawing(account,50);
        Drawing me = new Drawing(account,70);
        new Thread(you,"你").start();
        new Thread(me,"我").start();
    }
}


class Account{
    int money;
    String name;

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}


class Drawing implements Runnable{

    Account account;
    // 取了多少钱
    int drawingMoney;


    public Drawing(Account account, int drawingMoney) {
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    @Override
    public void run() {

        synchronized (account){
            if (account.money - drawingMoney <0){
                System.out.println(Thread.currentThread().getName()+"========账户余额不够========");
                return;
            }
            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            account.money -= drawingMoney;
            System.out.println("卡内余额为："+account.money);
            System.out.println(Thread.currentThread().getName()+ " 取走了："+drawingMoney);
        }

    }
}