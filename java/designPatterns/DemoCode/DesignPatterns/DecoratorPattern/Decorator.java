package DesignPatterns.DecoratorPattern;

/**
 *
 * @author Mr.Joker
 * @date 2020/05/17
 * @time 16:48:06
 * @description 装饰模式：修饰的抽象类
 */
public class Decorator extends SchoolReport {

    private SchoolReport sr;

    public Decorator(SchoolReport sr) {
        this.sr = sr;
    }

    @Override
    public void report() {
        this.sr.report();
    }

    @Override
    public void sign(String name) {
        this.sr.sign(name);
    }
    
}