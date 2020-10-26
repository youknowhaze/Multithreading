package com.incredible.service.TortoiseHare;

import org.springframework.util.StringUtils;

/**
 * 龟兔赛跑简单线程实现
 */
public class TortoiseHare implements Runnable{

    private static String winner = "";

    @Override
    public void run() {

        for (int i = 0; i < 101; i++) {
            if (getWinner(i)){
                break;
            }
            System.out.println(Thread.currentThread().getName()+" 跑了"+i+"步");
        }

    }

    private boolean getWinner(int steps){
        if (StringUtils.isEmpty(winner)){
            if (steps == 100){
                winner = Thread.currentThread().getName();
                System.out.println(winner+"===赢得了比赛");
                return true;
            }
        } else {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        TortoiseHare t1 = new TortoiseHare();

        new Thread(t1,"rabbit").start();
        new Thread(t1,"tortoise").start();

    }
}
