package DesignPatterns.ProxyPattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 *
 * @author Mr.Joker
 * @date 2020/04/20
 * @time 23:05:17
 * @description 代理模式：动态代理
 */
public class GamePlayIH implements InvocationHandler {

    // 被代理者
    Class cls = null;
    // 被代理的实例
    Object obj = null;
    // 我要代理谁
    public GamePlayIH(Object _obj) {
        this.obj = _obj;
    }

    /**
     * 调用被代理的方法
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(obj, args);
        if (method.getName().equalsIgnoreCase("login")) {
            System.out.println("有人登录了我的账号");
        }
        return result;
    }

}