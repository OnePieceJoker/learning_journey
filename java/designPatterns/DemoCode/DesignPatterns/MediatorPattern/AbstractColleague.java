package DesignPatterns.MediatorPattern;

/**
 *
 * @author Mr.Joker
 * @date 2020/04/25
 * @time 11:22:48
 * @description 中介者模式：抽象同事类
 */
public abstract class AbstractColleague {

    protected AbstractMediator mediator;

    public AbstractColleague(AbstractMediator _mediator) {
        this.mediator = _mediator;
    }
}