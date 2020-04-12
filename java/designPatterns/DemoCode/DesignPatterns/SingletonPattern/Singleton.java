package DesignPatterns.SingletonPattern;

public class Singleton {

    // 线程不安全的单例
    private static Singleton singleton = null;

    // 构造函数私有化，限制产生多个对象
    private Singleton() {}

    // 通过该方法获取实例对象
    // 增加synchronized关键字的方式称为懒汉式
    public static synchronized Singleton getSingleton() {
        if (singleton == null) {
            singleton = new Singleton();
        }

        return singleton;
    }


    // 饿汉式单例
    // private static final Singleton singleton = new Singleton();

    // private Singleton() {}

    // public static Singleton getSingleton() {
    //     return singleton;
    // }

}