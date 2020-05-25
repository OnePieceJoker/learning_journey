package DesignPatterns.StrategyPattern;

public class Client {
    
    public static void main(String[] args) {
        int a = 10;
        int b = 5;
        System.out.println("运行结果为：" + Calculator.ADD.exec(a,b));
    }
}