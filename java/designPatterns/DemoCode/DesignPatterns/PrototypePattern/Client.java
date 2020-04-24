package DesignPatterns.PrototypePattern;

import java.util.Random;

public class Client {

    private static int MAX_COUNT = 6;
    public static void main(String[] args) {
        // int i = 0;
        // Mail mail = new Mail(new AdvTemplate());
        // mail.setTail("...bala");
        // while (i < MAX_COUNT) {
        //     Mail cloneMail = mail.clone();
        //     cloneMail.setAppellation(getRandString(5) + " 先生（女士）");
        //     cloneMail.setReceiver(getRandString(5) + "@" + getRandString(8) + ".com");
        //     sendMail(cloneMail);
        //     i++;
        // }

        // 原型模式使用注意事项一：构造函数不会被执行
        // Mail mail = new Mail(new AdvTemplate());
        // System.out.println("接下来是clone来的对象");
        // Mail cloneMail = mail.clone();

        // 原型模式使用注意事项二：浅拷贝与深拷贝
        Thing thing = new Thing();
        thing.setValue("张三");
        Thing cloneThing = thing.clone();
        cloneThing.setValue("李四");
        System.out.println(thing.getValue());
    }

    public static String getRandString(int maxLength) {
        String source = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuffer buffer = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < maxLength; i++) {
            buffer.append(source.charAt(random.nextInt(source.length())));
        }
        return buffer.toString();
    }

    public static void sendMail(Mail mail) {
        System.out.println("标题：" + mail.getSubject() + "\t收件人：" 
                            + mail.getReceiver() + "\t...发送成功");
    }

}