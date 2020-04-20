package DesignPatterns.ProxyPattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 *
 * @author Mr.Joker
 * @date 2020/04/20
 * @time 22:27:22
 * @description 代理模式：游戏代理场景类
 */
public class Client {

    public static void main(String[] args) {
        // // 定义一个玩家
        // IGamePlayer gamePlayer = new GamePlayer("李四");
        // // 定义一个代理
        // IGamePlayer proxy = new GamePlayerProxy(gamePlayer);
        // // 开始打游戏
        // // 记录时间戳
        // System.out.println("开始时间为：2020-04-20 22:29:30");
        // proxy.login("Joker", "password");
        // proxy.killBoss();
        // proxy.upgrade();
        // System.out.println("结束时间为：2020-04-20 22:40:20");

        //==================普通代理模式=================
        // 要求客户端只能访问到代理类，无法访问到真实用户。
        // 定义一个代理
        // IGamePlayer proxy = new GamePlayerProxy("李四");
        // System.out.println("开始时间为：2020-04-20 22:29:30");
        // proxy.login("Joker", "password");
        // proxy.killBoss();
        // proxy.upgrade();
        // System.out.println("结束时间为：2020-04-20 22:40:20");

        //==================强制代理模式=================
        // 通过真实角色管理代理角色
        // 定义一个玩家
        // IGamePlayer gamePlayer = new GamePlayer("李四");
        // IGamePlayer proxy = gamePlayer.getProxy();
        // System.out.println("开始时间为：2020-04-20 22:29:30");
        // proxy.login("Joker", "password");
        // proxy.killBoss();
        // proxy.upgrade();
        // System.out.println("结束时间为：2020-04-20 22:40:20");

        //==================动态代理模式=================
        // 定义一个玩家
        // IGamePlayer gamePlayer = new GamePlayer("李四");
        // // 定义一个Handler
        // InvocationHandler handler = new GamePlayIH(gamePlayer);
        // System.out.println("开始时间为：2020-04-20 22:29:30");
        // // 获得类的class loader
        // ClassLoader classLoader = gamePlayer.getClass().getClassLoader();
        // // 动态产生一个代理者
        // IGamePlayer proxy = (IGamePlayer) Proxy.newProxyInstance(classLoader, new Class[]{IGamePlayer.class}, handler);
        // // 登录
        // proxy.login("Joker", "password");
        // proxy.killBoss();
        // proxy.upgrade();
        // System.out.println("开始时间为：2020-04-20 22:40:30");


        //==================动态代理AOP模式=================
        // 定义一个玩家
        IGamePlayer gamePlayer = new GamePlayer("李四");
        // 定义代理
        IGamePlayer proxy = GamePlayerDynamicProxy.newProxyInstance(gamePlayer);
        // 执行方法
        proxy.login("Joker", "password");
        proxy.killBoss();
        proxy.upgrade();
    }
}