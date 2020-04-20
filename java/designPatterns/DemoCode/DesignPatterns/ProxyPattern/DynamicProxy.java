package DesignPatterns.ProxyPattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class DynamicProxy<T> {

    public static <T> T newProxyInstance(ClassLoader loader, Class<?>[] interfaces, 
                           InvocationHandler handler) {
        if (true) {
            (new BeforeAdvice()).exec();
        }
        // 执行目标
        return (T)Proxy.newProxyInstance(loader, interfaces, handler);
    }
}