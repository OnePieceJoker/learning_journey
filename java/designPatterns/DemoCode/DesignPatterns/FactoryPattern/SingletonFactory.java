package DesignPatterns.FactoryPattern;

import java.lang.reflect.Constructor;

/**
 *
 * @author Mr.Joker
 * @date 2020/04/13
 * @time 23:32:48
 * @description 工厂模式替代单例模式，使用反射机制
 */
public class SingletonFactory {

    private static Singleton singleton;
    
    static {
        try {
            Class cl = Class.forName(Singleton.class.getName());
            // 获得无参构造
            Constructor constructor = cl.getDeclaredConstructor();
            // 设置无参构造是可以访问的
            constructor.setAccessible(true);
            // 产生一个实例对象
            singleton = (Singleton) constructor.newInstance();
        } catch (Exception e) {
            // 异常处理
        }
    }

    public static Singleton getSingleton() {
        return singleton;
    }
}