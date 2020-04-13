package DesignPatterns.FactoryPattern;

public abstract class AbstractHumanFactory {
    public abstract <T extends Human> T createHuman(Class<T> c);
    // 升级为多个工厂类
    public abstract Human createHuman();
}