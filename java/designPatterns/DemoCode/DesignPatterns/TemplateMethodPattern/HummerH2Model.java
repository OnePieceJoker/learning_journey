package DesignPatterns.TemplateMethodPattern;

public class HummerH2Model extends HummerModel {

    @Override
    protected void start() {
        System.out.println("H2 Hummer start");
    }

    @Override
    protected void stop() {
        System.out.println("H2 Hummer stop");
    }

    @Override
    protected void alarm() {
        System.out.println("H2 Hummer raise the alarm");
    }

    @Override
    protected void engineBoom() {
        System.out.println("engine boom");
    }

    protected boolean isAlarm() {
        return false;
    }

}