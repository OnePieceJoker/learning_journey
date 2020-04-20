package DesignPatterns.ProxyPattern;

/**
 *
 * @author Mr.Joker
 * @date 2020/04/20
 * @time 22:21:05
 * @description 代理模式：游戏玩家抽象接口
 */
public interface IGamePlayer {

    public void login(String username, String password);

    public void killBoss();

    public void upgrade();

    public IGamePlayer getProxy();

}