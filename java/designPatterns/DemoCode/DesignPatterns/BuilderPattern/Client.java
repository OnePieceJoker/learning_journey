package DesignPatterns.BuilderPattern;

import java.util.ArrayList;

/**
 *
 * @author Mr.Joker
 * @date 2020/04/19
 * @time 14:51:56
 * @description 建造者模式场景类，配合了模板方法模式
 */
public class Client {

    public static void main(String[] args) {
        // 未使用建造者模式
        // 需求：要可以随意组装车启动顺序
        // BenzModel benz = new BenzModel();
        // // 定义启动顺序
        // ArrayList<String> sequence = new ArrayList<String>();
        // sequence.add("engine Boom");
        // sequence.add("start");
        // sequence.add("stop");
        // benz.setSequence(sequence);
        // benz.run();
        // // 新需求：再来个宝马车，定义新的启动顺序
        // BMWModel bmw = new BMWModel();
        // sequence.clear();
        // sequence.add("start");
        // sequence.add("engine Boom");
        // sequence.add("stop");
        // bmw.setSequence(sequence);
        // bmw.run();

        // 建造者模式
        // ArrayList<String> sequence = new ArrayList<String>();
        // // 定义执行顺序
        // sequence.add("engine Boom");
        // sequence.add("start");
        // sequence.add("alarm");
        // sequence.add("stop");
        // BenzBuilder benzBuilder = new BenzBuilder();
        // benzBuilder.setSequence(sequence);
        // // 得到奔驰车
        // BenzModel benz = (BenzModel) benzBuilder.getCarModel();
        // benz.run();

        // 带有导演类的建造者模式
        Director director = new Director();
        director.getABenzModel().run();
        director.getBBenzModel().run();
        director.getABMWModel().run();
        director.getBBMWModel().run();
    }
}