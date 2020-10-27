package com.incredible.service;

public class ThisTest{

    public static void main(String[] args) throws InterruptedException {
        God god = new God();
        Person person = new Person();
        Thread t = new Thread(god);
        t.setDaemon(true); //默认为false，默认用户线程，true为守护线程
        t.start();

        new Thread(person).start();
    }
}


class God implements Runnable{

    @Override
    public void run() {
        while (true){
            System.out.println("===========");
        }
    }
}


class Person implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println("-------------------");
        }
        System.out.println("ending.............");
    }
}
