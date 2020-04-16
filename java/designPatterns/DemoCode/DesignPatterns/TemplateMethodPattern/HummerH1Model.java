package DesignPatterns.TemplateMethodPattern;

public class HummerH1Model extends HummerModel {

    private boolean alarmFlag = true;

    @Override
    protected void start() {
        System.out.println("H1 Hummer start");
    }

    @Override
    protected void stop() {
        System.out.println("H1 Hummer stop");
    }

    @Override
    protected void alarm() {
        System.out.println("H1 Hummer raise the alarm");
    }

    @Override
    protected void engineBoom() {
        System.out.println("engine boom");
    }

    protected boolean isAlarm() {
        return this.alarmFlag;
    }

    public void setAlarm(Boolean isAlarm) {
        this.alarmFlag = isAlarm;
    }

}