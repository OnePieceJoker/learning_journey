package DesignPatterns.FactoryPattern;

public class BlackHuman implements Human {

    @Override
    public void getColor() {
        System.out.println("黑色人种");
    }

    @Override
    public void talk() {
        System.out.println("黑色人种说话");
    }

}