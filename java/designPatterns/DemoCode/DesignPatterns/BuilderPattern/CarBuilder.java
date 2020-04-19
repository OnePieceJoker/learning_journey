package DesignPatterns.BuilderPattern;

import java.util.ArrayList;

/**
 *
 * @author Mr.Joker
 * @date 2020/04/19
 * @time 15:11:01
 * @description 定义建造者
 */
public abstract class CarBuilder {

    public abstract CarModel getCarModel();

    public abstract void setSequence(ArrayList<String> sequence);
}