package DesignPatterns.PrototypePattern;

import java.util.ArrayList;

public class Thing implements Cloneable {

    private ArrayList<String> arrayList = new ArrayList<String>();

    public void setValue(String value) {
        this.arrayList.add(value);
    }

    public ArrayList<String> getValue() {
        return this.arrayList;
    }

    @Override
    public Thing clone() {
        Thing thing = null;
        try {
            // 这是浅拷贝，clone的对象之间可以共享arrayList变量
            // Object类提供的clone方法只是拷贝本对象，其对象内部的数组，引用对象等都不拷贝
            // 对于基本类型以及Sting类型是会对其拷贝的
            // 使用原型模式时，引用的成员变量必须满足两个条件才不会被拷贝：一是类的成员变量，
            // 而不是方法内变量；二是必须是一个可变的引用对象，而不是一个原始类型或不可变对象。
            thing = (Thing) super.clone();
            // 深拷贝
            thing.arrayList = (ArrayList<String>) this.arrayList.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return thing;
    }
}