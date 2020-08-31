package DesignPatterns.SingletonPattern;

public class Singleton {

    // 线程不安全的单例
    // private static Singleton singleton = null;
    private static volatile Singleton singleton = null;

    // 构造函数私有化，限制产生多个对象
    private Singleton() {}

    // DCL + volatile
    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized(Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    // 延迟加载的线程安全的单例
    // public static Singleton getInstance() {
    //     // 这里采用的方法称为双重检查锁定(double-checked locking DCL)
    //     // 它的存在是为了防止可能试图同时获取单例实例的多个线程之间出现竞争状况，从而创建单独的实例
    //     // 这个result变量似乎毫无意义，但是，在Java中实现双重检查锁定时有一个非常重要的警告
    //     // 可以通过引入此局部变量来解决
    //     Singleton result = singleton;
    //     if (result != null) {
    //         return singleton;
    //     }
    //     synchronized(Singleton.class) {
    //         if (singleton == null) {
    //             singleton = new Singleton();
    //         }
    //         return singleton;
    //     }
    // }

    // 另一种DCL写法
    // public static Singleton getInstance() {
    //     if (singleton == null) {
    //         synchronized(Singleton.class) {
    //             if (singleton == null) {
    //                 singleton = new Singleton();
    //             }
    //         }
    //     }
    //     return singleton;
    // }

    // 通过该方法获取实例对象
    // 增加synchronized关键字的方式称为懒汉式
    // public static synchronized Singleton getSingleton() {
    //     if (singleton == null) {
    //         singleton = new Singleton();
    //     }

    //     return singleton;
    // }


    // 饿汉式单例
    // private static final Singleton singleton = new Singleton();

    // private Singleton() {}

    // public static Singleton getSingleton() {
    //     return singleton;
    // }

}