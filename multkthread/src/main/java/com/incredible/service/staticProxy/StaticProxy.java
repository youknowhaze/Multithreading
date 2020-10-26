package com.incredible.service.staticProxy;

/**
 * 多线程的静态代理示例，用结婚作为案例
 * 案例中，you这个对象要结婚，但是又不想自己去布置婚礼现场等等操作，于是委托婚庆公司，
 * 婚庆公司就是静态代理，you是真实对象，而marry接口是被代理的事情
 * 静态代理总结：
 * 1、真实对象和静态代理需要实现同一个接口
 * 2、静态代理需要代理真实对象
 *
 * 好处：代理可以做很多真实对象做不到的事（婚礼布置等），真实对象只需要专注做自己的事
 *
 */
public class StaticProxy {
    public static void main(String[] args) {
        You you = new You(); //结婚者
        WeddingCompany weddingCompany = new WeddingCompany(you);  // 婚庆公司代理你的婚礼
        weddingCompany.toMarry();  //婚庆公司帮你举行婚礼
    }
}

//定义结婚接口
interface Marry{
    // 结婚方法
    void toMarry();
}

//人继承结婚接口
class You implements Marry{

    @Override
    public void toMarry() {
        System.out.println("====结婚===");
    }
}

//婚庆公司 需要实现结婚接口
class WeddingCompany implements Marry{
    // 被代理的真实对象
    private Marry marry;
    // 代理真实对象
    public WeddingCompany(Marry marry) {
        this.marry = marry;
    }

    @Override
    public void toMarry() {
        before();
        marry.toMarry(); //真实对象进行的操作
        after();
    }

    private void after() {
        System.out.println("-------结婚后，收拾现场-------");
    }

    private void before() {
        System.out.println("====结婚前，布置现场===");
    }
}

