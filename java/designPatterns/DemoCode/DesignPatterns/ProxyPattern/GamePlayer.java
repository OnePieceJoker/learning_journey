package DesignPatterns.ProxyPattern;

/**
 *
 * @author Mr.Joker
 * @date 2020/04/20
 * @time 22:22:40
 * @description 代理模式：游戏玩家
 */
public class GamePlayer implements IGamePlayer {

    private String name = "";
    // 强制代理
    private IGamePlayer proxy = null;

    /**
     * 普通代理模式
     * @param _gamePlayer
     * @param _name
     * @throws Exception
     */
    public GamePlayer(IGamePlayer _gamePlayer, String _name) throws Exception {
        if (_gamePlayer == null) {
            throw new Exception("不能创建真实用户");
        } else {
            this.name = _name;
        }
    }

    /**
     * 强制代理模式
     * @param _name
     */
    public GamePlayer(String _name) {
        this.name = _name;
    }

    @Override
    public void login(String username, String password) {
        // 强制代理模式，必须先指定一个代理
        // if (this.isProxy()) {
        //     System.out.println("登录名为" + username + "的用户" + this.name + "登录成功");
        // } else {
        //     System.out.println("请使用指定的代理访问");
        // }
       System.out.println("登录名为" + username + "的用户" + this.name + "登录成功");
    }

    @Override
    public void killBoss() {
        // if (this.isProxy()) {
        //     System.out.println(this.name + "正在打怪");
        // } else {
        //     System.out.println("请使用指定的代理访问");
        // }
        System.out.println(this.name + "正在打怪");
    }

    @Override
    public void upgrade() {
        // if (this.isProxy()) {
        //     System.out.println(this.name + "升了一级");
        // } else {
        //     System.out.println("请使用指定的代理访问");
        // }
        System.out.println(this.name + "升了一级");
    }

    @Override
    public IGamePlayer getProxy() {
        this.proxy = new GamePlayerProxy(this);
        return this.proxy;
    }

    // 检验是否时代理访问
    private boolean isProxy() {
        if (this.proxy == null) {
            return false;
        }
        return true;
    }

}