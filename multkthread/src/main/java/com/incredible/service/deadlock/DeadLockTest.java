package com.incredible.service.deadlock;

public class DeadLockTest{

    public static void main(String[] args) {
        Demo d1 = new Demo(0);
        Demo d2 = new Demo(1);
        new Thread(d1,"玲珑").start();
        new Thread(d2,"红豆").start();
    }

}

class Demo implements Runnable{
    // 公共资源
    static String fish = "fish";
    static String bearPaw = "bearPaw";
    // 选择
    int choose;

    public Demo(int choose) {
        this.choose = choose;
    }

    @Override
    public void run() {
        try {
            //chooseForDeadLock();
            chooseForUnDeadLock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 死锁，两个线程互相持有另一个线程想要的资源且不释放
     * @throws InterruptedException
     */
    private void chooseForDeadLock() throws InterruptedException {
        if (choose == 0) {
            synchronized (fish) {
                System.out.println(Thread.currentThread().getName() + "=======获得鱼=======");
                Thread.sleep(1000);
                synchronized (bearPaw) {
                    System.out.println(Thread.currentThread().getName() + "=======获得熊掌=======");
                }
            }
        }else {
             synchronized (bearPaw) {
                System.out.println(Thread.currentThread().getName() + "-------获得熊掌-------");
                Thread.sleep(2000);
                synchronized (fish) {
                    System.out.println(Thread.currentThread().getName() + "--------获得鱼---------");
                }
            }
        }
    }

    /**
     * 拿不到另一个线程资源的时候，释放自己所持资源，等待其他线程释放所需资源
     * @throws InterruptedException
     */
    private void chooseForUnDeadLock() throws InterruptedException {
        if (choose == 0) {
            synchronized (fish) {
                System.out.println(Thread.currentThread().getName() + "=======获得鱼=======");
                Thread.sleep(1000);
            }
            synchronized (bearPaw) {
                System.out.println(Thread.currentThread().getName() + "=======获得熊掌=======");
            }
        }else {
            synchronized (bearPaw) {
                System.out.println(Thread.currentThread().getName() + "-------获得熊掌-------");
                Thread.sleep(2000);
            }
            synchronized (fish) {
                System.out.println(Thread.currentThread().getName() + "--------获得鱼---------");
            }
        }
    }
}
