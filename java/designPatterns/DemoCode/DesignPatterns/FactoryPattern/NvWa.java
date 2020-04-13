package DesignPatterns.FactoryPattern;

public class NvWa {

    public static void main(String[] args) {
        // 声明工厂类
        AbstractHumanFactory YinYangLu = new HumanFactory();
        System.out.println("first create human");
        Human blackHuman = YinYangLu.createHuman(BlackHuman.class);
        blackHuman.getColor();
        blackHuman.talk();
        System.out.println("second create human");
        Human yellowHuman = YinYangLu.createHuman(YellowHuman.class);
        yellowHuman.getColor();
        yellowHuman.talk();
        System.out.println("used simple factory pattern to create human");
        Human yellowHumanBySFP = HumanFactory.createHumanBySimpleFactoryPattern(YellowHuman.class);
        yellowHumanBySFP.getColor();
        yellowHumanBySFP.talk();
        System.out.println("升级为多个工厂类生成对象");
        Human yellowHumanByFactory = (new HumanFactory()).createHuman();
        yellowHumanByFactory.getColor();
        yellowHumanByFactory.talk();
    }

}