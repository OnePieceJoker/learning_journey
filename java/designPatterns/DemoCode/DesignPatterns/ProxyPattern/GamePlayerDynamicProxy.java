package DesignPatterns.ProxyPattern;

import java.lang.reflect.InvocationHandler;

public class GamePlayerDynamicProxy extends DynamicProxy {

    public static <T> T newProxyInstance(IGamePlayer gamePlayer) {
        // 获得ClassLoader
        ClassLoader loader = gamePlayer.getClass().getClassLoader();
        // 获得接口数组
        Class<?>[] interfaces = gamePlayer.getClass().getInterfaces();
        // 获得handler
        InvocationHandler handler = new GamePlayIH(gamePlayer);
        return newProxyInstance(loader, interfaces, handler);
    }

}