package DesignPatterns.BuilderPattern;

public class BenzModel extends CarModel {

    @Override
    protected void start() {
        System.out.println("奔驰车启动");
    }

    @Override
    protected void stop() {
        System.out.println("奔驰车停止");
    }

    @Override
    protected void alarm() {
        System.out.println("奔驰车鸣喇叭");
    }

    @Override
    protected void engineBoom() {
        System.out.println("奔驰车发动引擎");
    }

}