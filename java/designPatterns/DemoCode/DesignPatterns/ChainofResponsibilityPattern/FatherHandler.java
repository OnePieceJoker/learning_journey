package DesignPatterns.ChainofResponsibilityPattern;

/**
 *
 * @author Mr.Joker
 * @date 2020/05/10
 * @time 18:09:30
 * @description 责任链模式具体处理类：设置自己的处理级别，编写个性化的请求处理代码
 */
public class FatherHandler extends Handler {

    public FatherHandler() {
        super(Handler.FATCHER_LEVEL_REQUEST);
    }

    @Override
    protected void response(IWomen women) {
        System.out.println("女儿向父亲请示");
        System.out.println(women.getRequest());
        System.out.println("父亲的答复是：同意");
    }
    
}