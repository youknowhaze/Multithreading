package com.incredible.service.callable;

import java.util.concurrent.*;

/**
 * 继承callable<T>接口实现多线程，需要实现call()方法，call()方法的返回值为接口实现的泛型
 * 大体分为四个步骤
 * 1、创建线程池
 * 2、提交执行线程实例
 * 3、获取回调结果
 * 4、关闭线程池服务
 */
public class TestCallable implements Callable<Boolean> {

    @Override
    public Boolean call() throws Exception {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+"============"+i);
        }
        return true;
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable t1 = new TestCallable();
        TestCallable t2 = new TestCallable();
        TestCallable t3 = new TestCallable();
        //创建执行服务（线程池）
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        //提交执行
        Future<Boolean> future1 = executorService.submit(t1);
        Future<Boolean> future2 = executorService.submit(t2);
        Future<Boolean> future3 = executorService.submit(t3);

        //获取结果
        Boolean bool1 = future1.get();
        Boolean bool2 = future2.get();
        Boolean bool3 = future3.get();

        System.out.println(bool1+" === "+bool2+" --- "+bool3);
        // 关闭服务
        executorService.shutdown();
    }
}
