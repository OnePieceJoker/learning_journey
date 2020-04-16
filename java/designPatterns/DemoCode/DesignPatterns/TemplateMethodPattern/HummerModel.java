package DesignPatterns.TemplateMethodPattern;

/**
 *
 * @author Mr.Joker
 * @date 2020/04/16
 * @time 23:28:37
 * @description 模板方法模式：悍马模型抽象类
 */
public abstract class HummerModel {

    protected abstract void start();

    protected abstract void stop();

    protected abstract void alarm();

    protected abstract void engineBoom();

    final public void run() {
        this.start();

        this.engineBoom();

        if (this.isAlarm()) {
            this.alarm();
        }

        this.stop();
    }

    // 定义钩子方法（Hook Method）：Hook Method方法的返回值将会影响模板代码的运行结果
    protected boolean isAlarm() {
        return true;
    }
}