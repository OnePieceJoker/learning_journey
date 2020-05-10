package DesignPatterns.ChainofResponsibilityPattern;

/**
 *
 * @author Mr.Joker
 * @date 2020/05/10
 * @time 18:08:34
 * @description 责任链模式：抽象处理类，结合模板方法模式，由父类统一处理请求的传递，子类专注实现自己的请求处理即可
 */
public abstract class Handler {

    public final static int FATCHER_LEVEL_REQUEST = 1;
    public final static int HUSBAND_LEVEL_REQUEST = 2;
    public final static int SON_LEVEL_REQUEST = 3;

    private int level = 0;
    private Handler nextHandler;

    public Handler(int _level) {
        this.level = _level;
    }

    public final void HandleMessage(IWomen women) {
        if (women.getType() == this.level) {
            this.response(women);
        } else {
            if (this.nextHandler != null) {
                this.nextHandler.HandleMessage(women);
            } else {
                System.out.println("--没地方请示了");
            }
        }
    }

    public void setNext(Handler handler) {
        this.nextHandler = handler;
    }

    protected abstract void response(IWomen women);

}