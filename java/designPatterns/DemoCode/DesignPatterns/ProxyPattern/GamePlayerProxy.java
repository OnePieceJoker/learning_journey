package DesignPatterns.ProxyPattern;

/**
 *
 * @author Mr.Joker
 * @date 2020/04/20
 * @time 22:25:52
 * @description 代理模式：代理类
 */
public class GamePlayerProxy implements IGamePlayer, IProxy {

    private IGamePlayer gamePlayer = null;

    /**
     * 强制代理模式
     * @param _gamePlayer
     */
    public GamePlayerProxy(IGamePlayer _gamePlayer) {
        this.gamePlayer = _gamePlayer;
    }

    public GamePlayerProxy(String _name) {
        // 普通代理模式
        try {
            gamePlayer = new GamePlayer(this, _name);
        } catch (Exception e) {}
    }

    @Override
    public void login(String username, String password) {
        this.gamePlayer.login(username, password);
    }

    @Override
    public void killBoss() {
        this.gamePlayer.killBoss();
    }

    @Override
    public void upgrade() {
        this.gamePlayer.upgrade();
        this.count();
    }

    @Override
    public IGamePlayer getProxy() {
        return this;
    }

    /**
     * 实现IProxy接口，实现扩展
     */
    @Override
    public void count() {
        System.out.println("总费用为150元");
    }

}