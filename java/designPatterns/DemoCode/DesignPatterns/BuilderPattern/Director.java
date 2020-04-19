package DesignPatterns.BuilderPattern;

import java.util.ArrayList;

/**
 *
 * @author Mr.Joker
 * @date 2020/04/19
 * @time 15:18:25
 * @description 建造者模式导演类
 */
public class Director {

    private ArrayList<String> sequence = new ArrayList<String>();
    private BenzBuilder benzBuilder = new BenzBuilder();
    private BMWBuilder bmwBuilder = new BMWBuilder();

    // 多种启动顺序的方法
    public BenzModel getABenzModel() {
        // 清理掉sequence
        this.sequence.clear();
        // 定义执行顺序
        this.sequence.add("start");
        this.sequence.add("stop");
        this.benzBuilder.setSequence(this.sequence);
        return (BenzModel) this.benzBuilder.getCarModel();
    }

    public BenzModel getBBenzModel() {
        // 清理掉sequence
        this.sequence.clear();
        // 定义执行顺序
        this.sequence.add("start");
        this.sequence.add("engine Boom");
        this.sequence.add("stop");
        this.benzBuilder.setSequence(this.sequence);
        return (BenzModel) this.benzBuilder.getCarModel();
    }

    public BMWModel getABMWModel() {
        // 清理掉sequence
        this.sequence.clear();
        // 定义执行顺序
        this.sequence.add("start");
        this.sequence.add("stop");
        this.bmwBuilder.setSequence(this.sequence);
        return (BMWModel) this.bmwBuilder.getCarModel();
    }

    public BMWModel getBBMWModel() {
        // 清理掉sequence
        this.sequence.clear();
        // 定义执行顺序
        this.sequence.add("start");
        this.sequence.add("engine Boom");
        this.sequence.add("stop");
        this.bmwBuilder.setSequence(this.sequence);
        return (BMWModel) this.bmwBuilder.getCarModel();
    }

}