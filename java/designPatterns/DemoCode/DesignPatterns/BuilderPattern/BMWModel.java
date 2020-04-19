package DesignPatterns.BuilderPattern;

public class BMWModel extends CarModel {

    @Override
    protected void start() {
        System.out.println("宝马车启动");
    }

    @Override
    protected void stop() {
        System.out.println("宝马车停止");
    }

    @Override
    protected void alarm() {
        System.out.println("宝马车鸣喇叭");
    }

    @Override
    protected void engineBoom() {
       System.out.println("宝马车发动引擎"); 
    }

}