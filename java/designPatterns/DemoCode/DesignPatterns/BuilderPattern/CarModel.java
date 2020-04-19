package DesignPatterns.BuilderPattern;

import java.util.ArrayList;

/**
 *
 * @author Mr.Joker
 * @date 2020/04/19
 * @time 14:53:29
 * @description 车对象的模型抽象类
 */
public abstract class CarModel {

    // 这个参数用于指定方法的执行顺序
    private ArrayList<String> sequence = new ArrayList<String>();

    // 多个方法
    protected abstract void start();

    protected abstract void stop();

    protected abstract void alarm();

    protected abstract void engineBoom();

    final public void run() {
        // 循环得到执行顺序
        for (int i = 0; i < this.sequence.size(); i++) {
            String actionName = this.sequence.get(i);
            if ("start".equalsIgnoreCase(actionName)) {
                this.start();
            } else if ("stop".equalsIgnoreCase(actionName)) {
                this.stop();
            } else if ("alarm".equalsIgnoreCase(actionName)) {
                this.alarm();
            } else if ("engine Boom".equalsIgnoreCase(actionName)) {
                this.engineBoom();
            }
        }
    }

    final public void setSequence(ArrayList<String> sequence) {
        this.sequence = sequence;
    }
}