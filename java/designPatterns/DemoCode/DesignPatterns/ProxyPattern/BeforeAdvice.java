package DesignPatterns.ProxyPattern;

/**
 *
 * @author Mr.Joker
 * @date 2020/04/20
 * @time 23:35:52
 * @description 动态代理模式：前置方法
 */
public class BeforeAdvice implements IAdvice {

    @Override
    public void exec() {
        System.out.println("前置方法：记录登录时间戳：2020-04-20 23:36:30");
    }

}