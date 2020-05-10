package DesignPatterns.ChainofResponsibilityPattern;

import java.util.ArrayList;
import java.util.Random;

public class Client {

    public static void main(String[] args) {
        // 定义几位女性
        Random random = new Random();
        ArrayList<IWomen> arrayList = new ArrayList<IWomen>();
        for (int i = 0; i < 5; i++) {
            arrayList.add(new Women(random.nextInt(4), "我要出去逛街"));
        }
        // 定义三个请示对象
        FatherHandler father = new FatherHandler();
        HusbandHandler husband = new HusbandHandler();
        SonHandler son = new SonHandler();
        father.setNext(husband);
        husband.setNext(son);
        for (IWomen women : arrayList) {
            father.HandleMessage(women);
        }
    }
    
}